<%-- 
    Document   : mostrarClasico
    Created on : 21-feb-2018, 17:18:54
    Author     : faranzabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${lista}" var="dato">
        <tr>
            <td><c:out value="${dato}"/></td>     
        </tr>
    </c:forEach>
</body>
</html>
