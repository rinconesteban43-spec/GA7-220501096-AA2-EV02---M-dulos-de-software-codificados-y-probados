/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import modelo.Cita;
import dao.CitaDAO;
import java.sql.Date;
import java.sql.Time;

public class main {
    public static void main(String[] args) {
        // Crear un objeto Cita con datos de prueba
        Cita citaPrueba = new Cita(
                Date.valueOf("2025-08-23"),        // fecha
                Time.valueOf("10:30:00"),          // hora
                "Pendiente",                        // estado
                "Problema de frenos",               // descripción
                1,                                  // idServicio (valor fijo)
                2,                                  // clienteIdUsuario (valor fijo)
                1                                   // empleadoIdAdmin (valor fijo)
        );

        CitaDAO citaDAO = new CitaDAO();

        // Insertar la cita
        if (citaDAO.insertarCita(citaPrueba)) {
            System.out.println("✅ Cita insertada correctamente.");
        } else {
            System.out.println("❌ Error al insertar la cita.");
        }

        // Listar todas las citas
        System.out.println("\nLista de citas en la base de datos:");
        for (Cita c : citaDAO.listarCitas()) {
            System.out.println(c.getIdCita() + " | " + c.getFecha() + " " + c.getHora() + " | " + c.getEstado());
        }
    }
}