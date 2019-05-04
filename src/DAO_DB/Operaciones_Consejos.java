package DAO_DB;

import Servicios.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operaciones_Consejos {
    
    private final String SQLSELECTMAX = "SELECT MAX(idconsejos) AS MAXIMO FROM consejos"; 
    private final String SQLSELECT = ""; 
    private final String SQLSELECT1 = "SELECT consejo FROM consejos WHERE idconsejos = (SELECT (random() * (SELECT MAX(idConsejos) FROM consejos))::int AS tandom)"; 
    
    public int selectMax() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int id = 0; 
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQLSELECTMAX);
            while (rs.next()) {
                id = rs.getInt("MAXIMO");
            }
            int rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public String selectConsejo() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String consejo = null; 
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQLSELECT1);
            while (rs.next()) {
                consejo = rs.getString("consejo");
            }
            int rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consejo;
    }

    public ArrayList<String> selectAll(String categoria_Consejo) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> consejos = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM consejos WHERE categoriaConsejo = '"+categoria_Consejo+"'");
            consejos = new ArrayList();
            while (rs.next()) {
                String consejo = rs.getString("consejo");
                consejos.add(consejo);
            }
            rows = stmt.getMaxRows();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consejos;
    }
}
