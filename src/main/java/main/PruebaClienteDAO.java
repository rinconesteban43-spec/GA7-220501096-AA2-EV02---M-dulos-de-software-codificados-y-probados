/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.ClienteDAO;
import modelo.Cliente;

public class PruebaClienteDAO {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        // Crear un nuevo cliente con el campo 'direccion'
        Cliente cliente = new Cliente(
                "joaquin", 
                "fernandez", 
                "joaquin@example.com", 
                "3001234567",
                "Calle 123 #45-67", // dirección
                "miContrasena123"   // contraseña
        );

        // Guardar cliente en la base de datos
        boolean exito = clienteDAO.guardarCliente(cliente);
        if (exito) {
            System.out.println("Cliente insertado correctamente");
        } else {
            System.out.println("Error al insertar cliente");
        }

        // Listar clientes
        System.out.println("Lista de clientes:");
        clienteDAO.listarClientes().forEach(c -> 
            System.out.println(c.getIdUsuario() + " - " + c.getNombre() + " " + c.getApellido() + " - " + c.getDireccion())
        );
    }
    
}