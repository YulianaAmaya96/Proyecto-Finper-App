package Controlador;

import DAO_DB.Operaciones_Consejos;
import java.util.ArrayList;

public class Controlador_Consejo {
    
    public String Consultar_Consejo(){
        Operaciones_Consejos jap = new Operaciones_Consejos();
        return jap.selectConsejo(); 
    }
    
    public ArrayList<String> Consultar_Consejos(String categoria) {
        Operaciones_Consejos jap = new Operaciones_Consejos();
        ArrayList<String> consejos = jap.selectAll(categoria);
        return consejos;
    }
}
	
