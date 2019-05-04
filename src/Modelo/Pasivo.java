package Modelo;

import java.sql.Date;

public class Pasivo {
    
    private String name_pasivo;
    private String description_pasivo;
    private Date date_get_pasivo;
    private String estadoPasivo;
    private double value_pasivo; 
    private int prioridad; 
    private Usuario usuario; 
    private Egreso egreso; 

    public Pasivo() {
    }

    public Pasivo(String name_pasivo, String description_pasivo, Date date_get_pasivo, String estadoPasivo, double value_pasivo, int prioridad, Usuario usuario, Egreso egreso) {
        this.name_pasivo = name_pasivo;
        this.description_pasivo = description_pasivo;
        this.date_get_pasivo = date_get_pasivo;
        this.estadoPasivo = estadoPasivo;
        this.value_pasivo = value_pasivo;
        this.prioridad = prioridad;
        this.usuario = usuario;
        this.egreso = egreso;
    }

    public String getName_pasivo() {
        return name_pasivo;
    }

    public void setName_pasivo(String name_pasivo) {
        this.name_pasivo = name_pasivo;
    }

    public String getDescription_pasivo() {
        return description_pasivo;
    }

    public void setDescription_pasivo(String description_pasivo) {
        this.description_pasivo = description_pasivo;
    }

    public Date getDate_get_pasivo() {
        return date_get_pasivo;
    }

    public void setDate_get_pasivo(Date date_get_pasivo) {
        this.date_get_pasivo = date_get_pasivo;
    }

    public String getEstadoPasivo() {
        return estadoPasivo;
    }

    public void setEstadoPasivo(String estadoPasivo) {
        this.estadoPasivo = estadoPasivo;
    }

    public double getValue_pasivo() {
        return value_pasivo;
    }

    public void setValue_pasivo(double value_pasivo) {
        this.value_pasivo = value_pasivo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Egreso getEgreso() {
        return egreso;
    }

    public void setEgreso(Egreso egreso) {
        this.egreso = egreso;
    }

    @Override
    public String toString() {
        return "Pasivo{" + "name_pasivo=" + name_pasivo + ", description_pasivo=" + description_pasivo + ", date_get_pasivo=" + date_get_pasivo + ", estadoPasivo=" + estadoPasivo + ", value_pasivo=" + value_pasivo + ", prioridad=" + prioridad + ", usuario=" + usuario + ", egreso=" + egreso + '}';
    }
    
    
    
}
