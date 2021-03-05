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
        <title>Examen</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        
    </head>
    <body>
        <header>
        <div class="jumbotron text-center" style="height: 30px; background-color: #6C3483; color: white;">
            <div class="row">
                <div class="col-8 offset-2">
                    <h1>EXAMEN</h1></div>
                <div class="col-2">
                    <a href="profesor.htm" style="color: white;">Volver</a></div>
            </div>
        </div>
        </header>
        <main style="margin-bottom: 80px;">
            <div class="container">
            <c:if test="${mensaje!=null}">
            <div class="alert alert-success">
                <strong>Éxito!</strong>  Pregunta eliminada.
            </div>
            </c:if>
            <c:forEach items="${preguntas}" var="preg">
                <form name="formulario" action="examen.htm" method="POST">
                    <input type="hidden" name="id_preg" value="${preg.id_preg}">
                    <c:if test="${preg.tipo == 'radio'}">
                        <div class="form-group">
                            <h3 for="enun">${preg.enunciado}</h3>
                        </div>
                        <c:forEach items="${respuesta}" var="res">
                            <c:if test="${preg.id_preg == res.id_preg}">
                                <div class="form-group">
                                    <c:if test="${res.correcta == 0}">
                                        <input type="radio" value="" readonly="readonly"> ${res.descripcion}
                                    </c:if>
                                    <c:if test="${res.correcta == 1}">
                                        <input type="radio" value="" readonly="readonly" checked=""> ${res.descripcion}
                                    </c:if>
                                </div>
                            </c:if>
                        </c:forEach>
                        <input type="submit" name="eliminar" value="Eliminar" class="btn btn-danger"><br><br>
                    </c:if>
                    <c:if test="${preg.tipo == 'desarrollo'}">
                        <div class="form-group">
                            <h3 for="enun">${preg.enunciado}</h3>
                        </div>
                        <c:forEach items="${respuesta}" var="res">
                            <c:if test="${preg.id_preg == res.id_preg}">
                                <div class="form-group">
                                    <label for="resp">${res.descripcion}</label>
                                </div>
                            </c:if>
                        </c:forEach>
                        <input type="submit" name="eliminar" value="Eliminar" class="btn btn-danger"><br><br>
                    </c:if>
                    <c:if test="${preg.tipo == 'check'}">
                        <div class="form-group">
                            <h3 for="enun">${preg.enunciado}</h3>
                        </div>
                        <c:forEach items="${respuesta}" var="res">
                            <c:if test="${preg.id_preg == res.id_preg}">
                                <div class="form-group">
                                    <c:if test="${res.correcta == 0}">
                                        <input type="checkbox" value="" readonly="readonly"> ${res.descripcion}
                                    </c:if>
                                    <c:if test="${res.correcta == 1}">
                                        <input type="checkbox" value="" readonly="readonly" checked=""> ${res.descripcion}
                                    </c:if>
                                </div>
                            </c:if>
                        </c:forEach>
                        <input type="submit" name="eliminar" value="Eliminar" class="btn btn-danger"><br><br>
                    </c:if>
                </form>   
            </c:forEach>
            </div>
        </main>
        <footer style="width: 100%; background-color: #6C3483; color: white; bottom: 0; height: 80px;">
            <h2 style="font-size: 20px; padding: 20px 40px;">Copyright: María Megía Sánchez</h2>
        </footer>
    </body>
</html>
