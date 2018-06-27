package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Prevision;
import Modelo.Crud;
import java.util.LinkedList;
import Modelo.Comuna;

public final class ingresousuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"Validaciones/validacionjs.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <h3>REGISTRO USUARIOS.</h3>\n");
      out.write("            <form name=\"formulario\" method=\"POST\" action=\"servlet\" onsubmit=\"return validarParametros();\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Rut: </label></td>\n");
      out.write("                        <td><input type=\"text\" name=\"rut\" id=\"rut\" pattern=\"\\d{7,8}-[\\d|kK]{1}\" placeholder=\"Ej: 12345678-9\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Nombres: </label></td>\n");
      out.write("                        <td><input type=\"text\" name=\"nombres\" id=\"nombres\" pattern=\"[a-zA-Z]{4,10} [a-zA-Z]{4,10}\" placeholder=\"Ej: Juan Pablo\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Apellidos: </label></td>\n");
      out.write("                        <td>\n");
      out.write("                            <table>\n");
      out.write("                                <tr><td><label>Paterno: </label></td><td><input type=\"text\" name=\"apellidop\" id=\"apellidop\" pattern=\"[a-zA-Z]{4,20}\" placeholder=\"Ej: Guitierrez\" required></td></tr>\n");
      out.write("                                <tr><td><label>Materno: </label></td><td><input type=\"text\" name=\"apellidom\" id=\"apellidom\" pattern=\"[a-zA-Z]{4,20}\" placeholder=\"Ej: Gonzales\" required></td></tr>\n");
      out.write("                            </table>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Fecha Nacimiento: </label></td>\n");
      out.write("                        <td><input type=\"date\" name=\"fnac\" id=\"fnac\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Genero: </label></td>\n");
      out.write("                        <td><label><input type=\"radio\" name=\"genero\" id=\"generoM\" value=\"M\" checked>Masculino</label>\n");
      out.write("                            <label><input type=\"radio\" name=\"genero\" id=\"generoF\" value=\"F\">Femenino</label></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese N°Telefono: </label></td>\n");
      out.write("                        <td><input type=\"number\" name=\"telefono\" id=\"telefono\" max=\"999999999\" placeholder=\"Ej: 912345678\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Email: </label></td>\n");
      out.write("                        <td><input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Ej: ejemplo@dominio.cl\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Comuna </label></td>\n");
      out.write("                        <td><select name=\"comuna\" id=\"comuna\">\n");
      out.write("                                <option value=\"0\">Selecciona Comuna</option>\n");
      out.write("                                ");

                                LinkedList<Comuna> lista = Crud.getComunas();
                                for (int i=0;i<lista.size();i++){
                                   out.println("<option value='"+lista.get(i).getId()+"'>"+lista.get(i).getNombre()+"</option>");
                                }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Direccion: </label></td>\n");
      out.write("                        <td><input type=\"text\" name=\"direccion\" id=\"direccion\" pattern=\"\\D{4,50}\" placeholder=\"Ej: Calle Republica #50\" required>\n");
      out.write("                            <label>Numero: </label><input type=\"number\" name=\"direccionnumero\" id=\"direccionnumero\" placeholder=\"Ej: #123\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Prevision: </label></td>\n");
      out.write("                        <td><select name=\"prevision\" id=\"prevision\">\n");
      out.write("                                <option value=\"0\">Selecciona Prevision</option>\n");
      out.write("                                ");

                                LinkedList<Prevision> lista2 = Crud.getPrevisiones();
                                for (int i=0;i<lista.size();i++){
                                   out.println("<option value='"+lista2.get(i).getId()+"'>"+lista2.get(i).getNombre()+"</option>");
                                }
                                
      out.write("\n");
      out.write("                            </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Ingrese Clave: </label></td>\n");
      out.write("                        <td><input type=\"password\" name=\"clave\" id=\"clave\" pattern=\"[a-zA-Z0-9]{6,8}\" placeholder=\"Entre 6 a 8 caracteres\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><br><input type=\"submit\" name=\"enviar\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
