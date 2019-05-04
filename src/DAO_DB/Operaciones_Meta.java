package DAO_DB;

import Modelo.*;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Operaciones_Meta {

    private final String SQLINSERT = "INSERT INTO meta (nombreMeta, fechaInicio, fechFfin, valorMeta, descripcion, priordad, usuario_emailUsuario) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE meta SET nombreMeta=?, fechaInicio=?, fechFfin=?, valorMeta=?, descripcion=?, priordad=?, estadoMeta=? WHERE usuario_emailUsuario =?";
    private final String SQL_DELETE = "DELETE FROM meta WHERE usuario_emailUsuario = ? AND nombreMeta=? AND fechaInicio=? AND fechFfin=? AND valorMeta=?";
    private final String SQL_SELECT = "SELECT * FROM meta WHERE usuario_emailUsuario = '";

    public int insert(Meta meta) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQLINSERT);
            int index = 1;
            ps.setString(index++, meta.getName_objective());
            ps.setDate(index++, meta.getDate_begin_objective());
            ps.setDate(index++, meta.getDate_finish_objective());
            ps.setFloat(index++, meta.getValue_objective());
            ps.setString(index++, meta.getDescription_objective());
            ps.setInt(index++, meta.getPrioidad());
            ps.setString(index++, meta.getUsuario().getEmail());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Meta meta) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            ps.setString(index++, meta.getName_objective());
            ps.setDate(index++, meta.getDate_begin_objective());
            ps.setDate(index++, meta.getDate_finish_objective());
            ps.setFloat(index++, meta.getValue_objective());
            ps.setString(index++, meta.getDescription_objective());
            ps.setInt(index++, meta.getPrioidad());
            ps.setString(index++, meta.getEstado_objetivo());
            ps.setString(index++, meta.getUsuario().getEmail());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(Meta meta) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            int index = 1;
            ps.setString(index++, meta.getUsuario().getEmail());
            ps.setString(index++, meta.getName_objective());
            ps.setDate(index++, meta.getDate_begin_objective());
            ps.setDate(index++, meta.getDate_finish_objective());
            ps.setFloat(index++, meta.getValue_objective());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public ArrayList<Meta> selectAll(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Meta> metas = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "'");
            metas = new ArrayList();
            while (rs.next()) {
                Meta i = new Meta(rs.getString("nombreMeta"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaInicio"),
                        rs.getDate("fechFfin"),
                        rs.getFloat("valorMeta"),
                        rs.getString("estadoMeta"),
                        usuario,
                        rs.getInt("priordad"));
                metas.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return metas;
    }

    public ArrayList<Meta> selectAll(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Meta> metas = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "' AND fechaInicio between '" + inicial + " ' AND '" + fin + "' ");
            metas = new ArrayList();
            while (rs.next()) {
                Meta i = new Meta(rs.getString("nombreMeta"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaInicio"),
                        rs.getDate("fechFfin"),
                        rs.getFloat("valorMeta"),
                        rs.getString("estadoMeta"),
                        usuario,
                        rs.getInt("priordad"));
                metas.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return metas;
    }

    public ArrayList<Meta> selectAll(Usuario usuario, Date inicial, Date fin, String estado) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Meta> metas = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from meta where usuario_emailUsuario = '" + usuario.getEmail() + "' and fechainicio between '" + inicial + " ' and '" + fin + "' "
                    + "and estadoMeta = '" + estado + "'");
            metas = new ArrayList();
            while (rs.next()) {
                Meta i = new Meta(rs.getString("nombreMeta"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaInicio"),
                        rs.getDate("fechFfin"),
                        rs.getFloat("valorMeta"),
                        rs.getString("estadoMeta"),
                        usuario,
                        rs.getInt("priordad"));
                metas.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return metas;
    }

    public Meta selectAll(Meta meta) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + meta.getUsuario().getEmail() + "' AND "
                    + "fechaInicio= '" + meta.getDate_begin_objective()
                    + "' AND fechFfin='" + meta.getDate_finish_objective() + "'"
                    + "AND valorMeta=" + meta.getValue_objective() + " AND "
                    + "nombreMeta='" + meta.getName_objective()+ "'");
            while (rs.next()) {
                meta = new Meta(rs.getString("nombreMeta"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaInicio"),
                        rs.getDate("fechFfin"),
                        rs.getFloat("valorMeta"),
                        rs.getString("estadoMeta"),
                        meta.getUsuario(),
                        rs.getInt("priordad"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return meta;
    }

    public double selectMeses(Meta meta) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        double meses = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select date_part('month',age('" + meta.getDate_finish_objective() + "', '" + meta.getDate_begin_objective() + "')) as meses");
            while (rs.next()) {
                meses = rs.getDouble("meses");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return meses;
    }
}
