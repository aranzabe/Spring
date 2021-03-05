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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pregunta 1</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

        <script>
            function num_input(){
                var num = $("#idnum").val();
                var resp = '';
                var cont=0;
                if(num>2){
                    while(cont<num){
                        $("#respuest").append("<div class='radio' style='margin-left: 20px;'><input type='radio' name='res' value='"+cont+"'><input type='text' value='' name='preg"+cont+"' id='"+cont+"' class='form-control' required><br></div>");
                        cont++;
                    }
                    $("#respuest").append("<input type='submit' name='guardar' value='Guardar' class='btn btn-success'>");
                }
            }
    

    
        </script>
    </head>
    <body>
        <header>
        <div class="jumbotron text-center" style="height: 30px; background-color: #6C3483; color: white;">
            <div class="row">
                <div class="col-8 offset-2">
                    <h1>PREGUNTA TIPO TEST</h1></div>
                <div class="col-2">
                    <a href="profesor.htm" style="color: white;">Volver</a></div>
            </div>
        </div>
        </header>
        
    <main style="margin-bottom: 80px;">
    <div class="container">
        <div class="row">
            <div class="col-12">
        <form name="formulario" action="radio.htm" method="POST">
            <div class="form-group">
                <label for="enun">Enunciado:</label><br>
                <textarea class="form-control" rows="5" name="enunciado" required></textarea>
            </div>
            <div class="form-group">
                <label for="num">Número de respuestas:</label><br>
                <input type="number" class="form-control" name="num" id="idnum" min="3" max="10" required>
            </div>
            <input type="button" name="aceptar" value="Aceptar" class='btn btn-success' onclick="num_input();"><br>
            <div id="respuest">
                <label>Opciones: </label>
            </div>
            
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
