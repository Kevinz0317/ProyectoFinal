<%-- 
    Document   : sugerencias
    Created on : 9/05/2023, 7:25:01 p. m.
    Author     : Kevin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="modelo.Sugerencias" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrado</title>

    </head>
    <body>
         <nav>
            <a href="index.html">Inicio</a>
            <a href="sugerencias.html">Haz una Sugerencia</a>
            <a href="sobrenosotros.html">Sobre Nosotros</a>
            <a href="donaciones.html">Haz una Donación</a>
            <a href="iniciarsesion.html">Iniciar Sesion</a>
        </nav>
        <div class="container">
            <h2>Bienvenido usuario</h2>
            <h3>Nombre <%= request.getAttribute("nombre") %></h3>
            <h3>Email <%= request.getAttribute("email") %></h3>
        </div>
    </body>
</html>
