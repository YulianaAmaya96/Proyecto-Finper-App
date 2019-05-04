package Controlador;

import DAO_DB.*;
import Modelo.*;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;

public class Controlador_Ingreso {

    public int Insertar_Ingreso(Ingreso ingreso) {
        Operaciones_Ingreso jap = new Operaciones_Ingreso();
        int b1 = jap.insert(ingreso);
        if (b1 == 1) {
            //JOptionPane.showMessageDialog(null, "Se inserto con exito ");
        } else {
            //JOptionPane.showMessageDialog(null, "No se inserto");
        }
        return b1;
    }

    public int Modificar_Ingreso(Ingreso ingreso) {
        Operaciones_Ingreso jap = new Operaciones_Ingreso();
        int b1 = jap.update(ingreso);
        if (b1 != 0) {
            JOptionPane.showMessageDialog(null,"Se actualizo con exito ");
        } else {
            JOptionPane.showMessageDialog(null,"No se actualizo");
        }
        return b1;
    }

    public int Eliminar_Ingreso(Ingreso ingreso, Date ini, Date fin) {
        Operaciones_Egreso jap = new Operaciones_Egreso();
        Operaciones_Ingreso obj = new Operaciones_Ingreso();
        double totalIngresos = obj.selectSum(ingreso.getUsuario(), ini, fin);
        double totalEgresos = jap.selectSum(ingreso.getUsuario(), ini, fin);
        int b1 = 0;
        if ((totalIngresos - ingreso.getValue_ingreso()) >= totalEgresos) {
            b1 = obj.delete2(ingreso);
            if (b1 != 0) {
                JOptionPane.showMessageDialog(null,"Se elimmino con exito ");
            } else {
                JOptionPane.showMessageDialog(null,"No se elimino");
            }
        } else {
            JOptionPane.showMessageDialog(null,"No puede eliminar ingresos superiores a los egresos");
        }
        return b1;
    }

    public ArrayList<Ingreso> Consultar_Ingreso(Usuario usuario) {
        Operaciones_Ingreso jap = new Operaciones_Ingreso();
        ArrayList<Ingreso> listaIngresos = jap.selectAll(usuario);
        return listaIngresos;
    }

    public Ingreso Consultar_Ingreso(Ingreso ingreso) {
        Operaciones_Ingreso jap = new Operaciones_Ingreso();
        return jap.selectAll(ingreso);
    }

    public ArrayList<Ingreso> Consultar_Ingreso(Usuario usuario, Date inicio, Date fin) {
        Operaciones_Ingreso jap = new Operaciones_Ingreso();
        System.out.println(usuario.toString());
        ArrayList<Ingreso> listaIngresos = jap.selectAll(usuario, inicio, fin);
        return listaIngresos;
    }

    public int meses(Date ini, Date fin) {
        Operaciones_Ingreso jap = new Operaciones_Ingreso();
        return jap.selectMeses(ini, fin);
    }
}
