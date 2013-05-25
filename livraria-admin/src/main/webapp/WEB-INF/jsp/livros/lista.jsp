<h3>Lista de Livros</h3>
<ul>
<c:forEach items="${livroList}" var="livro">
    <li>${livro.titulo} - ${livro.descricao}</li>
</c:forEach>
</ul>