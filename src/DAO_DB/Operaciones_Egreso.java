package DAO_DB;

import Modelo.Categoria_Egreso;
import Modelo.Egreso;
import Modelo.Usuario;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operaciones_Egreso {

    private final String SQL_INSERT = "INSERT INTO egreso(nombreEgreso, descripcion, fechaEgreso, valorEgreso, idPrioridad, cat_egreso_idcat_egreso, usuario_emailUsuario) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE egreso SET nombreegreso=?, descripcion=?, fechaEgreso=?, estadoEgreso=?, cat_egreso_idcat_egreso=?, estadoEgreso=?, idPrioridad=? WHERE usuario_emailUsuario = ? nombreegreso=? AND descripcion=? AND fechaEgreso=? ";
    private final String SQL_DELETE = "DELETE FROM egreso WHERE usuario_emailUsuario=?";
    private final String SQL_DELETEEG = "DELETE FROM egreso WHERE usuario_emailUsuario=? AND nombreIngreso =? AND fechaIngreso=?";
    private final String SQL_SELECT = "SELECT * FROM egreso WHERE usuario_emailUsuario='";

    public int insert(Egreso egreso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, egreso.getName_egreso());
            stmt.setString(index++, egreso.getDesciption_egreso());
            stmt.setDate(index++, egreso.getDate_egreso());
            stmt.setDouble(index++, egreso.getValue_egreso());
            stmt.setInt(index++, egreso.getPrioridad());
            stmt.setInt(index++, egreso.getCategoria_Egreso().getId_categoria_egreso());
            stmt.setString(index++, egreso.getUsuario().getEmail());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Egreso egreso) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            ps.setString(index++, egreso.getName_egreso());
            ps.setString(index++, egreso.getDesciption_egreso());
            ps.setDate(index++, egreso.getDate_egreso());
            ps.setDouble(index++, egreso.getValue_egreso());
            ps.setString(index++, egreso.getEstado_egreso());
            ps.setInt(index++, egreso.getPrioridad());
            ps.setInt(index++, egreso.getCategoria_Egreso().getId_categoria_egreso());
            ps.setString(index++, egreso.getUsuario().getEmail());
            ps.setString(index++, egreso.getName_egreso());
            ps.setDate(index++, egreso.getDate_egreso());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
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

    public int delete2(Egreso egreso) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETEEG);
            int index = 1;
            ps.setString(index++, egreso.getUsuario().getEmail());
            ps.setString(index++, egreso.getName_egreso());
            ps.setDate(index++, egreso.getDate_egreso());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }

    public Categoria_Egreso selectCat(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        Categoria_Egreso categoria_Egreso = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cat_egreso WHERE idcat_egreso = " + id);
            while (rs.next()) {
                categoria_Egreso = new Categoria_Egreso(rs.getInt("idcat_egreso"), rs.getString("cat_egreso"));
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return categoria_Egreso;
    }

    public ArrayList<Egreso> selectAll(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Egreso> egresos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "'");
            egresos = new ArrayList();
            while (rs.next()) {
                Categoria_Egreso categoria_Egreso = this.selectCat(rs.getInt("cat_egreso_idcat_egreso"));
                Egreso i = new Egreso(rs.getString("nombreEgreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaEgreso"),
                        rs.getFloat("valorEgreso"),
                        rs.getString("estadoEgreso"),
                        rs.getInt("idPrioridad"), categoria_Egreso, usuario);
                egresos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return egresos;
    }

    public Egreso selectAll(Egreso egreso) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + egreso.getUsuario().getEmail() + "'");
            while (rs.next()) {
                Categoria_Egreso categoria_Egreso = this.selectCat(rs.getInt("cat_egreso_idcat_egreso"));
                egreso = new Egreso(rs.getString("nombreEgreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaEgreso"),
                        rs.getFloat("valorEgreso"),
                        rs.getString("estadoEgreso"),
                        rs.getInt("idPrioridad"), categoria_Egreso, egreso.getUsuario());
                egreso.setId(rs.getInt("idPasivo")); 
            }
            stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return egreso;
    }

    public ArrayList<Egreso> selectAll(Usuario usuario, Date inicial, Date fin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Egreso> egresos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "' AND fechaEgreso between '" + inicial + "' and '" + fin + "' ");
            egresos = new ArrayList();
            while (rs.next()) {
                Categoria_Egreso categoria_Egreso = this.selectCat(rs.getInt("cat_Egreso_idcat_Egreso"));
                Egreso i = new Egreso(rs.getString("nombreEgreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaEgreso"),
                        rs.getFloat("valorEgreso"),
                        rs.getString("estadoEgreso"),
                        rs.getInt("idPrioridad"), categoria_Egreso, usuario);
                egresos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return egresos;
    }

    public double selectSum(Usuario usuario, Date inicial, Date fin, int c) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SUM(valorEgreso) AS total FROM egreso WHERE"
                    + " usuario_emailUsuario = '" + usuario.getEmail() + "' "
                    + "and fechaegreso between '" + inicial + "' and '" + fin + "'"
                    + "and cat_Egreso_idcat_Egreso=" + c);
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
            rs = stmt.executeQuery("SELECT SUM(valorEgreso) AS total FROM egreso WHERE"
                    + " usuario_emailUsuario = '" + usuario.getEmail() + "' "
                    + "and fechaegreso between '" + inicial + "' and '" + fin + "'"
            );
            while (rs.next()) {
                result = rs.getInt("total");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public ArrayList<Egreso> selectAll(Usuario usuario, Date ini, Date fin, int fk) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Egreso> egresos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT + usuario.getEmail() + "' and fechaEgreso between '" + ini + " ' and '" + fin + "' "
                    + "AND cat_egreso_idcat_egreso=" + fk);
            egresos = new ArrayList();
            while (rs.next()) {
                Categoria_Egreso categoria_Egreso = this.selectCat(rs.getInt("cat_egreso_idcat_egreso"));
                Egreso i = new Egreso(rs.getString("nombreEgreso"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaEgreso"),
                        rs.getFloat("valorEgreso"),
                        rs.getString("estadoEgreso"),
                        rs.getInt("idPrioridad"), categoria_Egreso, usuario);
                egresos.add(i);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return egresos;
    }

    public double selectMeses(Date dateini, Date datefin) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        double meses = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select date_part('month',age('" + dateini + "', '" + datefin + "')) as meses");
            while (rs.next()) {
                meses = rs.getDouble("meses");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return meses;
    }

}
