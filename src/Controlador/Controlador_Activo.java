package Controlador;

import DAO_DB.Operaciones_Activo;
import Modelo.*;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;

public class Controlador_Activo {

    public int Insertar_Activo(Activo activo) {
        Operaciones_Activo jap = new Operaciones_Activo();
        int b1 = jap.insert(activo);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se inserto con exito ");
        } else {
            JOptionPane.showInputDialog("No se inserto");
        }
        return b1;
    }

    public int Modificar_Activo(Activo activo) {
        Operaciones_Activo jap = new Operaciones_Activo();
        int b1 = jap.update(activo);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se modifico con exito ");
        } else {
            JOptionPane.showInputDialog("No se modifico");
        }
        return b1;
    }

    public int Eliminar_Activo(Activo activo) {
        Operaciones_Activo jap = new Operaciones_Activo();
        int b1 = jap.delete(activo);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se elimino con exito ");
        } else {
            JOptionPane.showInputDialog("No se elimino");
        }
        return b1;
    }

    public ArrayList<Activo> Consultar_Activo(Usuario usuario) {
        Operaciones_Activo jap = new Operaciones_Activo();
        ArrayList<Activo> activos = jap.selectAll(usuario);
        return activos;
    }

    public ArrayList<Activo> Consultar_Activo2(Usuario usuario, Date ini, Date fin) {
        Operaciones_Activo jap = new Operaciones_Activo();
        ArrayList<Activo> activos = jap.selectAll(usuario, ini, fin);
        return activos;
    }

}
