READ ME para el servlet de cita:

TallerXpert - Gestión de Citas

Este proyecto implementa un módulo de registro de citas para un taller mecánico, utilizando Java (Servlets y JSP), MySQL y HTML.

✅ Requisitos previos

Java JDK 8+

Apache Tomcat 9+

MySQL 5.7 o superior

IDE (Eclipse, IntelliJ o NetBeans)

Driver JDBC de MySQL agregado al proyecto (mysql-connector-j.jar)

⚙️ Configuración de la Base de Datos

Crear la base de datos:

CREATE DATABASE tallerxpert;
USE tallerxpert;


Crear tablas (mínimas necesarias):

CREATE TABLE cliente (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    correo VARCHAR(100)
);

CREATE TABLE cita (
    idCita INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    hora TIME,
    estado VARCHAR(20),
    descripcion_problema TEXT,
    id_servicio INT,
    Cliente_id_usuario INT,
    Empleado_id_admin INT,
    FOREIGN KEY (Cliente_id_usuario) REFERENCES cliente(id_usuario)
);


Insertar clientes de prueba:

INSERT INTO cliente (nombre, correo) VALUES
('María Gómez', 'maria@example.com'),
('Carlos Ramirez', 'carlos@example.com'),
('Luis Martinez', 'luis@example.com'),
('Juan Perez', 'juan@example.com'),
('Laura Gomez', 'laura@example.com');

📂 Estructura del Proyecto
src/
 ├── conexion/
 │    └── ConexionBD.java
 ├── dao/
 │    └── CitaDAO.java
 ├── modelo/
 │    └── Cita.java
 ├── servlets/
 │    └── CitaServlet.java
web/
 └── formularioCita.html

🔗 Configuración de la Conexión

En conexion/ConexionBD.java:

private static final String URL = "jdbc:mysql://localhost:3306/tallerxpert";
private static final String USER = "root";
private static final String PASSWORD = "tu_contraseña";

🖊️ Formulario para Registrar Citas

Archivo: formularioCita.html

Permite ingresar:

Fecha

Hora

Selección de cliente

Descripción del problema

Valores ocultos:

idServicio = 1

empleadoIdAdmin = 1

Ejemplo del formulario:

<form action="CitaServlet" method="post">
    <label for="fecha">Fecha:</label>
    <input type="date" id="fecha" name="fecha" required><br><br>

    <label for="hora">Hora:</label>
    <input type="time" id="hora" name="hora" required><br><br>

    <label for="clienteIdUsuario">Seleccione Cliente:</label>
    <select id="clienteIdUsuario" name="clienteIdUsuario" required>
        <option value="">-- Seleccione --</option>
        <option value="1">María Gómez (ID: 1)</option>
        <option value="2">Carlos Ramirez (ID: 2)</option>
        <option value="3">Luis Martinez (ID: 3)</option>
        <option value="4">Juan Perez (ID: 4)</option>
        <option value="5">Laura Gomez (ID: 5)</option>
    </select><br><br>

    <label for="descripcion">Descripción del problema:</label><br>
    <textarea id="descripcion" name="descripcion" rows="4" cols="50" required></textarea><br><br>

    <input type="hidden" name="idServicio" value="1">
    <input type="hidden" name="empleadoIdAdmin" value="1">

    <button type="submit">Registrar Cita</button>
</form>

🚀 Cómo Ejecutar el Proyecto

Importar el proyecto en el IDE.

Configurar el Build Path para incluir el mysql-connector-j.jar.

Asegurarse que Tomcat esté configurado.

Levantar Tomcat y desplegar el proyecto.

Acceder en el navegador:

http://localhost:8080/TallerXpert/formularioCita.html


Completar el formulario y enviar.

✅ Validaciones Implementadas

Verificación de conexión a la base de datos.

Control de integridad referencial (cliente debe existir).

Manejo de errores en DAO y Servlet.
