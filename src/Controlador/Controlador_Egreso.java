package Controlador;

import Modelo.*;
import DAO_DB.*;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;

public class Controlador_Egreso {

    public int Insertar_Egreso(Egreso egreso, Date ini, Date fin) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        Operaciones_Ingreso obj = new Operaciones_Ingreso();
        double totalIngresos = obj.selectSum(egreso.getUsuario(), ini, fin);
        double totalEgresos = jap.selectSum(egreso.getUsuario(), ini, fin);
        int b1 = 0;
        if (true) {
            b1 = jap.insert(egreso);
            if (b1 != 0) {
                //JOptionPane.showMessageDialog(null, "Se inserto con exito ");
            } else {
                //JOptionPane.showMessageDialog(null, "No se inserto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puede ingresar egresos superiores a los ingresos");
        }
        return b1;
    }

    public int Actualizar_Egreso(Egreso egreso, Date ini, Date fin) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        Operaciones_Ingreso obj = new Operaciones_Ingreso();
        double totalIngresos = obj.selectSum(egreso.getUsuario(), ini, fin, 1);
        double totalEgresos = jap.selectSum(egreso.getUsuario(), ini, fin, 1);
        int b1 = 0;
        if (totalIngresos <= (totalEgresos + egreso.getValue_egreso())) {
            b1 = jap.update(egreso);
            if (b1 != 0) {
                JOptionPane.showMessageDialog(null, "Se inserto con exito ");
            } else {
                JOptionPane.showMessageDialog(null, "No se inserto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puede ingresar egresos superiores a los ingresos");
        }
        return b1;
    }

    public int Eliminar_Egreso(Egreso egreso) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        int b1 = jap.delete2(egreso);
        if (b1 != 0) {
            JOptionPane.showMessageDialog(null, "Se ELIMINO con exito ");
        } else {
            JOptionPane.showMessageDialog(null, "No se elimino");
        }
        return b1;
    }

    public ArrayList<Egreso> Consultar_Egresos(Usuario usurio) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        System.out.println(usurio.toString());
        ArrayList<Egreso> egresos = jap.selectAll(usurio);
        return egresos;
    }

    public ArrayList<Egreso> Consultar_Egresos(Usuario usuario, Date ini, Date fin) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        System.out.println(usuario.toString());
        ArrayList<Egreso> egresos = jap.selectAll(usuario, ini, fin);
        return egresos;
    }

    public Egreso Consultar_Egreso(Egreso egreso) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        return jap.selectAll(egreso);
    }

    public double meses(Date ini, Date fin) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        return jap.selectMeses(ini, fin);
    }
}
