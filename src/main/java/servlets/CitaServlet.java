/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import modelo.Cita;
import dao.CitaDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CitaServlet", urlPatterns = {"/CitaServlet"})
public class CitaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibir datos del formulario
        String fechaStr = request.getParameter("fecha");
        String horaStr = request.getParameter("hora");
        String descripcion = request.getParameter("descripcion");
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        int clienteId = Integer.parseInt(request.getParameter("clienteIdUsuario"));
        int empleadoId = Integer.parseInt(request.getParameter("empleadoIdAdmin"));

        // Asignar estado por defecto
        String estado = "Pendiente";

        // Crear objeto Cita
        Cita cita = new Cita(
                Date.valueOf(fechaStr),
                Time.valueOf(horaStr + ":00"), // formato hh:mm:ss
                estado,
                descripcion,
                idServicio,
                clienteId,
                empleadoId
        );

        // Insertar usando DAO
        CitaDAO citaDAO = new CitaDAO();
        boolean exito = citaDAO.insertarCita(cita);

        // Respuesta al navegador
        response.setContentType("text/html;charset=UTF-8");
        try (var out = response.getWriter()) {
            if (exito) {
                out.println("<h2>✅ Cita registrada correctamente</h2>");
            } else {
                out.println("<h2>❌ Error al registrar la cita</h2>");
            }
            out.println("<a href='formularioCita.html'>Volver</a>");
        }
    }
}