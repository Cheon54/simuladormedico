<%-- 
    Document   : ingresousuario
    Created on : 21-nov-2017, 0:17:59
    Author     : angel
--%>

<%@page import="Modelo.Prevision"%>
<%@page import="Modelo.Crud"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Modelo.Comuna"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/validacionjs.js"></script>
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
                        <form name="formulario" method="POST" action="inuser" onsubmit="return verificar()">
                            <table class="table">
                                <tr>
                                    <td><label class="control-label" for="rut">Ingrese Rut: </label></td>
                                    <td><input class="form-control" type="text" name="rut" id="rut" pattern="\d{7,8}-[\d|kK]{1}" placeholder="Ej: 12345678-9" required></td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="nombres">Ingrese Nombres: </label></td>
                                    <td><input class="form-control" type="text" name="nombres" id="nombres" pattern="[a-zA-Z]{3,10} [a-zA-Z]{3,10}" placeholder="Ej: Juan Pablo" required></td>
                                </tr>
                                <tr>
                                    <td><label>Ingrese Apellidos: </label></td>
                                    <td>
                                        <table class="table">
                                            <tr>
                                                <td>
                                                    <label class="control-label" for="apellidop">Paterno:</label>
                                                </td>
                                                <td>
                                                    <input class="form-control" type="text" name="apellidop" id="apellidop" pattern="[a-zA-Z]{3,20}" placeholder="Ej: Guitierrez" required>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="control-label" for="apellidom">Materno: </label>
                                                </td>
                                                <td>
                                                    <input class="form-control" type="text" name="apellidom" id="apellidom" pattern="[a-zA-Z]{3,20}" placeholder="Ej: Gonzales" required>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="fnac">Ingrese Fecha Nacimiento: </label></td>
                                    <td><input class="form-control" type="date" name="fnac" id="fnac" required></td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="genero">Ingrese Genero: </label></td>
                                    <td>
                                        <label class="custom-control custom-radio"><input class="custom-control-input" type="radio" name="genero" id="generoM" value="M" checked><span class="custom-control-indicator"></span>Masculino</label>
                                        <label class="custom-control custom-radio"><input class="custom-control-input" type="radio" name="genero" id="generoF" value="F"><span class="custom-control-indicator"></span>Femenino</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="telefono">Ingrese N°Telefono: </label></td>
                                    <td><input class="form-control" type="number" name="telefono" id="telefono" min="111111111" max="999999999" placeholder="Ej: 912345678" required></td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="email">Ingrese Email: </label></td>
                                    <td><input class="form-control" type="email" name="email" id="email" placeholder="Ej: ejemplo@dominio.cl" required></td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="comuna">Ingrese Comuna </label></td>
                                    <td><select class="form-control" name="comuna" id="comuna">
                                            <option value="0">Selecciona Comuna</option>
                                            <%
                                            LinkedList<Comuna> lista = Crud.getComunas();
                                            for (int i=0;i<lista.size();i++){
                                               out.println("<option value='"+lista.get(i).getId()+"'>"+lista.get(i).getNombre()+"</option>");
                                            }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="direccion">Ingrese Direccion: </label></td>
                                    <td><div class="form-row">
                                            <div class="col-md-8">
                                                <input class="form-control" type="text" name="direccion" id="direccion" pattern="\D{4,50}" placeholder="Ej: Calle Republica #50" required>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="input-group">
                                                    <span class="input-group-addon" id="basic-addon3">N°</span>
                                                    <input class="form-control" type="number" name="direccionnumero" id="direccionnumero" placeholder="Ej: #123" required>
                                                </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="prevision">Ingrese Prevision: </label></td>
                                    <td><select class="form-control" name="prevision" id="prevision">
                                            <option value="0">Selecciona Prevision</option>
                                            <%
                                            LinkedList<Prevision> lista2 = Crud.getPrevisiones();
                                            for (int i=0;i<lista.size();i++){
                                               out.println("<option value='"+lista2.get(i).getId()+"'>"+lista2.get(i).getNombre()+"</option>");
                                            }
                                            %>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td><label class="control-label" for="clave">Ingrese Clave: </label></td>
                                    <td><input class="form-control" type="password" name="clave" id="clave" pattern="[a-zA-Z0-9]{6,8}" placeholder="Entre 6 a 8 caracteres" required></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><button type="submit" class="btn btn-primary">Registrar</button></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

