/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Crud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author angel
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        String ruta =(String) session.getAttribute("rut");
        
        
        if(ruta == null){
            //conseguir parametros
            String rut = request.getParameter("rut");
            String clave = request.getParameter("clave");
            if(rut == null){
                request.getRequestDispatcher("error").forward(request, response);
            }else{
                Crud cr = new Crud();

                boolean rute = cr.consultaUsuario(rut);
                String error = "";
                if(rute){
                    boolean clavee = cr.consultaClave(rut,clave);
                    if(clavee){
                        session.setAttribute("rut", rut);
                        session.setMaxInactiveInterval(30);

                        request.getRequestDispatcher("menuUser").forward(request, response);
                    }else{
                        error = "Clave incorrecta.";
                    }
                }else{
                    error = "Usuario no existe.";
                }
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Error...</title>");  
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">");  
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<h1>Error : "+error+"</h1>");
                    out.println("<a href=\"loginusuario.jsp\" class=\"btn btn-outline-primary\">Intentar de nuevo...</a>");
                    out.println("</center>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            
        }else{
            request.getRequestDispatcher("menuUser").forward(request, response);
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
