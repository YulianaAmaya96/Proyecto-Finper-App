package Servicios;

/**
 *
 * @author Yuliana Amaya
 */
public class Validaciones {

    public boolean validarContraseña(String psw, String psw2) {
        return psw.trim().equals(psw2.trim());
    }

    public boolean validarLongitud(String psw) {
        return psw.length() >= 8;
    }
    
    public boolean validarCorreo(String email){
        StringBuffer sb = new StringBuffer("@"); 
        return email.contentEquals(sb);     
    }
}
