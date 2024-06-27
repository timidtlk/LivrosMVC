<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Livro</title>
    </head>
    <body>

        <h1><%= request.getAttribute("titulo") %></h1>
        <h2><%= request.getAttribute("autor") %></h2>

        <p>Este livro possui <%= request.getAttribute("idade") %> anos</p>
        
        <%
        	
        	int[] array = (int[]) request.getAttribute("estimativa");
        
        %>
        <p>Considerando que a média de leitura de uma página é 1 minuto, o seu livro levará <%= array[0] %> horas, <%= array[1] %> minutos e <%= array[2] %> segundos para ser completo</p>
        <p>Você já leu <%= request.getAttribute("estimativa") %>% do livro</p>
        <p>Este livro está disponível em <%= request.getAttribute("linguas") %> línguas (ou mais)</p>
    </body>
</html>