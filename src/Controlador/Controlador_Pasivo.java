package Controlador;

import Modelo.*;
import DAO_DB.*;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;

public class Controlador_Pasivo {

    public int Insertar_Pasivo(Pasivo pasivo) {
        Operaciones_Pasivo jap = new Operaciones_Pasivo();
        int b1 = jap.insert(pasivo);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se inserto con exito ");
        } else {
            JOptionPane.showInputDialog("No se inserto");
        }
        return b1;
    }

    public int Modificar_Pasivo(Pasivo pasivo) {
        Operaciones_Pasivo jap = new Operaciones_Pasivo();
        int b1 = jap.update(pasivo);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se actualizo con exito ");
        } else {
            JOptionPane.showInputDialog("No se actualizo");
        }
        return b1;
    }

    public int Eliminar_Pasivo(Pasivo pasivo) {
        Operaciones_Pasivo jap = new Operaciones_Pasivo();
        int b1 = jap.delete(pasivo);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se elimino con exito ");
        } else {
            JOptionPane.showInputDialog("No se elimino");
        }
        return b1;
    }

    public ArrayList<Pasivo> Consultar_Pasivo(Usuario usuario) {
        Operaciones_Pasivo jap = new Operaciones_Pasivo();
        ArrayList<Pasivo> pasivos = jap.selectAll(usuario);
        return pasivos;
    }

    public ArrayList<Pasivo> Consultar_Pasivo2(Usuario usuario, Date ini, Date fin) {
        Operaciones_Pasivo jap = new Operaciones_Pasivo();
        ArrayList<Pasivo> pasivos = jap.selectAll(usuario, ini, fin);
        return pasivos;
    }
}