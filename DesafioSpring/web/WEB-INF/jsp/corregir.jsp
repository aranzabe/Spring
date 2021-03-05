<%-- 
    Document   : registrado
    Created on : 26-feb-2018, 22:59:08
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        
    </head>
    <body>
        <header>
        <div class="jumbotron text-center" style="height: 30px; background-color: #6C3483; color: white;">
            <div class="row">
                <div class="col-8 offset-2">
                    <h1>RESULTADO</h1></div>
                <div class="col-2">
                    <a href="index.htm" style="color: white;">Salir</a></div>
            </div>
        </div>
        </header>
        <main>
        <div class="container" style="text-align: center;">
                <div class="alert alert-success">
                    <c:forEach items="${usuario}" var="usu">
                        <input type="hidden" name="email" value="${usu.email}">
                        <strong>Tu nota del examen es: <h1>${usu.nota}</h1></strong>
                    </c:forEach>
                    
                </div>
                <a href="alumno.htm" class="btn btn-dark">Repetir examen</a>
        </div>
        </main>
        <footer style="width: 100%; background-color: #6C3483; color: white; bottom: 0; position: absolute; height: 80px;">
            <h2 style="font-size: 20px; padding: 20px 40px;">Copyright: María Megía Sánchez</h2>
        </footer>
    </body>
</html>
