package Servicios;

import DAO_DB.Operacion_Prueba;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;


public class prueba {

    public static void main(String[] args) {
        try {
            Connection c = Conexion.getConnection();
            System.out.println("Se conecto a la base de datos");
        } catch (SQLException ex) {
            
        }
//        Operacion_Prueba op = new Operacion_Prueba();
//        int i = op.selectMeses(new Date(2018, 7, 16), new Date(2019, 07, 15));
        
//        Usuario u = new Usuario("Yuliana", "Amaya", new Date(1996, 5, 22), "yamad@b.com", "1234"); 
//        System.out.println(op.verificarEmail("yamad@b.com")); 
        
//        Date fin = new Date(System.currentTimeMillis());
        //System.out.println(i);
    }

}
 