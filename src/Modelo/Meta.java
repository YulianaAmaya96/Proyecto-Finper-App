package Modelo;

import java.sql.Date;

public class Meta {

    private String name_objective;
    private String description_objective;
    private Date date_begin_objective;
    private Date date_finish_objective;
    private float value_objective;
    private String estado_objetivo;
    private Usuario usuario;
    private int prioidad;

    public Meta() {
        this.estado_objetivo = "PENFIENTE";
    }

    public Meta(String name_objective, String description_objective, Date date_begin_objective, Date date_finish_objective, float value_objective, Usuario usuario, int prioidad) {
        this.name_objective = name_objective;
        this.description_objective = description_objective;
        this.date_begin_objective = date_begin_objective;
        this.date_finish_objective = date_finish_objective;
        this.value_objective = value_objective;
        this.usuario = usuario;
        this.prioidad = prioidad;
    }

    public Meta(String name_objective, String description_objective, Date date_begin_objective, Date date_finish_objective, float value_objective, String estado_objetivo, Usuario usuario, int prioidad) {
        this.name_objective = name_objective;
        this.description_objective = description_objective;
        this.date_begin_objective = date_begin_objective;
        this.date_finish_objective = date_finish_objective;
        this.value_objective = value_objective;
        this.estado_objetivo = estado_objetivo;
        this.usuario = usuario;
        this.prioidad = prioidad;
    }
    
    

    public int getPrioidad() {
        return prioidad;
    }

    public void setPrioidad(int prioidad) {
        this.prioidad = prioidad;
    }

    public String getName_objective() {
        return name_objective;
    }

    public void setName_objective(String name_objective) {
        this.name_objective = name_objective;
    }

    public String getDescription_objective() {
        return description_objective;
    }

    public void setDescription_objective(String description_objective) {
        this.description_objective = description_objective;
    }

    public Date getDate_begin_objective() {
        return date_begin_objective;
    }

    public void setDate_begin_objective(Date date_begin_objective) {
        this.date_begin_objective = date_begin_objective;
    }

    public Date getDate_finish_objective() {
        return date_finish_objective;
    }

    public void setDate_finish_objective(Date date_finish_objective) {
        this.date_finish_objective = date_finish_objective;
    }

    public float getValue_objective() {
        return value_objective;
    }

    public void setValue_objective(float value_objective) {
        this.value_objective = value_objective;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEstado_objetivo() {
        return estado_objetivo;
    }

    public void setEstado_objetivo(String estado_objetivo) {
        this.estado_objetivo = estado_objetivo;
    }

    @Override
    public String toString() {
        return "Meta{ name_objective=" + name_objective + ", description_objective=" + description_objective + ", date_begin_objective=" + date_begin_objective + ", date_finish_objective=" + date_finish_objective + ", value_objective=" + value_objective + ", estado_objetivo=" + estado_objetivo + ", usuario=" + usuario + '}';
    }

}
