package Controlador;

import Modelo.*;
import DAO_DB.*;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;

public class Controlador_Meta {

    public int Insertar_Meta(Meta meta) {
        Operaciones_Egreso oe = new Operaciones_Egreso();
        Operaciones_Ingreso oi = new Operaciones_Ingreso();
        Operaciones_Meta om = new Operaciones_Meta();
        double totalIngresos = oi.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
        double totalEgresos = oe.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
        double flujoDeCaja = totalIngresos - totalEgresos;
        int b1 = 0;
        //if (true) {
        if (flujoDeCaja >= meta.getValue_objective()) {
            b1 = om.insert(meta);
            if (b1 != 0) {
                JOptionPane.showMessageDialog(null, "Se inserto con exito ");
            } else {
                JOptionPane.showMessageDialog(null, "No se inserto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No es posible cumplil esta meta, ya que la capacidad de ahorro por el tiempo es insuficiente"
                    + "\nDigite otra fecha por favor");
        }
        return b1;
    }

    public int Modificar_Meta(Meta meta) {
        Operaciones_Egreso oe = new Operaciones_Egreso();
        Operaciones_Ingreso oi = new Operaciones_Ingreso();
        Operaciones_Meta om = new Operaciones_Meta();
        double totalIngresos = oi.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
        double totalEgresos = oe.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
        double flujoDeCaja = totalIngresos - totalEgresos;
        int b1 = 0;
        if (flujoDeCaja >= meta.getValue_objective()) {
            b1 = om.update(meta);
            if (b1 != 0) {
                JOptionPane.showMessageDialog(null, "Se inserto con exito ");
            } else {
                JOptionPane.showMessageDialog(null, "No se inserto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No es posible cumplil esta meta, ya que la capacidad de ahorro por el tiempo es insuficiente"
                    + "\nDigite otra fecha por favor");
        }
        return b1;
    }

    public int Eliminar_Meta(Meta meta) {
        Operaciones_Meta jap = new Operaciones_Meta();
        int b1 = jap.delete(meta);
        if (b1 != 0) {
            JOptionPane.showMessageDialog(null, "Se ELIMINO con exito ");
        } else {
            JOptionPane.showMessageDialog(null, "No se elimino");
        }
        return b1;
    }

    public ArrayList<Meta> Consultar_Meta(Usuario usuario) {
        Operaciones_Meta jap = new Operaciones_Meta();
        ArrayList<Meta> meta = jap.selectAll(usuario);
        return meta;
    }

    public ArrayList<Meta> Consultar_Metas(Usuario usuaio, Date ini, Date fin) {
        Operaciones_Meta jap = new Operaciones_Meta();
        ArrayList<Meta> meta = jap.selectAll(usuaio, ini, fin);
        return meta;
    }

    public ArrayList<Meta> Seguimiento_Metas(Usuario usuairo, Date ini) {
        Operaciones_Meta jap = new Operaciones_Meta();
        Date fin = new Date(System.currentTimeMillis());
        ArrayList<Meta> meta = jap.selectAll(usuairo, ini, fin, "PENDIENTE");
        return meta;
    }

    public Meta Consultar_Meta(Meta meta) {
        Operaciones_Meta jap = new Operaciones_Meta();
        return jap.selectAll(meta);
    }
}
