package Controlador;

import Modelo.*;
import DAO_DB.*;
import java.sql.Date;

public class Controlador_Balance {

    public Balance_General Generar_Balance_General(Usuario usurio, Date ini, Date fin) {
        Balance_General balance_General = new Balance_General();
        Operaciones_Ingreso operaciones_Ingreso = new Operaciones_Ingreso();
        Operaciones_Egreso operaciones_Egreso = new Operaciones_Egreso();
        Operaciones_Activo operaciones_Activo = new Operaciones_Activo();
        Operaciones_Pasivo operaciones_Pasivo = new Operaciones_Pasivo();

        double totalIngresos1 = operaciones_Ingreso.selectSum(usurio, ini, fin, 1);
        double totalIngresos2 = operaciones_Ingreso.selectSum(usurio, ini, fin, 2);
        balance_General.setTotalIngresosFijos(totalIngresos1);
        balance_General.setTotalIngresosVar(totalIngresos2);

        double totalEgresos1 = operaciones_Egreso.selectSum(usurio, ini, fin, 1);
        double totalEgresos2 = operaciones_Egreso.selectSum(usurio, ini, fin, 2);
        balance_General.setTotalEgresosFijos(totalEgresos1);
        balance_General.setTotalEgresosVar(totalEgresos2);

        double totalActivos = operaciones_Activo.selectTotal(usurio, ini, fin);
        double totalPasivos = operaciones_Pasivo.selectTotal(usurio, ini, fin);
        balance_General.setTotalActivos(totalActivos);
        balance_General.setTotalPasivos(totalPasivos);
        balance_General.setUsuario(usurio);
//        balance_General.setListIngresosFijos(operaciones_Ingreso.selectAll(usurio, ini, fin, 1));
//        balance_General.setListIngresosVariables(operaciones_Ingreso.selectAll(usurio, ini, fin, 2));
//        balance_General.setListEgresosFijos(operaciones_Egreso.selectAll(usurio, ini, fin, 1));
//        balance_General.setListEgresosVariables(operaciones_Egreso.selectAll(usurio, ini, fin, 2));
//        balance_General.setActivos(operaciones_Activo.selectAll(usurio, ini, fin));
//        balance_General.setPasivos(operaciones_Pasivo.selectAll(usurio, ini, fin));
        return balance_General;
    }
}
