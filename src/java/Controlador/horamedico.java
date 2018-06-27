/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Crud;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "horamedico", urlPatterns = {"/horamedico"})
public class horamedico extends HttpServlet {

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
            request.getRequestDispatcher("error").forward(request, response);
        }else{
            String rutmedico = request.getParameter("medico");

            Conexion c = new Conexion();
            Connection con = c.Conectar();
            Crud cr = new Crud();
            String nombremed = cr.consultaDatoMedico(rutmedico, "nombre_medico");

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet horamedico</title>");  
                out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">"); 
                out.println("</head>");
                out.println("<body>");
                out.println("<h4>Horas disponibles por el médico : "+nombremed+"</h4>");
                try {
                    PreparedStatement ps = con.prepareStatement("Select * from tbl_horamedica hm INNER JOIN  tbl_medicocentro mc on hm.Cod_MedicoCentro=mc.Cod_MedicoCentro INNER JOIN tbl_centromedico cm on cm.Cod_CentroMedico=mc.Cod_CentroMedico INNER JOIN tbl_medico m on m.Cod_Medico=mc.Cod_Medico INNER JOIN tbl_especialidad e on m.Cod_Especialidad=e.Cod_Especialidad where m.rut_medico='"+rutmedico+"' and hm.estado_hora = 0");
                    ResultSet rs = ps.executeQuery();
                    String valor = "";
                        while(rs.next()){
                            out.println("<form name='horamedica' action='registrarhora' method='post'><input type='text' name='idhora' value='"+rs.getString("Cod_HoraMedica")+"' size='1' readonly><input type='text' value='"+rs.getString("nombre_centromedico")+"' readonly><input type='text' value='"+rs.getString("nombre_especialidad")+"' readonly><input type='text' value='"+rs.getString("fecha_medica")+"' readonly><input type='text' value='"+rs.getString("hora_medica")+"' readonly><input type='submit' name='submit' value='Pedir esta hora'></form>");
                            valor = rs.getString("nombre_centromedico");
                        }
                        if(valor.equals("")){
                            out.println("Ups :( , no existen horas con este médico.");
                        }
                } catch (SQLException ex) {
                    Logger.getLogger(horamedico.class.getName()).log(Level.SEVERE, null, ex);
                }
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
