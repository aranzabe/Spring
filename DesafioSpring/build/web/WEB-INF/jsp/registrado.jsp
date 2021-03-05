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
        <title>Registrado</title>
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
        <main style="margin-bottom: 80px;">
        <div class="container" style="text-align: center;">
                <div class="alert alert-success">
                    <strong>Usuario Registrado con éxito!</strong>
                </div>
            <c:forEach items="${usuario}" var="usu">
                <h1>Email: ${usu.email}<br>
                    Nombre: ${usu.nombre}<br>
                    Apellido: ${usu.apellido}<br>
                    Contraseña: ${usu.pass}<br>
                    Rol: ${usu.rol}<br></h1><br><br>
                    <a href="index.htm" class="btn btn-dark">Volver a Inicio</a>
                </form>
            </c:forEach>
        </div>
        </main>
        <footer style="width: 100%; background-color: #6C3483; color: white; bottom: 0; height: 80px;">
            <h2 style="font-size: 20px; padding: 20px 40px;">Copyright: María Megía Sánchez</h2>
        </footer>
    </body>
</html>
