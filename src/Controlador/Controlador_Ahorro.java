package Controlador;

import DAO_DB.Operaciones_Ahorro;
import Modelo.*;
import javax.swing.JOptionPane;

public class Controlador_Ahorro {
	
    public int Insertar_Ahorro(Ahorro ahorro) {
        Operaciones_Ahorro jap = new Operaciones_Ahorro();
        int b1 = jap.insert(ahorro);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se inseerto con exito ");
        } else {
            JOptionPane.showInputDialog("No se inserto");
        }
        return b1;
    }

    public int Modficar_Ahorro(Ahorro ahorro) {
        Operaciones_Ahorro jap = new Operaciones_Ahorro();
        int b1 = jap.update(ahorro);
        if (b1 != 0) {
            JOptionPane.showInputDialog("Se modifico con exito ");
        } else {
            JOptionPane.showInputDialog("No se modifico");
        }
        return b1;
    }

    public Ahorro Consultar_Ahorro(Usuario usuario) {
        Operaciones_Ahorro jap = new Operaciones_Ahorro();
        Ahorro b1 = jap.select(usuario);
        if (b1 != null) {
            JOptionPane.showInputDialog("Se elimino con exito ");
        } else {
            JOptionPane.showInputDialog("No se elimino");
        }
        return b1;
    }

}