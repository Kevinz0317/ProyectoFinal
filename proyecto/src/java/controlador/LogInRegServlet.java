/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ControlBase;
import java.sql.ResultSet;


/**
 *
 * @author Kevin
 */
@WebServlet(name = "LogInRegServlet", urlPatterns = {"/LogInRegServlet"})

public class LogInRegServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            ResultSet rs;
            ControlBase con=new ControlBase();
            String nombre = request.getParameter("nombre");
            String contraseña = request.getParameter("contra");
            String email="";
            con.conectar();
            
            if(accion.equals("registrar")){
                email = request.getParameter("email");         
                con.añadir(nombre, email, contraseña);
                request.setAttribute("nombre", nombre);
                request.setAttribute("email", email);
                con.desconectar();
                request.getRequestDispatcher("registrado.jsp").forward(request, response);            
            }
            if(accion.equals("iniciarsesion")){  
                rs=con.consultarDatos();
                
                while(rs.next()){    
                    if(nombre.equals(rs.getString("nombre"))&&contraseña.equals(rs.getString("contra"))){
                        nombre=rs.getString("nombre");
                        email=rs.getString("email");
                        request.setAttribute("nombre", nombre);
                        request.setAttribute("email", email);
                    }else{
                        request.setAttribute("nombre", "No existe o no coincide");
                        request.setAttribute("email", "No existe o no coincide");
                    }
                }
                con.desconectar();
                request.getRequestDispatcher("LogIn.jsp").forward(request, response);  
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInRegServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("  <link rel=\"stylesheet\" href=\"newcss.css\">\n");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String accion = request.getParameter("accion");
            ResultSet rs;
            ControlBase con=new ControlBase();
            String nombre = request.getParameter("nombre");
            String contraseña = request.getParameter("contra");
            String email="";
            con.conectar();
            
            if(accion.equals("registrar")){
                email = request.getParameter("email");         
                con.añadir(nombre, email, contraseña);
                request.setAttribute("nombre", nombre);
                request.setAttribute("email", email);
                con.desconectar();
                request.getRequestDispatcher("registrado.jsp").forward(request, response);            
            }
            if(accion.equals("iniciarsesion")){  
                rs=con.consultarDatos();
                
                while(rs.next()){    
                    if(nombre.equals(rs.getString("nombre"))&&contraseña.equals(rs.getString("contra"))){
                        nombre=rs.getString("nombre");
                        email=rs.getString("email");
                        request.setAttribute("nombre", nombre);
                        request.setAttribute("email", email);
                    }else{
                        request.setAttribute("nombre", "No existe o no coincide");
                        request.setAttribute("email", "No existe o no coincide");
                    }
                }
                con.desconectar();
                request.getRequestDispatcher("LogIn.jsp").forward(request, response);  
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInRegServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
