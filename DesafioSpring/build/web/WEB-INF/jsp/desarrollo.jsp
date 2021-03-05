<%-- 
    Document   : alumno
    Created on : 11-mar-2018, 19:01:26
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pregunta 3</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        
    </head>
    <body>
        <header>
        <div class="jumbotron text-center" style="height: 30px; background-color: #6C3483; color: white;">
            <h1></h1>
            <div class="row">
                <div class="col-8 offset-2">
                    <h1>PREGUNTA DESARROLLO</h1></div>
                <div class="col-2">
                    <a href="profesor.htm" style="color: white;">Volver</a></div>
            </div>
        </div>
        </header>
        <main style="margin-bottom: 80px;">
    <div class="container">
        <div class="row">
            <div class="col-12">
        <form name="formulario" action="desarrollo.htm" method="POST">
            <div class="form-group">
                <label for="enun">Enunciado:</label><br>
                <textarea class="form-control" rows="4" name="enunciado"></textarea>
            </div>
            <div class="form-group">
                <label for="resp">Respuesta:</label><br>
                <textarea name="respuesta" rows="4" class="form-control"></textarea>
            </div>
            <input type="submit" name="guardar" value="Guardar" class="btn btn-success">
        </form>
            </div>
        </div>
    </div>
        </main>
        <footer style="width: 100%; background-color: #6C3483; color: white; bottom: 0; height: 80px;">
            <h2 style="font-size: 20px; padding: 20px 40px;">Copyright: María Megía Sánchez</h2>
        </footer>
    </body>
</html>
