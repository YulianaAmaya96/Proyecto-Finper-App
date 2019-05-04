package Modelo;

public class Categoria_Egreso {
    
    private int id_categoria_egreso;
    private String name_categoria; 

    public Categoria_Egreso() {
    }

    public Categoria_Egreso(int id_categoria_egreso, String name_categoria) {
        this.id_categoria_egreso = id_categoria_egreso;
        this.name_categoria = name_categoria;
    }

    public int getId_categoria_egreso() {
        return id_categoria_egreso;
    }

    public void setId_categoria_egreso(int id_categoria_egreso) {
        this.id_categoria_egreso = id_categoria_egreso;
    }

    public String getName_categoria() {
        return name_categoria;
    }

    public void setName_categoria(String name_categoria) {
        this.name_categoria = name_categoria;
    }
    
    
}
