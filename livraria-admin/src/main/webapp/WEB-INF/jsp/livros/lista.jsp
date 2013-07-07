<c:if test="${not empty mensagem}">
	<p class="mensagem">
		${mensagem}
	</p>
</c:if>
<h3>Lista de Livros</h3>
<ul>
<c:forEach items="${livroList}" var="livro">
    <li>
		<img src="${linkTo[LivrosController].capa[livro.isbn] }"
			width="70" height="100">
		${livro.titulo} - ${livro.descricao} -
		<a href="${linkTo[LivrosController].edita[livro.isbn] }">
			Modificar
		</a>
	</li>
</c:forEach>
</ul>
