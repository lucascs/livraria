<form action="${linkTo[LivrosController].salva }" method="post">
	<h2>Formulário de cadastro de livros</h2>
	<ul>
		<li>Título: <br/>
		    <input type="text" name="livro.titulo"
							value="${livro.titulo}"/></li>

		<li>Descrição: <br/>
		    <textarea name="livro.descricao">${livro.descricao
		    }</textarea></li>

		<li>ISBN: <br/>
		    <input type="text" name="livro.isbn"
							value="${livro.isbn}"/></li>

		<li>Preço: <br/>
		    <input type="text" name="livro.preco"
							value="${livro.preco}"/></li>

		<li>Data de publicação: <br/>
			<input type="text" name="livro.dataPublicacao"
							value="${livro.dataPublicacao}"/>
		</li>
	</ul>
	<input type="submit" value="Salvar" />
</form>
