<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        
    </head>

    <body>
    <header>
        <div class="jumbotron text-center" style="height: 30px; background-color: #6C3483; color: white;">
            <h1>REALIZAR TEST</h1>
        </div>
    </header>
    <main>
        <div class="container">
            <div class="row">
                <div class="offset-2 col-8">
                    <form action="profesor.htm" method="post">
                        <h1>Inicio Sesión</h1>
                        <div class="form-group">
                          <label for="email">Email:</label>
                          <input type="email" class="form-control" name="email" id="email">
                        </div>
                        <div class="form-group">
                          <label for="pass">Contraseña:</label>
                          <input type="password" class="form-control" id="pass" name="pass">
                        </div>
                        <button type="submit" class="btn btn-primary" name="iniciar">Iniciar Sesión</button>
                    </form><br>
                    <a href="registro.htm" style="text-decoration: underline;">Regístrate</a>
                </div>
            </div>
        </div>
    </main>
        
        <footer style="width: 100%; background-color: #6C3483; color: white; bottom: 0; position: absolute; height: 80px;">
            <h2 style="font-size: 20px; padding: 20px 40px;">Copyright: María Megía Sánchez</h2>
        </footer>
    </body>
</html>
