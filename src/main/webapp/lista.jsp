<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="pt-br">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="icon" type="image/x-icon" href="./img/livro.png">
            <link rel="stylesheet" href="./css/resultado.css">
            <title>Lista</title>
        </head>
        <body>
            <header>
                <section>
                    <img src="./img/livros.png" id="livros">
                    <h1>Lista de livros</h1>
                </section>
                <section>
                    <h3>Adicionar livro à lista</h3>
                    <a href="index.html">
                        <img src="./img/adicionar.png" id="adicionar">
                    </a>
                </section>
            </header>
            <main>
                <section>
                    <article>
                        <img src="./img/livro.png">
                    </article>
                    <article>
                        <h1><%= request.getAttribute("titulo") %></h1>
                        <h2><%= request.getAttribute("autor") %></h2>
                        
                        <p>
	                    	<select>
	                    		<option value="idade">Obter idade do livro</option>
	                    		<option value="media">Média de leitura</option>
	                    		<option value="porcento">Porcentagem já lida</option>
	                    		<option value="qtd">Quantidade de línguas</option>
	                    	</select>
	                    </p>  
                    </article>
                </section>
            </main>
        </body>
    </html>