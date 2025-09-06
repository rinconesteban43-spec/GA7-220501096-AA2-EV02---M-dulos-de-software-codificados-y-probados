/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Cita;
import conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitaDAO {

    // Método para insertar una cita
   public boolean insertarCita(Cita cita) {
    String sql = "INSERT INTO cita (fecha, hora, estado, descripcion_problema, id_servicio, Cliente_id_usuario, Empleado_id_admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    // 🔍 Agregamos logs para depurar
    System.out.println("📌 Obteniendo conexión desde insertarCita...");
    try (Connection conn = ConexionBD.getConnection()) {
        System.out.println("📌 Conexión en DAO: " + conn);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, cita.getFecha());
            ps.setTime(2, cita.getHora());
            ps.setString(3, cita.getEstado());
            ps.setString(4, cita.getDescripcionProblema());
            ps.setInt(5, cita.getIdServicio());
            ps.setInt(6, cita.getClienteIdUsuario());
            ps.setInt(7, cita.getEmpleadoIdAdmin());

            int filas = ps.executeUpdate();
            return filas > 0;
        }

    } catch (SQLException e) {
        System.out.println("❌ Error al insertar cita: " + e.getMessage());
        return false;
    }
}

    // Método para obtener todas las citas
    public ArrayList<Cita> listarCitas() {
        ArrayList<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM cita";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getInt("idCita"));
                c.setFecha(rs.getDate("fecha"));
                c.setHora(rs.getTime("hora"));
                c.setEstado(rs.getString("estado"));
                c.setDescripcionProblema(rs.getString("descripcion_problema"));
                c.setIdServicio(rs.getInt("id_servicio"));
                c.setClienteIdUsuario(rs.getInt("Cliente_id_usuario"));
                c.setEmpleadoIdAdmin(rs.getInt("Empleado_id_admin"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar citas: " + e.getMessage());
        }
        return lista;
    }
}