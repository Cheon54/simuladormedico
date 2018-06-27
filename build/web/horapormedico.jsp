<%-- 
    Document   : horapormedico
    Created on : 05-dic-2017, 2:16:35
    Author     : angel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                        <h3>Busqueda por Médico.</h3>
                      </div>
                      <div class="form-group">
                        <a href="index.html" class="btn btn-outline-primary">Volver</a>
                      </div>
                    </form>   
                  </div>
                </div>
                <div class="col-sm-8">
                    <div class="row justify-content-center align-items-center">
                        <form name="formulario" method="POST" action="horamedico" onsubmit="return verificarmedico()">
                            <table class="table">
                                <tr>
                                    <td><label class="control-label" for="rut">Ingrese Medico: </label></td>
                                    <td>
                                        <select name="medico" id="medico">
                                            <option value="0">Seleccione un médico</option>
                                            <%
                                                Conexion c = new Conexion();
                                                Connection con = c.Conectar();
                                                PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_medico");
                                                ResultSet rs = ps.executeQuery();
                                                while(rs.next()){
                                                    out.println("<option value='"+rs.getString("rut_medico")+"'> "+rs.getString("nombre_medico")+" </option>");
                                                }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><button type="submit" class="btn btn-primary">Buscar</button></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
