package Modelo;

public class Balance_General {
    private Usuario usuario; 
    private double totalIngresosFijos;
    private double totalIngresosVar;
    private double totalEgresosFijos;
    private double totalEgresosVar;
    private double totalActivos;
    private double totalPasivos;
    
    
//    private ArrayList<Activo> activos;
//    private ArrayList<Activo> activos;
//    private ArrayList<Pasivo> pasivos;
//    private ArrayList<Ingreso> listIngresosFijos;
//    private ArrayList<Ingreso> listIngresosVariables;
//    private ArrayList<Egreso> listEgresosFijos;
//    private ArrayList<Egreso> listEgresosVariables;
//    private double capital;
//    private double flujoCaja; 

    public Balance_General() {
    }

    public double getTotalIngresosFijos() {
        return totalIngresosFijos;
    }

    public void setTotalIngresosFijos(double totalIngresosFijos) {
        this.totalIngresosFijos = totalIngresosFijos;
    }

    public double getTotalIngresosVar() {
        return totalIngresosVar;
    }

    public void setTotalIngresosVar(double totalIngresosVar) {
        this.totalIngresosVar = totalIngresosVar;
    }

    public double getTotalEgresosFijos() {
        return totalEgresosFijos;
    }

    public void setTotalEgresosFijos(double totalEgresosFijos) {
        this.totalEgresosFijos = totalEgresosFijos;
    }

    public double getTotalEgresosVar() {
        return totalEgresosVar;
    }

    public void setTotalEgresosVar(double totalEgresosVar) {
        this.totalEgresosVar = totalEgresosVar;
    }

    public double getTotalActivos() {
        return totalActivos;
    }

    public void setTotalActivos(double totalActivos) {
        this.totalActivos = totalActivos;
    }

    public double getTotalPasivos() {
        return totalPasivos;
    }

    public void setTotalPasivos(double totalPasivos) {
        this.totalPasivos = totalPasivos;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
