/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DB;

import Modelo.Usuario;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yuliana Amaya
 */
public class Operacion_Prueba {

    private final String SQL_INSERT = "INSERT INTO usuarios(emailUsuario, nombres, apellidos, feche_Nacimiento, contraseña) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "update usuarios set nombres=?, apellidos=?, fecha_nacimiento=? where emailUsuario = ?";
    private final String SQL_delete = "delete * from usuarioswhere emailUsuario = ?";

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
            stmt.setDate(index++, new Date(1996, 5, 22));
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

    public int upddate(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, usuario.getFirst_name());
            stmt.setString(index++, usuario.getLast_name());
            stmt.setDate(index++, new Date(1996, 5, 23));
            stmt.setString(index++, usuario.getEmail());
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

    public int delete(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, usuario.getFirst_name());
            stmt.setString(index++, usuario.getLast_name());
            stmt.setDate(index++, new Date(1996, 5, 23));
            stmt.setString(index++, usuario.getEmail());
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

    public int verificarEmail(String email) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rows = 0, band = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select count(*) from usuarios");
            while (rs.next()) {
                band = rs.getInt(1);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return band;
    }

    public int selectMeses(Date dateini, Date datefin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int meses = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select date_part('month',age('" + datefin + "', '" + dateini + "')) as meses");
            while (rs.next()) {
                meses = rs.getInt("meses");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return meses;
    }
}
