package Controlador;

import Modelo.*;
import DAO_DB.*;
import javax.swing.JOptionPane;

public class Controlador_Usuario {

    public int insertar(Usuario usuario) {
        Operaciones_Usuario jap = new Operaciones_Usuario();
        int b2 = jap.verificarEmail(usuario.getEmail());
        if (b2 == 0) {
            b2 = jap.insert(usuario);
            if (b2 == 1) {
                //JOptionPane.showMessageDialog(null, "Se inserto con exito ");
            } else {
                JOptionPane.showMessageDialog(null, "No se inserto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese email");
            b2 = 0; 
        }
        return b2;
    }

    public int modificar(Usuario usuario) {
        Operaciones_Usuario jap = new Operaciones_Usuario();
        int b2 = jap.verificarEmail(usuario.getEmail());
        if (b2 != 0) {
            b2 = jap.update(usuario);
            if (b2 == 1) {
                JOptionPane.showMessageDialog(null, "Se modifico con exito ");
            } else {
                JOptionPane.showMessageDialog(null, "No se modifico");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe un usuario con ese email");
        }
        return b2;
    }

    public int Modificar_Contrasena(Usuario usuario) {
        Operaciones_Usuario jap = new Operaciones_Usuario();
        int b2 = jap.verificarEmail(usuario.getEmail());
        if (b2 != 0) {
            b2 = jap.updatePsw(usuario);
            if (b2 == 1) {
                JOptionPane.showMessageDialog(null, "Se modifico con exito ");
            } else {
                JOptionPane.showMessageDialog(null, "No se modifico");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe un usuario con ese email");
        }
        return b2;
    }

    public int Eliminar_Cuenta(Usuario usuario) {
        Operaciones_Usuario jap = new Operaciones_Usuario();
        int b2 = jap.verificarEmail(usuario.getEmail());
        if (b2 != 0) {
            b2 = jap.delete(usuario);
            if (b2 == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito ");
            } else {
                JOptionPane.showMessageDialog(null, "No se elimino");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe un usuario con ese email");
        }
        return b2;
    }

    public Usuario Consultar_Usuario(Usuario usuario) {
        Operaciones_Usuario jap = new Operaciones_Usuario();
        int b2 = jap.verificarEmail(usuario.getEmail());
        if (b2 != 0) {
            usuario = jap.select(usuario);
            if (usuario != null) {
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe un usuario con ese email");
        }
        return usuario;
    }

    public int Iniciar_Sesion(Usuario usuario) {
        Operaciones_Usuario jap = new Operaciones_Usuario();
        int b2 = jap.verificarEmail(usuario.getEmail());
        if (b2 != 0) {
            b2 = jap.iniciarSesion(usuario);
            if (b2 != 0) {
                //JOptionPane.showMessageDialog(null,"Se encontro");
            } else {
                JOptionPane.showMessageDialog(null, "Verifique la contraseña.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique correo electronico");
        }
        return b2;
    }

}
