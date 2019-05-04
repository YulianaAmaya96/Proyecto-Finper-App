package DAO_DB;

import Modelo.*;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operaciones_Ahorro {

    public int insert(Ahorro ahorro) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("insert into ahorro(idahorrousuario, valorahorro, usuario_emailUsuario) values (?,?,?)");
            int index = 1;
            ps.setInt(index++, ahorro.getIdAhorro());
            ps.setDouble(index++, ahorro.getValorAhorro());
            ps.setString(index++, ahorro.getUsuario().getEmail());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Ahorro ahorro) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("update ahorro set valorahorro=? where usuario_emailUsuario = ?");
            int index = 1;
            ps.setDouble(index++, ahorro.getValorAhorro());
            ps.setString(index++, ahorro.getUsuario().getEmail());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(Ahorro ahorro) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("delete from ahorro where usuario_emailUsuario = ?");
            int index = 1;
            ps.setString(index++, ahorro.getUsuario().getEmail());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }

    public Ahorro select(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Ahorro ahorro = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from ahorro where usuario_emailUsuario = '" + usuario.getEmail() + "'");
            while (rs.next()) {
                ahorro = new Ahorro(rs.getInt("idahorro"), rs.getDouble("valorahorro"), usuario);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ahorro;
    }
}
