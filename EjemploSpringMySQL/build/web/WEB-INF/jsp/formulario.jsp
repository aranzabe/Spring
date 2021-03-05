<%-- 
    Document   : formulario
    Created on : 25-feb-2018, 17:45:23
    Author     : faranzabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Inserción con JDBC Template </h1>
        <form name="formulario" method="POST" action="insertarJDBC.htm">
            <input type="text" name="dni" value="" placeholder="Escribe un nombre"/><br/>
            <input type="text" name="nombre" value="" placeholder="Escribe un email"/><br/>
            <input type="text" name="tfno" value="" placeholder="Escribe un teléfono"/><br/>
            <input type="submit" name="Aceptar" value="Aceptar"/>
        </form>
    </body>
</html>
