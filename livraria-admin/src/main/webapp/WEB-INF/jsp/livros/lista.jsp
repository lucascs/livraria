<c:if test="${not empty mensagem}">
	<p class="mensagem">
		${mensagem}
	</p>
</c:if>
<h3>Lista de Livros</h3>
<ul>
<c:forEach items="${livroList}" var="livro">
    <li>${livro.titulo} - ${livro.descricao} -
		<a href="${linkTo[LivrosController].edita}?isbn=${livro.isbn}">
			Modificar
		</a>
	</li>
</c:forEach>
</ul>
