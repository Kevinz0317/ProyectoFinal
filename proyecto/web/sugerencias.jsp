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
        <title>Lista de Sugerencias</title>
        <style>
            table, td, th {
                border: 1px solid black;
            }

            table {
                border-collapse: collapse;

                margin: 20px auto;
                width: 600px;
            }

            td {
                text-align: center;
            }
            tr:hover {
                background-color: lightcyan;
            }
        </style>
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
            <h2>LISTA DE COMENTARIOS:</h2>

            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Comentario</th>
                    <th>Calificacion</th>
                </tr>
                <%
                        ArrayList<Sugerencias> sugerencias = (ArrayList<Sugerencias>) request.getAttribute("sugerencias");
                        for (Sugerencias sugerencia : sugerencias) {
                %>
                <tr>
                    <td><%= sugerencia.getNombre() %></td>
                    <td><%= sugerencia.getSugerencia() %></td>
                    <td><%= sugerencia.getCalificacion() %></td>
                </tr>
                <%
                    }
                %>
            </table>
            <h3>Promedio de Calificaciones <%= request.getAttribute("promedioCalif") %></h3>
            <h3>Hay <%= request.getAttribute("cantidadSug") %> comentarios.</h3>
        </div>
    </body>
</html>
