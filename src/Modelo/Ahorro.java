package Modelo;

public class Ahorro {
    
    private int idAhorro;
    private double valorAhorro; 
    private Usuario usuario; 

    public Ahorro() {
    }

    public Ahorro(int idAhorro, double valorAhorro, Usuario usuario) {
        this.idAhorro = idAhorro;
        this.valorAhorro = valorAhorro;
        this.usuario = usuario;
    }

    public int getIdAhorro() {
        return idAhorro;
    }

    public void setIdAhorro(int idAhorro) {
        this.idAhorro = idAhorro;
    }

    public double getValorAhorro() {
        return valorAhorro;
    }

    public void setValorAhorro(double valorAhorro) {
        this.valorAhorro = valorAhorro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
