/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/TallerXpert";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

   public static Connection getConnection() {
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("✅ Conexión exitosa a la base de datos.");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException("❌ No se encontró el Driver MySQL", e);
    } catch (SQLException e) {
        throw new RuntimeException("❌ Error de conexión: " + e.getMessage(), e);
    }
    return conn;
}
}
