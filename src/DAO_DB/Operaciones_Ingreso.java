package DAO_DB;

import Modelo.*;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yuliana Amaya
 */
public class Operaciones_Ingreso {
    
    private final String SQL_INSERT = "INSERT INTO ingreso(nombreIngreso, fechaIngreso, valorIngreso, descripcion, cat_ingreso_idcat_ingreso, usuario_emailUsuario) VALUES(?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ingreso SET nombreIngreso=?, fechaIngreso=?, valorIngreso=?,descripcion=?, estadoIngreso=? WHERE usuario_emailUsuario=? AND nombreIngreso =? AND fechaIngreso=?";
    private final String SQL_DELETE = "DELETE FROM ingreso WHERE usuario_emailUsuario=?";
    private final String SQL_DELETEING = "DELETE FROM ingreso WHERE usuario_emailUsuario=? AND nombreIngreso =? AND fechaIngreso=?";
    private final String SQL_SELECT = "SELECT * FROM ingreso WHERE usuario_emailUsuario='";
    
    public int insert(Ingreso ingreso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, ingreso.getName_ingreso());
            stmt.setDate(index++, ingreso.getDate_ingreso());
            stmt.setFloat(index++, ingreso.getValue_ingreso());
            stmt.setString(index++, ingreso.getDescription());
            stmt.setInt(index++, ingreso.getCategoria_Ingreso().getId_categoria_ingreso());
            stmt.setString(index++, ingreso.getUsuario().getEmail());
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
    
    public int update(Ingreso ingreso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, ingreso.getName_ingreso());
            stmt.setDate(index++, ingreso.getDate_ingreso());
            stmt.setFloat(index++, ingreso.getValue_ingreso());
            stmt.setString(index++, ingreso.getDescription());
            stmt.setString(index++, ingreso.getEstadoIngreso());
            //stmt.setInt(index++, ingreso.getCategoria_Ingreso().getId_categoria_ingreso());
            stmt.setString(index++, ingreso.getUsuario().getEmail());
            stmt.setString(index++, ingreso.getName_ingreso());
            stmt.setDate(index++, ingreso.getDate_ingreso());
            rows = stmt.executeUpdate();
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
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            int index = 1;
            ps.setString(index++, usuario.getEmail());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }
    
    public int delete2(Ingreso ingreso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETEING);
            int index = 1;
            stmt.setString(index++, ingreso.getUsuario().getEmail());
            stmt.setString(index++, ingreso.getName_ingreso());
            stmt.setDate(index++, ingreso.getDate_ingreso());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }
    
    public Categoria_Ingreso selectCat(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Categoria_Ingreso categoria_Ingreso = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cat_ingreso WHERE idcat_ingreso = " + id);
            while (rs.next()) {
                categoria_Ingreso = new Categoria_Ingreso(rs.getInt("idcat_ingreso"), rs.getString("cat_ingreso"));
            }
            stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return categoria_Ingreso;
    }
    
    public Ingreso selectAll(Ingreso ingreso) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rows = 0; 
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + ingreso.getUsuario().getEmail() + "' and nombreIngreso='"
                    + ingreso.getName_ingreso() + "' and fechaIngreso='" + ingreso.getDate_ingreso() + "' "
                            + "and descripcion ='" + ingreso.getDescription() + "'" );
            while (rs.next()) {
                Categoria_Ingreso categoria_Ingreso = this.selectCat(rs.getInt("cat_ingreso_idcat_ingreso"));
                ingreso = new Ingreso(rs.getString("nombreIngreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaIngreso"),
                        rs.getFloat("valorIngreso"),
                        categoria_Ingreso, ingreso.getUsuario());
                ingreso.setEstadoIngreso(rs.getString("estadoIngreso"));
                ingreso.setId(rs.getInt("idIngreso")); 
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ingreso;
    }
    
    public ArrayList<Ingreso> selectAll(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Ingreso> ingresos = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "'");
            ingresos = new ArrayList();
            while (rs.next()) {
                Categoria_Ingreso categoria_Ingreso = this.selectCat(rs.getInt("cat_ingreso_idcat_ingreso"));
                Ingreso i = new Ingreso(rs.getString("nombreIngreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaIngreso"),
                        rs.getFloat("valorIngreso"),
                        categoria_Ingreso, usuario);
                i.setEstadoIngreso(rs.getString("estadoIngreso"));
                ingresos.add(i);
            }
            stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ingresos;
    }
    
    public ArrayList<Ingreso> selectAll(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Ingreso> ingresos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "' AND fechaIngreso BETWEEN '" + inicial + "' AND '" + fin + "'"
                    + "");
            ingresos = new ArrayList();
            while (rs.next()) {
                Categoria_Ingreso categoria_Ingreso = this.selectCat(rs.getInt("cat_ingreso_idcat_ingreso"));
                Ingreso i = new Ingreso(rs.getString("nombreIngreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaIngreso"),
                        rs.getFloat("valorIngreso"),
                        categoria_Ingreso, usuario);
                i.setEstadoIngreso(rs.getString("estadoIngreso"));
                ingresos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ingresos;
    }
    
    public double selectSum(Usuario usuario, Date inicial, Date fin, int c) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SUM(valorIngreso) AS total FROM ingreso WHERE"
                    + " usuario_emailUsuario = '" + usuario.getEmail() + "' "
                    + "and fechaIngreso between '" + inicial + "' and '" + fin + "'"
                    + "and cat_ingreso_idcat_ingreso=" + c);            
            while (rs.next()) {
                result = rs.getInt("total");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public double selectSum(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SUM(valorIngreso) AS total FROM ingreso WHERE"
                    + " usuario_emailUsuario = '" + usuario.getEmail() + "' "
                    + "and fechaIngreso between '" + inicial + "' and '" + fin + "'"
            );            
            while (rs.next()) {
                result = rs.getInt("total");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public ArrayList<Ingreso> selectAll(Usuario usuario, Date inicial, Date fin, int fk) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Ingreso> ingresos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "' ABD fechaIngreso between '"
                    + inicial + "' AND '" + fin + "' "
                    + "and cat_ingreso_idcat_ingreso = " + fk);
            ingresos = new ArrayList();
            while (rs.next()) {
                Categoria_Ingreso categoria_Ingreso = this.selectCat(rs.getInt("cat_ingreso_idcat_ingreso"));
                Ingreso i = new Ingreso(rs.getString("nombreIngreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaIngreso"),
                        rs.getFloat("valorIngreso"),
                        categoria_Ingreso, usuario);
                i.setEstadoIngreso(rs.getString("estadoIngreso"));
                ingresos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ingresos;
    }
    
    public int selectMeses(java.sql.Date dateini, java.sql.Date datefin) {
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
