package Modelo;

import java.sql.Date;

public class Egreso {
    
    private int id; 
    private String name_egreso;
    private String desciption_egreso;
    private Date date_egreso;
    private double value_egreso;
    private String estado_egreso; 
    private int prioridad; 
    private Categoria_Egreso categoria_Egreso;
    private Usuario usuario;

    public Egreso() {
    }

    public Egreso(String name_egreso, String desciption_egreso, Date date_egreso, double value_egreso, int prioridad, Categoria_Egreso categoria_Egreso, Usuario usuario) {
        this.name_egreso = name_egreso;
        this.desciption_egreso = desciption_egreso;
        this.date_egreso = date_egreso;
        this.value_egreso = value_egreso;
        this.prioridad = prioridad;
        this.categoria_Egreso = categoria_Egreso;
        this.usuario = usuario;
    }

    public Egreso(String name_egreso, String desciption_egreso, Date date_egreso, double value_egreso, String estado_egreso, int prioridad, Categoria_Egreso categoria_Egreso, Usuario usuario) {
        this.name_egreso = name_egreso;
        this.desciption_egreso = desciption_egreso;
        this.date_egreso = date_egreso;
        this.value_egreso = value_egreso;
        this.estado_egreso = estado_egreso;
        this.prioridad = prioridad;
        this.categoria_Egreso = categoria_Egreso;
        this.usuario = usuario;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public String getName_egreso() {
        return name_egreso;
    }

    public void setName_egreso(String name_egreso) {
        this.name_egreso = name_egreso;
    }

    public String getDesciption_egreso() {
        return desciption_egreso;
    }

    public void setDesciption_egreso(String desciption_egreso) {
        this.desciption_egreso = desciption_egreso;
    }

    public Date getDate_egreso() {
        return date_egreso;
    }

    public void setDate_egreso(Date date_egreso) {
        this.date_egreso = date_egreso;
    }

    public double getValue_egreso() {
        return value_egreso;
    }

    public void setValue_egreso(double value_egreso) {
        this.value_egreso = value_egreso;
    }

    public Categoria_Egreso getCategoria_Egreso() {
        return categoria_Egreso;
    }

    public void setCategoria_Egreso(Categoria_Egreso categoria_Egreso) {
        this.categoria_Egreso = categoria_Egreso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado_egreso() {
        return estado_egreso;
    }

    public void setEstado_egreso(String estado_egreso) {
        this.estado_egreso = estado_egreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return "Egreso{name_egreso=" + name_egreso + ", desciption_egreso=" + desciption_egreso + ", date_egreso=" + date_egreso + ", value_egreso=" + value_egreso + ", estado_egreso=" + estado_egreso + ", prioridad=" + prioridad + ", categoria_Egreso=" + categoria_Egreso + ", usuario=" + usuario + '}';
    }
    
}
