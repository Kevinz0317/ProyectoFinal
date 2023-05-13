/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import modelo.ISugerencias;
import modelo.Sugerencias;

/**
 *
 * @author Kevin
 */
public class SugerenciasServlet extends HttpServlet implements ISugerencias {

    private static final long serialVersionUID = 1L;

    private final ArrayList<Sugerencias> sugerencias = new ArrayList<>();
    private double promedio;

    public SugerenciasServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correoElectronico = request.getParameter("email");
        String sugerencia = request.getParameter("comentario");
        String calificacionString = request.getParameter("calificacion");
        int calificacion = 0;

        if (calificacionString != null && !calificacionString.isEmpty()) {
            calificacion = Integer.parseInt(calificacionString);
        }
        Sugerencias sug = new Sugerencias(nombre, correoElectronico, sugerencia, calificacion);
        sugerencias.add(sug);

        request.setAttribute("sugerencias", sugerencias);
        request.setAttribute("promedioCalif", calcularPromedio());
        request.setAttribute("cantidadSug", cantidadSugerencias());
        request.getRequestDispatcher("sugerencias.jsp").forward(request, response);
    }

    @Override
    public double calcularPromedio() {
        int totCalif = 0;
        if (sugerencias != null) {
            for (Sugerencias sugerencia : sugerencias) {
                totCalif += sugerencia.getCalificacion();
            }
            promedio = (double) totCalif / sugerencias.size();
        } else {
            promedio = 0.0;
        }
        return promedio;
    }

    @Override
    public int cantidadSugerencias() {
        return sugerencias.size();
    }

}
