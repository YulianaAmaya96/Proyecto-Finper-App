package DAO_DB;

import Controlador.Controlador_Egreso;
import Modelo.*;
import Servicios.*;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class Operaciones_Pasivo {

    public int insert(Pasivo pasivo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("insert into pasivo(nombrePasivo, descripcion, fechaPasivo, valorpPasivo, prioridad, usuario_emailUsuario, idEgreso) values (?,?,?,?,?,?,?)");
            int index = 1;
            ps.setString(index++, pasivo.getName_pasivo());
            ps.setString(index++, pasivo.getDescription_pasivo());
            ps.setDate(index++, pasivo.getDate_get_pasivo());
            ps.setDouble(index++, pasivo.getValue_pasivo());
            ps.setInt(index++, pasivo.getPrioridad());
            ps.setString(index++, pasivo.getUsuario().getEmail());
            Controlador_Egreso ce = new Controlador_Egreso();
            int i = ce.Consultar_Egreso(pasivo.getEgreso()).getId();
            ps.setInt(index++, i);
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Pasivo pasivo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("update pasivo set nombrepasivo=?, descripcion=?, fechapasivo=?, valorpasivo=?, estadoPasivo=?, prioridad=? where usuario_emailUsuario = ? and idpasivo = ? ");
            int index = 1;
//            ps.setString(index++, pasivo.getName_pasivo());
//            ps.setString(index++, pasivo.getDescription_pasivo());
//            ps.setTimestamp(index++, (Timestamp) pasivo.getDate_get_pasivo());
//            ps.setDouble(index++, pasivo.getValue_pasivo());
//            ps.setString(index++, pasivo.getEstadoPasivo());
//            ps.setInt(index++, pasivo.getPrioridad());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(Pasivo pasivo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("delete from pasivo where usuario_emailUsuario = ? and idpasivo = ? ");
            int index = 1;
//            ps.setString(index++, pasivo.getUsuario().getEmail());
//            ps.setInt(index++, pasivo.getId_pasivo());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }

    public ArrayList<Pasivo> selectAll(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Pasivo> pasivos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from pasivo where usuario_emailUsuario = '" + usuario.getEmail() + "'");
            pasivos = new ArrayList();
            while (rs.next()) {
//                Pasivo i = new Pasivo(rs.getInt("idpasivo"), rs.getString("nombrepasivo"), rs.getString("descripcion"), rs.getDate("fechaPasivo"), rs.getString("estadoPasivo"), rs.getDouble("valorpasivo"), rs.getInt("prioridad"), usuario);
//                pasivos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return pasivos;
    }

    public ArrayList<Pasivo> selectAll(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Pasivo> pasivos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from pasivo where usuario_emailUsuario = '" + usuario.getEmail() + "' and fechaPasivo between '" + inicial + " ' and '" + fin + "' ");
            pasivos = new ArrayList();
            while (rs.next()) {
//                Pasivo i = new Pasivo(rs.getInt("idpasivo"), rs.getString("nombrepasivo"), rs.getString("descripcion"), rs.getDate("fechaPasivo"), rs.getString("estadoPasivo"), rs.getDouble("valorpasivo"), rs.getInt("prioridad"), usuario);
//                pasivos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return pasivos;
    }

    public Pasivo selectID(Usuario usuario, Pasivo pasivo) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from pasivo where usuario_emailUsuario = '" + usuario.getEmail() + "' and fechaactivo= '" + pasivo.getDate_get_pasivo() + " ' and valorpasivo=" + pasivo.getValue_pasivo());
            while (rs.next()) {
//                pasivo = new Pasivo(rs.getInt("idpasivo"), rs.getString("nombrepasivo"), rs.getString("descripcion"), rs.getDate("fechaPasivo"), rs.getString("estadoPasivo"), rs.getDouble("valorpasivo"), rs.getInt("prioridad"), usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return pasivo;
    }

    public double selectTotal(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        double rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select sum(valorpasivo) as total from pasivo where usuario_emailUsuario = '" + usuario.getEmail() + "' and fechapasivo between '" + inicial + " ' and '" + fin + "' ");
            while (rs.next()) {
                rows = rs.getDouble("total");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }
}
