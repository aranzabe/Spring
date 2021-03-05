<%-- 
    Document   : mostrarClasico
    Created on : 21-feb-2018, 17:18:54
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
        Valores recogidos por el formulario clasico 3: <br/>
        Nombre: ${requestScope.Persona.nombre} <br/>
        Email ${requestScope.Persona.email} <br/>
        Edad ${requestScope.Persona.edad} <br/>
    </body>
</html>
