package Servicios;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    //CREDENCIALES YULIANA
    // /*
    private static final String USUARIO = "postgres";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String PASS = "root";
    private static final String DB = "FINPER";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + DB;
    private static Driver driver = null;
    // */

    //CREDENCIALES ANTONIO
    /*
     private static final String USUARIO = "finper";
     private static final String DRIVER = "org.postgresql.Driver";
     private static final String PASS = "laclave";
     private static final String URL = "jdbc:postgresql://127.0.0.1:5432/Finperapp";
     private static Driver driver = null;
     */
    public static synchronized Connection getConnection() throws SQLException {
        if (driver == null) {
            try {
                Class jdbcDriverClass = Class.forName(DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                System.out.println("Fallo en cargar el driver jdbc");
            }
        }
        return DriverManager.getConnection(URL, USUARIO, PASS);
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
