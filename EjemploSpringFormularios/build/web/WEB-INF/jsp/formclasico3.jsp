<%-- 
    Document   : formclasico
    Created on : 21-feb-2018, 17:09:28
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
        Formulario clasico 3<br/>
        <form name="formulario" method="POST" action="formclasico3.htm">
            <input type="text" name="nombre" value="" placeholder="Escribe un nombre"/>
            <input type="text" name="email" value="" placeholder="Escribe un email"/>
            <input type="number" name="edad" value="" />
            <input type="submit" name="Aceptar" value="Aceptar"/>
        </form>
    </body>
</html>
