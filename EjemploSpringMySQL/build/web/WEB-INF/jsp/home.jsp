<%-- 
    Document   : home
    Created on : 21-feb-2018, 17:48:23
    Author     : faranzabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JavaServer Pages Standard Tag Library (JSTL)  -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JDBC</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
    </head>
    <body>
        <h1> Mostrando con acceso a JDBC Template </h1>
        <div class="container">
            <div class="row">
                <p>
                    <a href="insertarJDBC.htm" class="btn btn-success">Agregar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Tfno</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- categoryDataBean -->
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> ${dato.DNI} </td>        
                                <td> ${dato.Nombre} </td>        
                                <td> ${dato.Tfno} </td>    
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
