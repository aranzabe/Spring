<%-- 
    Document   : login
    Created on : 26-feb-2018, 20:41:20
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profesor</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        
    </head>
    <body>
        <header>
        <div class="jumbotron text-center" style="height: 30px; background-color: #6C3483; color: white;">
            <div class="row">
                <div class="col-8 offset-2">
                    <h1>BIENVENIDO
                        <c:forEach items="${usuario}" var="usuario">
                            ${usuario.nombre}
                        </c:forEach></h1></div>
                <div class="col-2">
                    <a href="index.htm" style="color: white;">Salir</a></div>
            </div>
        </div>
        </header>
        <main style="margin-bottom: 80px;">
            <div class="container">
            <c:if test="${mensaje!=null}">
            <div class="alert alert-success">
                <strong>Éxito!</strong>  Pregunta añadida al examen.
            </div>
            </c:if>
            <ul class="list-group">
                <li><a href="radio.htm" class="list-group-item">Añadir pregunta tipo test</a><br><br></li>
                <li><a href="check.htm" class="list-group-item">Añadir pregunta con varias soluciones</a><br><br></li>
                <li><a href="desarrollo.htm" class="list-group-item">Añadir pregunta de desarrollo</a><br><br></li>
                <li><a href="examen.htm" class="list-group-item">Ver Examen</a><br><br></li>
            </ul>
            </div>
        </main>
        <footer style="width: 100%; background-color: #6C3483; color: white; bottom: 0; height: 80px;">
            <h2 style="font-size: 20px; padding: 20px 40px;">Copyright: María Megía Sánchez</h2>
        </footer>
    </body>
</html>
