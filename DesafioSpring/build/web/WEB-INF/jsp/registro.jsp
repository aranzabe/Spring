<%-- 
    Document   : registro
    Created on : 26-feb-2018, 22:55:49
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Registro</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        
    </head>
    <body>
        <header>
        <div class="jumbotron text-center" style="height: 30px; background-color: #6C3483; color: white;">
            <div class="row">
                <div class="col-8 offset-2">
                    <h1>REGISTRO</h1></div>
                <div class="col-2">
                    <a href="index.htm" style="color: white;">Volver</a></div>
            </div>
        </div>
        </header>
        <main style="margin-bottom: 50px;">
        <h2 style="text-align: center;">Formulario de Registro</h2>
        <div class="container">
            <div class="row">
                <div class="offset-4 col-4">
                <form action="registrado.htm" method="POST">
                    <div class="form-group">
                      <label for="email">Email:</label>
                      <input type="email" class="form-control" id="email" name="email" value="" >
                    </div>
                    <div class="form-group">
                      <label for="nombre">Nombre:</label>
                      <input type="text" class="form-control" id="nombre" name="nombre" value="" >
                    </div>
                    <div class="form-group">
                      <label for="apellido">Apellido:</label>
                      <input type="text" class="form-control" id="apellido" value="" name="apellido">
                    </div>
                    <div class="form-group">
                      <label for="pass">Contraseña:</label>
                      <input type="password" class="form-control" id="pass" value="" name="pass">
                    </div>
                    <div class="form-group">
                    <label>Rol: </label>
                    <div class="radio" style="margin-left: 20px;">
                          <input type="radio" class="form-check-input" name="rol" id="rol" value="profesor">Profesor
                    </div>
                    <div class="radio" style="margin-left: 20px;">
                          <input type="radio" class="form-check-input" name="rol" id="rol" value="alumno">Alumno
                    </div>
                    </div>
                    <button type="submit" class="btn btn-success">Registrar</button><br><br>
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
