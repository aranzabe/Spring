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
        <title>Alumno</title>
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
                <h1 style="text-align: center; text-decoration: underline; margin-bottom: 30px;">Realiza tu examen</h1>
            <form name="formulario" action="corregir.htm" method="POST">
                <% int cont = 0; %>
                <c:forEach items="${usuario}" var="usu">
                    <input type="hidden" name="email" value="${usu.email}">
                </c:forEach>
                <c:forEach items="${preguntas}" var="preg">
                    <c:if test="${preg.tipo == 'radio'}">
                        <div class="form-group">
                            <h3 for="enun">${preg.enunciado}</h3>
                        </div>
                        <c:forEach items="${respuesta}" var="res">
                            <c:if test="${preg.id_preg == res.id_preg}">
                                <div class="form-group">
                                    <input type="radio" value="${res.descripcion}" name="res<%=cont%>" readonly="readonly"> ${res.descripcion}
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <c:if test="${preg.tipo == 'desarrollo'}">
                        <div class="form-group">
                            <h3 for="enun">${preg.enunciado}</h3>
                        </div>
                        <c:forEach items="${respuesta}" var="res">
                            <c:if test="${preg.id_preg == res.id_preg}">
                                <div class="form-group">
                                    <textarea class="form-control" name="res<%=cont%>" rol="5" value=""></textarea>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <c:if test="${preg.tipo == 'check'}">
                        <div class="form-group">
                            <h3 for="enun">${preg.enunciado}</h3>
                        </div>
                        <c:forEach items="${respuesta}" var="res">
                            <c:if test="${preg.id_preg == res.id_preg}">
                                <div class="form-group">
                                    <input type="checkbox" value="${res.id_resp}" name="res<%=cont%>"  readonly="readonly"> ${res.descripcion}
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <div class="col-md-12"><hr></div>  
                    <% cont++; %>
                </c:forEach>
                <input type="submit" name="corregir" value="Corregir Examen" class="btn btn-success"><br><br>
            </form> 
            </div>
        </main>
        <footer style="width: 100%; background-color: #6C3483; color: white; bottom: 0; height: 80px;">
            <h2 style="font-size: 20px; padding: 20px 40px;">Copyright: María Megía Sánchez</h2>
        </footer>
    </body>
</html>
