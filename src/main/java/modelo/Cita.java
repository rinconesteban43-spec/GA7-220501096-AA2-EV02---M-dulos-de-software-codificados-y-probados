/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;
import java.sql.Time;

public class Cita {
    private int idCita;
    private Date fecha;
    private Time hora;
    private String estado;
    private String descripcionProblema;
    private int idServicio;
    private int clienteIdUsuario;
    private int empleadoIdAdmin;

    // Constructor vacío
    public Cita() {}

    // Constructor sin idCita (para insertar, ya que es autoincremental)
    public Cita(Date fecha, Time hora, String estado, String descripcionProblema,
                int idServicio, int clienteIdUsuario, int empleadoIdAdmin) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.descripcionProblema = descripcionProblema;
        this.idServicio = idServicio;
        this.clienteIdUsuario = clienteIdUsuario;
        this.empleadoIdAdmin = empleadoIdAdmin;
    }

    // Getters y setters
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHora() { return hora; }
    public void setHora(Time hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDescripcionProblema() { return descripcionProblema; }
    public void setDescripcionProblema(String descripcionProblema) { this.descripcionProblema = descripcionProblema; }

    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }

    public int getClienteIdUsuario() { return clienteIdUsuario; }
    public void setClienteIdUsuario(int clienteIdUsuario) { this.clienteIdUsuario = clienteIdUsuario; }

    public int getEmpleadoIdAdmin() { return empleadoIdAdmin; }
    public void setEmpleadoIdAdmin(int empleadoIdAdmin) { this.empleadoIdAdmin = empleadoIdAdmin; }
}
