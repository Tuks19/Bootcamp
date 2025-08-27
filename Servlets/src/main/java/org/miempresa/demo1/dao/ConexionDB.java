package org.miempresa.demo1.dao;

import java.sql.*;

public class ConexionDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/Market";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    /**
     * Devuelve una nueva conexión a la base de datos.
     */
    public static Connection getConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    /**
     * Método para probar la conexión.
     */
    public static void probarConexion() {
        try (Connection conn = getConexion()) {
            if (conn != null && !conn.isClosed()) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("✅ Conexión exitosa a: " + meta.getDatabaseProductName());
                System.out.println("📊 Versión: " + meta.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            System.out.println("❌ Error en la conexión: " + e.getMessage());
        }
    }
}
