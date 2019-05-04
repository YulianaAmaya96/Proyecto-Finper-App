package Modelo;

public class Categoria_Ingreso {
    
    private int id_categoria_ingreso;
    private String name_categoria; 

    public Categoria_Ingreso() {
    }

    public Categoria_Ingreso(int id_categoria_ingreso, String name_categoria) {
        this.id_categoria_ingreso = id_categoria_ingreso;
        this.name_categoria = name_categoria;
    }

    public int getId_categoria_ingreso() {
        return id_categoria_ingreso;
    }

    public void setId_categoria_ingreso(int id_categoria_ingreso) {
        this.id_categoria_ingreso = id_categoria_ingreso;
    }

    public String getName_categoria() {
        return name_categoria;
    }

    public void setName_categoria(String name_categoria) {
        this.name_categoria = name_categoria;
    }
    
    
}
