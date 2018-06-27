<%-- 
    Document   : loginusuario
    Created on : 27-nov-2017, 15:40:54
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <style>
            .table > tbody > tr > td {
                vertical-align: middle;
            }
            .container {
                justify-content: center;
                align-content: center;
                padding-top: 20px;
                border: none;
                -webkit-box-shadow: 0px 0px 49px 14px rgba(188,190,194,0.39);
                -moz-box-shadow: 0px 0px 49px 14px rgba(188,190,194,0.39);
                box-shadow: 0px 0px 49px 14px rgba(188,190,194,0.39);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row text-center align-items-center">
                <div class="col-sm-4">
                  <div class="row justify-content-center align-items-center">
                    <form>
                      <div class="form-group">
                        <h3>REGISTRO USUARIOS.</h3>
                      </div>
                        <div class="form-group">
                          <a href="index.html" class="btn btn-outline-primary">Volver</a>
                        </div>
                    </form>   
                  </div>
                </div>
                <div class="col-sm-8">
                    <div class="row justify-content-center align-items-center">
                        <form name="formulario2" method="POST" action="login">
                            <table class="table">
                                <tr>
                                    <td><label class="control-label" for="rut">Ingrese Rut: </label></td>
                                    <td><input class="form-control" type="text" name="rut" id="rut" pattern="\d{7,8}-[\d|kK]{1}" placeholder="Ingrese rut" required></td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="clave">Ingrese Contraseña: </label></td>
                                    <td><input class="form-control" type="password" name="clave" id="clave" pattern="[a-zA-Z0-9]{6,8}" placeholder="Ingrese Clave" required></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><button type="submit" class="btn btn-primary">Logear</button></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
