package br.com.casadocodigo.livraria.aspecto;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class TransacoesInterceptor implements Interceptor{

	private EntityManager manager;

	public TransacoesInterceptor(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack,
			ResourceMethod method,
			Object controller) throws InterceptionException {
		try {
			manager.getTransaction().begin();

			stack.next(method, controller);

			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
	}

}
