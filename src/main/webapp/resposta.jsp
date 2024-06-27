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
        <p>Considerando que a m�dia de leitura de uma p�gina � 1 minuto, o seu livro levar� <%= array[0] %> horas, <%= array[1] %> minutos e <%= array[2] %> segundos para ser completo</p>
        <p>Voc� j� leu <%= request.getAttribute("estimativa") %>% do livro</p>
        <p>Este livro est� dispon�vel em <%= request.getAttribute("linguas") %> l�nguas (ou mais)</p>
    </body>
</html>