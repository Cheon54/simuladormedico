/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Crud;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angel
 */
@WebServlet(name = "inuser", urlPatterns = {"/inuser"})
public class inuser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //conseguir parametros
        String rut = request.getParameter("rut");
        String nombres = request.getParameter("nombres");
        String apellidop = request.getParameter("apellidop");
        String apellidom = request.getParameter("apellidom");
        String fnac = request.getParameter("fnac");
        String genero = request.getParameter("genero");
        int fono = Integer.parseInt(request.getParameter("telefono"));
        String email = request.getParameter("email");
        int comuna = Integer.parseInt(request.getParameter("comuna"));
        String direccion = request.getParameter("direccion");
        int ndireccion = Integer.parseInt(request.getParameter("direccionnumero"));
        int prevision = Integer.parseInt(request.getParameter("prevision"));
        String clave = request.getParameter("clave");
        
        Crud ca = new Crud();

        boolean rute = ca.consultaUsuario(rut);
        if(rute){
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Ingreso...</title>");  
                out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">");  
                out.println("</head>");
                out.println("<body>");
                out.println("<center>");
                out.println("<h1>Ya existe una cuenta con este rut.</h1>");
                out.println("<a href=\"loginusuario.jsp\" class=\"btn btn-outline-primary\">Logeate...</a>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");
            }
            
        }else{
            Usuario user = new Usuario(rut, nombres, apellidop, apellidom, fnac, genero, fono, email, comuna, direccion, ndireccion,prevision, clave);
            String result = ca.insertarUsuario(user);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Ingreso...</title>");  
                out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">");  
                out.println("</head>");
                out.println("<body>");
                out.println("<center>");
                out.println("<h1>"+result+" "+nombres+"</h1>");
                out.println("<a href=\"loginusuario.jsp\" class=\"btn btn-outline-primary\">Logeate...</a>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
