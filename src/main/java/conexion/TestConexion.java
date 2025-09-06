/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

public class TestConexion {
    public static void main(String[] args) {
        if (ConexionBD.getConnection() != null) {
            System.out.println("✅ Prueba exitosa: Conectado a la base de datos.");
        } else {
            System.out.println("❌ Prueba fallida: No se pudo conectar.");
        }
    }
}
