package vallegrande.edu.pe.model;

/*
 * ==========================================================
 * CLASE: Conexion
 * CAPA: Modelo (Model)
 * DESCRIPCIÓN:
 * Se encarga de establecer la conexión con la base de datos
 * MySQL mediante JDBC.
 * ==========================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Datos de conexión (se modificarán cuando tengamos MySQL)
    private static final String URL = "jdbc:mysql://prueba.cb2wjgxydz30.us-east-1.rds.amazonaws.com:3306/sistema_expediciones";
    private static final String USER = "admin";
    private static final String PASSWORD = "Torres2026";

    public Connection conectar() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }

        return conexion;
    }
}