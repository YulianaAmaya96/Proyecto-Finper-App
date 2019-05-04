package DAO_DB;

import Modelo.*;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operaciones_Usuario {

    private final String SQL_INSERT = "INSERT INTO usuario(emailUsuario, nombres, apellidos, fecha_Nacimiento, contraseña) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE usuario SET nombres=?, apellidos=?, fecha_Nacimiento=? WHERE emailUsuario=?";
    private final String SQL_UPDATEPSW = "UPDATE usuario SET contraseña=? WHERE emailUsuario=?";
    private final String SQL_DELETE = "DELETE FROM usuario WHERE emailUsuario=?";
    private final String SQL_SELECT = "SELECT * FROM usuario WHERE emailUsuario= '";
    private final String SQL_SELECTEMAIL = "SELECT COUNT(*) FROM usuario WHERE emailUsuario= '";

    public int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, usuario.getEmail());
            stmt.setString(index++, usuario.getFirst_name());
            stmt.setString(index++, usuario.getLast_name());
            stmt.setDate(index++, usuario.getBorn_date());
            stmt.setString(index++, usuario.getPassword());
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, usuario.getFirst_name());
            stmt.setString(index++, usuario.getLast_name());
            stmt.setDate(index++, usuario.getBorn_date());
            stmt.setString(index++, usuario.getEmail());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int updatePsw(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATEPSW);
            int index = 1;
            stmt.setString(index++, usuario.getPassword());
            stmt.setString(index++, usuario.getEmail());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            int index = 1;
            stmt.setString(index++, usuario.getEmail());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }

    public int verificarEmail(String email) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rows = 0, band = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECTEMAIL + email + "'");
            while (rs.next()) {
                band = rs.getInt(1);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return band;
    }

    public int iniciarSesion(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rows = 0, band = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECTEMAIL + usuario.getEmail() + "'AND contraseña='" + usuario.getPassword() + "'");
            while (rs.next()) {
                band = rs.getInt(1);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return band;
    }

    public Usuario select(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "'");
            while (rs.next()) {
                usuario = new Usuario(rs.getString("nombres"), rs.getString("apellidos"), rs.getDate("fecha_Nacimiento"), rs.getString("emailUsuario"), rs.getString("contraseña"));
            }
            int rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return usuario;
    }

//    public int selectID(Usuario usuario) {
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        int rows = 0;
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("select * from ingreso where emailUsuario = '" + usuario.getEmail() + "'");
//            rows = stmt.getMaxRows();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return rows;
//    }
}
