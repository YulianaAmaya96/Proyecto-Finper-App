package Modelo;

import java.sql.Date;

public class Activo {

    private String name_activo;
    private String description_activo;
    private Date date_get_activo;
    private String estado;
    private float value_activo;
    private Usuario usuario;
    private Ingreso ingreso;

    public Activo() {
    }

    public Activo(String name_activo, String description_activo, Date date_get_activo, String estado, float value_activo, Usuario usuario, Ingreso ingreso) {
        this.name_activo = name_activo;
        this.description_activo = description_activo;
        this.date_get_activo = date_get_activo;
        this.estado = estado;
        this.value_activo = value_activo;
        this.usuario = usuario;
        this.ingreso = ingreso;
    }

    public String getName_activo() {
        return name_activo;
    }

    public void setName_activo(String name_activo) {
        this.name_activo = name_activo;
    }

    public String getDescription_activo() {
        return description_activo;
    }

    public void setDescription_activo(String description_activo) {
        this.description_activo = description_activo;
    }

    public Date getDate_get_activo() {
        return date_get_activo;
    }

    public void setDate_get_activo(Date date_get_activo) {
        this.date_get_activo = date_get_activo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getValue_activo() {
        return value_activo;
    }

    public void setValue_activo(float value_activo) {
        this.value_activo = value_activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public String toString() {
        return "Activo{" + "name_activo=" + name_activo + ", description_activo=" + description_activo + ", date_get_activo=" + date_get_activo + ", estado=" + estado + ", value_activo=" + value_activo + ", usuario=" + usuario + ", ingreso=" + ingreso + '}';
    }

}
