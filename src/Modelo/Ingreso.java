package Modelo;

import java.sql.Date;

public class Ingreso {
    
    private int id; 
    private String name_ingreso;  
    private String description; 
    private Date date_ingreso; 
    private float value_ingreso;
    private String estadoIngreso;
    private Categoria_Ingreso categoria_Ingreso; 
    private Usuario usuario; 
    
    public Ingreso() {
    }

    public Ingreso(String name_ingreso, String description, Date date_ingreso, float value_ingreso, Categoria_Ingreso categoria_Ingreso, Usuario usuario) {
        this.name_ingreso = name_ingreso;
        this.description = description;
        this.date_ingreso = date_ingreso;
        this.value_ingreso = value_ingreso;
        this.categoria_Ingreso = categoria_Ingreso;
        this.usuario = usuario;
    }

    public Ingreso(String name_ingreso, String description, Date date_ingreso, float value_ingreso, String estadoIngreso, Categoria_Ingreso categoria_Ingreso, Usuario usuario) {
        this.name_ingreso = name_ingreso;
        this.description = description;
        this.date_ingreso = date_ingreso;
        this.value_ingreso = value_ingreso;
        this.estadoIngreso = estadoIngreso;
        this.categoria_Ingreso = categoria_Ingreso;
        this.usuario = usuario;
        this.estadoIngreso = "PENDIENTE";                 
    }

    public String getEstadoIngreso() {
        return estadoIngreso;
    }

    public void setEstadoIngreso(String estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

        public Categoria_Ingreso getCategoria_Ingreso() {
        return categoria_Ingreso;
    }

    public void setCategoria_Ingreso(Categoria_Ingreso categoria_Ingreso) {
        this.categoria_Ingreso = categoria_Ingreso;
    }

    public String getName_ingreso() {
        return name_ingreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public void setName_ingreso(String name_ingreso) {
        this.name_ingreso = name_ingreso;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_ingreso() {
        return date_ingreso;
    }

    public void setDate_ingreso(Date date_ingreso) {
        this.date_ingreso = date_ingreso;
    }

    public float getValue_ingreso() {
        return value_ingreso;
    }

    public void setValue_ingreso(float value_ingreso) {
        this.value_ingreso = value_ingreso;
    }

    @Override
    public String toString() {
        return "Ingreso{name_ingreso=" + name_ingreso + ", description=" + description + ", date_ingreso=" + date_ingreso + ", value_ingreso=" + value_ingreso + ", categoria_Ingreso=" + categoria_Ingreso + ", usuario=" + usuario + '}';
    }
}
