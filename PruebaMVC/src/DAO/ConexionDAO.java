/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fabia
 */
public class ConexionDAO {
    private static ConexionDAO instancia;
    private Connection conexion;
 
    public ConexionDAO() throws Exception {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/mvc",
            "root",
            "");
        System.out.println("Conexion exitosa!");
    } catch (ClassNotFoundException e) {
        throw new Exception("Error al cargar el controlador JDBC.", e);
    } catch (SQLException e) {
        throw new Exception("Error al conectar a la base de datos.", e);
    }
}
    
    public static ConexionDAO obtenerInstancia() throws Exception {
        if (instancia == null) {
            instancia = new ConexionDAO();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
    
}

