package DAO_DB;

import Controlador.Controlador_Ingreso;
import Modelo.*;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class Operaciones_Activo {
       

    public int insert(Activo activo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("insert into activo(nombreActivo, descripcion, fechaActivo, valoractivo, usuario_emailUsuario, idIngreso) values (?,?,?,?,?,?)");
            int index = 1;
            ps.setString(index++, activo.getName_activo());
            ps.setString(index++, activo.getDescription_activo());
            ps.setDate(index++, activo.getDate_get_activo());
            ps.setDouble(index++, activo.getValue_activo());
            ps.setString(index++, activo.getUsuario().getEmail());
            Controlador_Ingreso ci= new Controlador_Ingreso(); 
            ps.setInt(index++, ci.Consultar_Ingreso(activo.getIngreso()).getId()); 
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Activo activo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("update activo set nombreactivo=?, descripcion=?, fechaactivo=?, fechafin=?, valoractivo=?, where usuario_emailUsuario = ? and idactivo = ? ");
            int index = 1;
//            ps.setString(index++, activo.getName_activo());
//            ps.setString(index++, activo.getDescription_activo());
//            ps.setDate(index++, activo.getDate_get_activo());
//            ps.setDate(index++, activo.getDate_let_activo());
//            ps.setDouble(index++, activo.getValue_activo());
//            ps.setString(index++, activo.getUsuario().getEmail());
//            ps.setInt(index++, activo.getId_activo());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(Activo activo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement("delete from activo where usuario_emailUsuario = ? and idactivo = ? ");
            int index = 1;
//            ps.setString(index++, activo.getUsuario().getEmail());
//            ps.setInt(index++, activo.getId_activo());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }

    public ArrayList<Activo> selectAll(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Activo> activos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from activo where usuario_emailUsuario = '" + usuario.getEmail() + "'");
            activos = new ArrayList();
            while (rs.next()) {
//                Activo i = new Activo(rs.getInt("idactivo"), rs.getString("nombreactivo"), rs.getString("descripcion"), rs.getDate("fechaactivo"), rs.getDate("fechaactivo"), rs.getDouble("valoractivo"), usuario);
//                activos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return activos;
    }

    public ArrayList<Activo> selectAll(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Activo> activos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from activo where usuario_emailUsuario = '" + usuario.getEmail() + "' and fechaactivo between '" + inicial + " ' and '" + fin + "' ");
            activos = new ArrayList();
            while (rs.next()) {
//                Activo i = new Activo(rs.getInt("idactivo"), rs.getString("nombreactivo"), rs.getString("descripcion"), rs.getDate("fechaactivo"), rs.getDate("fechaactivo"), rs.getDouble("valoractivo"), usuario);
//                activos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return activos;
    }
    
    public Activo selectID(Usuario usuario, Activo activo){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
                int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from activo where usuario_emailUsuario = '" + usuario.getEmail() + "' and fechaactivo= '" + activo.getDate_get_activo() + " ' and valoractivo=" + activo.getValue_activo()
            );
            while (rs.next()) {
//                activo = new Activo(rs.getInt("idactivo"), rs.getString("nombreactivo"), rs.getString("descripcion"), rs.getDate("fechaactivo"), rs.getDate("fechaactivo"), rs.getDouble("valoractivo"), usuario);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return activo;
    }
    
    public double selectTotal(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        double rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select sum(valoractivo) as total from activo where usuario_emailUsuario = '" + usuario.getEmail() + "' and fechaactivo between '" + inicial + " ' and '" + fin + "' ");
            while (rs.next()) {
                rows = rs.getDouble("total"); 
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }
}
