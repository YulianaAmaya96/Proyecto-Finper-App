//package Controlador;
//
////import DAO_DB.*;
////import javax.ws.rs.Consumes;
////import javax.ws.rs.GET;
////import javax.ws.rs.POST;
////import javax.ws.rs.Path;
////import javax.ws.rs.Produces;
////import javax.ws.rs.QueryParam;
////import javax.ws.rs.core.MediaType;
//import Modelo.*;
//import java.util.ArrayList;
//import java.util.Date;
//
//@Path("operaciones")
//public class Servicios {
//
//    //-----------------------------------------------------SERVICIO PRUEBA-----------------------------------------------
//    @GET
//    @Path("Verificar")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public int verficar(@QueryParam("nombre") String nombre, @QueryParam("email") String email) {
//        Usuario u = new Usuario(nombre, null, null, email, null);
//        respuesta pf = new respuesta();
//        Operaciones_Usuario jap = new Operaciones_Usuario();
//        int rows = jap.selectID(u);
//        return rows;
//    }
//
//    //----------------------------------------SERVICIOS USUARIO------------------------------------------------
//    @POST
//    @Path("Insertar_Usuario")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Insertar_Usuario(Usuario usuario) {
//        System.out.println(usuario.toString());
//        Operaciones_Usuario jap = new Operaciones_Usuario();
//        respuesta r = new respuesta();
//        int b2 = jap.verificarEmail(usuario.getEmail());
//        if (b2 == 0) {
//            b2 = jap.insert(usuario);
//            if (b2 == 1) {
//                r.setCodigo(0);
//                r.setValor(b2);
//                r.setDescripcion("Se inserto con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se inserto");
//            }
//        } else {
//            r.setCodigo(0);
//            r.setValor(0);
//            r.setDescripcion("Ya existe un usuario con ese email");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Modificar_Usuario")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Modificar_Usuario(Usuario usuario) {
//        System.out.println(usuario.toString());
//        Operaciones_Usuario jap = new Operaciones_Usuario();
//        respuesta r = new respuesta();
//        int b2 = jap.verificarEmail(usuario.getEmail());
//        if (b2 != 0) {
//            b2 = jap.update(usuario);
//            if (b2 == 1) {
//                r.setCodigo(0);
//                r.setValor(b2);
//                r.setDescripcion("Se modifico con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se modifico");
//            }
//        } else {
//            r.setCodigo(0);
//            r.setValor(0);
//            r.setDescripcion("No existe un usuario con ese email");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Modificar_Contrasena")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Modificar_Contrasena(Usuario usuario) {
//        System.out.println(usuario.toString());
//        Operaciones_Usuario jap = new Operaciones_Usuario();
//        respuesta r = new respuesta();
//        int b2 = jap.verificarEmail(usuario.getEmail());
//        if (b2 != 0) {
//            b2 = jap.updatePsw(usuario);
//            if (b2 == 1) {
//                r.setCodigo(0);
//                r.setValor(b2);
//                r.setDescripcion("Se modifico con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se modifico");
//            }
//        } else {
//            r.setCodigo(0);
//            r.setValor(0);
//            r.setDescripcion("No existe un usuario con ese email");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Eliminar_Cuenta")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Eliminar_Cuenta(Usuario usuario) {
//        System.out.println(usuario.toString());
//        Operaciones_Usuario jap = new Operaciones_Usuario();
//        respuesta r = new respuesta();
//        int b2 = jap.verificarEmail(usuario.getEmail());
//        if (b2 != 0) {
//            b2 = jap.delete(usuario);
//            if (b2 == 1) {
//                r.setCodigo(0);
//                r.setValor(b2);
//                r.setDescripcion("Se elimino con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se elimino");
//            }
//        } else {
//            r.setCodigo(0);
//            r.setValor(0);
//            r.setDescripcion("No existe un usuario con ese email");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Consultar_Usuario")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Usuario Consultar_Usuario(Usuario usuario) {
//        System.out.println(usuario.toString());
//        Operaciones_Usuario jap = new Operaciones_Usuario();
//        respuesta r = new respuesta();
//        int b2 = jap.verificarEmail(usuario.getEmail());
//        if (b2 != 0) {
//            usuario = jap.select(usuario);
//            if (usuario != null) {
//                r.setCodigo(0);
//                r.setValor(b2);
//                r.setDescripcion("Se encontro");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se encontro");
//            }
//        } else {
//            r.setCodigo(0);
//            r.setValor(0);
//            r.setDescripcion("No existe un usuario con ese email");
//        }
//        return usuario;
//    }
//
//    //---------------------------------------SERVICIOS INGRESOS-------------------------------------------------
//    @POST
//    @Path("Insertar_Ingreso")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Insertar_Ingreso(Ingreso ingreso) {
//        Operaciones_Ingreso jap = new Operaciones_Ingreso();
//        System.out.println(ingreso.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.insert(ingreso);
//        if (b1 == 1) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se inserto con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se inserto");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Modificar_Ingreso")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Modificar_Ingreso(Ingreso ingreso) {
//        Operaciones_Ingreso jap = new Operaciones_Ingreso();
//        System.out.println(ingreso.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.update(ingreso);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se actualizo con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se actualizo");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Eliminar_Ingreso")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Eliminar_Ingreso(Ingreso ingreso, Date ini, Date fin) {
//        Operaciones_Egreso jap = new Operaciones_Egreso();
//        Operaciones_Ingreso obj = new Operaciones_Ingreso();
//        System.out.println(ingreso.toString());
//        respuesta r = new respuesta();
//        double totalIngresos = obj.selectSum(ingreso.getUsuario(), ini, fin);
//        double totalEgresos = jap.selectSum(ingreso.getUsuario(), ini, fin);
//        int b1 = 0;
//        if ((totalIngresos - ingreso.getValue_ingreso()) > totalEgresos) {
//            b1 = obj.delete(ingreso);
//            if (b1 != 0) {
//                r.setCodigo(0);
//                r.setValor(b1);
//                r.setDescripcion("Se elimmino con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se elimino");
//            }
//        } else {
//            r.setCodigo(1);
//            r.setValor(550);
//            r.setDescripcion("No puede eliminar ingresos superiores a los egresos");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Consultar_Ingreso")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Ingreso> Consultar_Ingreso(Usuario usuario) {
//        Operaciones_Ingreso jap = new Operaciones_Ingreso();
//        System.out.println(usuario.toString());
//        ArrayList<Ingreso> listaIngresos = jap.selectAll(usuario);
//        return listaIngresos;
//    }
//
//    @POST
//    @Path("Consultar_Ingreso2")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Ingreso> Consultar_Ingreso(Usuario usuario, Date inicio, Date fin) {
//        Operaciones_Ingreso jap = new Operaciones_Ingreso();
//        System.out.println(usuario.toString());
//        ArrayList<Ingreso> listaIngresos = jap.selectAll(usuario, inicio, fin);
//        return listaIngresos;
//    }
//
//    //-------------------------------------SERVICIOS EGRESOS-----------------------------------------------
//    @POST
//    @Path("Insertar_Egreso")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Insertar_Egreso(Egreso egreso, Date ini, Date fin) {
//        Operaciones_Egreso jap = new Operaciones_Egreso();
//        Operaciones_Ingreso obj = new Operaciones_Ingreso();
//        System.out.println(egreso.toString());
//        respuesta r = new respuesta();
//        double totalIngresos = obj.selectSum(egreso.getUsuario(), ini, fin);
//        double totalEgresos = jap.selectSum(egreso.getUsuario(), ini, fin);
//        int b1 = 0;
//        if (totalIngresos < (totalEgresos + egreso.getValue_egreso())) {
//            b1 = jap.insert(egreso);
//            if (b1 != 0) {
//                r.setCodigo(0);
//                r.setValor(b1);
//                r.setDescripcion("Se inserto con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se inserto");
//            }
//        } else {
//            r.setCodigo(1);
//            r.setValor(550);
//            r.setDescripcion("No puede ingresar egresos superiores a los ingresos");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Actualizar_Egreso")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Actualizar_Egreso(Egreso egreso, Date ini, Date fin) {
//        Operaciones_Egreso jap = new Operaciones_Egreso();
//        Operaciones_Ingreso obj = new Operaciones_Ingreso();
//        System.out.println(egreso.toString());
//        respuesta r = new respuesta();
//        double totalIngresos = obj.selectSum(egreso.getUsuario(), ini, fin);
//        double totalEgresos = obj.selectSum(egreso.getUsuario(), ini, fin);
//        int b1 = 0;
//        if (totalIngresos < (totalEgresos + egreso.getValue_egreso())) {
//            b1 = jap.update(egreso);
//            if (b1 != 0) {
//                r.setCodigo(0);
//                r.setValor(b1);
//                r.setDescripcion("Se inserto con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se inserto");
//            }
//        } else {
//            r.setCodigo(1);
//            r.setValor(550);
//            r.setDescripcion("No puede ingresar egresos superiores a los ingresos");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Eliminar_Egreso")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Eliminar_Egreso(Egreso egreso) {
//        Operaciones_Egreso jap = new Operaciones_Egreso();
//        System.out.println(egreso.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.delete(egreso);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se ELIMINO con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se elimino");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Consultar_Egresos")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Egreso> Consultar_Egresos(Egreso egreso) {
//        Operaciones_Egreso jap = new Operaciones_Egreso();
//        System.out.println(egreso.toString());
//        ArrayList<Egreso> egresos = jap.selectAll(egreso.getUsuario());
//        return egresos;
//    }
//
//    @POST
//    @Path("Consultar_Egresos2")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Egreso> Consultar_Egresos(Egreso egreso, Date ini, Date fin) {
//        Operaciones_Egreso jap = new Operaciones_Egreso();
//        System.out.println(egreso.toString());
//        ArrayList<Egreso> egresos = jap.selectAll(egreso.getUsuario(), ini, fin);
//        return egresos;
//    }
//
//    //-----------------------------------------SERVICIOS ACTIVO--------------------------------------------
//    @POST
//    @Path("Insertar_Activo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Insertar_Activo(Activo activo) {
//        System.out.println(activo.toString());
//        Operaciones_Activo jap = new Operaciones_Activo();
//        respuesta r = new respuesta();
//        int b1 = jap.insert(activo);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se inserto con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se inserto");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Modificar_Activo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Modificar_Activo(Activo activo) {
//        System.out.println(activo.toString());
//        Operaciones_Activo jap = new Operaciones_Activo();
//        respuesta r = new respuesta();
//        int b1 = jap.update(activo);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se modifico con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se modifico");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Eliminar_Activo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Eliminar_Activo(Activo activo) {
//        System.out.println(activo.toString());
//        Operaciones_Activo jap = new Operaciones_Activo();
//        respuesta r = new respuesta();
//        int b1 = jap.delete(activo);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se elimino con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se elimino");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Consultar_Activo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Activo> Consultar_Activo(Activo activo) {
//        System.out.println(activo.toString());
//        Operaciones_Activo jap = new Operaciones_Activo();
//        ArrayList<Activo> activos = jap.selectAll(activo.getUsuario());
//        return activos;
//    }
//
//    @POST
//    @Path("Consultar_Activo2")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Activo> Consultar_Activo2(Activo activo, Date ini, Date fin) {
//        System.out.println(activo.toString());
//        Operaciones_Activo jap = new Operaciones_Activo();
//        ArrayList<Activo> activos = jap.selectAll(activo.getUsuario(), ini, fin);
//        return activos;
//    }
//
//    //----------------------------------SERVICIOS PASIVO----------------------------------------------------------------------
//    @POST
//    @Path("Insertar_Pasivo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Insertar_Pasivo(Pasivo pasivo) {
//        Operaciones_Pasivo jap = new Operaciones_Pasivo();
//        System.out.println(pasivo.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.insert(pasivo);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se inserto con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se inserto");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Modificar_Pasivo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Modificar_Pasivo(Pasivo pasivo) {
//        Operaciones_Pasivo jap = new Operaciones_Pasivo();
//        System.out.println(pasivo.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.update(pasivo);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se actualizo con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se actualizo");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Eliminar_Pasivo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Eliminar_Pasivo(Pasivo pasivo) {
//        Operaciones_Pasivo jap = new Operaciones_Pasivo();
//        System.out.println(pasivo.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.delete(pasivo);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se elimino con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se elimino");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Consultar_Pasivo")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Pasivo> Consultar_Pasivo(Pasivo pasivo) {
//        System.out.println(pasivo.toString());
//        Operaciones_Pasivo jap = new Operaciones_Pasivo();
//        ArrayList<Pasivo> pasivos = jap.selectAll(pasivo.getUsuario());
//        return pasivos;
//    }
//
//    @POST
//    @Path("Consultar_Pasivo2")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Pasivo> Consultar_Pasivo2(Pasivo pasivo, Date ini, Date fin) {
//        System.out.println(pasivo.toString());
//        Operaciones_Pasivo jap = new Operaciones_Pasivo();
//        ArrayList<Pasivo> pasivos = jap.selectAll(pasivo.getUsuario(), ini, fin);
//        return pasivos;
//    }
//
//    //------------------------------------------SERVICIOS CONSEJOS-----------------------------------------------
//    @GET
//    @Path("Consultar_Consejos")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public ArrayList<String> Consultar_Consejos(@QueryParam("categoria") String categoria) {
//        Operaciones_Consejos jap = new Operaciones_Consejos();
//        ArrayList<String> consejos = jap.selectAll(categoria);
//        return consejos;
//    }
//
//    //----------------------------------------SERVICIOS AHORRO--------------------------------------------
//    @POST
//    @Path("Insertar_Ahorro")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Insertar_Ahorro(Ahorro ahorro) {
//        Operaciones_Ahorro jap = new Operaciones_Ahorro();
//        System.out.println(ahorro.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.insert(ahorro);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se inseerto con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se inserto");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Modficar_Ahorro")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Modficar_Ahorro(Ahorro ahorro) {
//        Operaciones_Ahorro jap = new Operaciones_Ahorro();
//        System.out.println(ahorro.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.update(ahorro);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se modifico con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se modifico");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Consultar_Ahorro")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Consultar_Ahorro(Usuario usuario) {
//        Operaciones_Ahorro jap = new Operaciones_Ahorro();
//        System.out.println(usuario.toString());
//        respuesta r = new respuesta();
//        Ahorro b1 = jap.select(usuario);
//        if (b1 != null) {
//            r.setCodigo(0);
//            r.setValor(b1.getIdAhorro());
//            r.setDescripcion("Se elimino con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se elimino");
//        }
//        return r;
//    }
//
//    //----------------------------------------SERVICIOS METAS--------------------------------------------
//    @POST
//    @Path("Insertar_Meta")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Insertar_Meta(Meta meta) {
//        Operaciones_Egreso oe = new Operaciones_Egreso();
//        Operaciones_Ingreso oi = new Operaciones_Ingreso();
//        Operaciones_Meta om = new Operaciones_Meta();
//        System.out.println(meta.toString());
//        respuesta r = new respuesta();
//        double totalIngresos = oi.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
//        double totalEgresos = oe.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
//        double flujoDeCaja = totalIngresos - totalEgresos;
//        double cantMeses = om.selectMeses(meta);
//        int b1 = 0;
//        if (flujoDeCaja > (meta.getValue_objective() / cantMeses)) {
//            b1 = om.insert(meta);
//            if (b1 != 0) {
//                r.setCodigo(0);
//                r.setValor(b1);
//                r.setDescripcion("Se inserto con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se inserto");
//            }
//        } else {
//            r.setCodigo(1);
//            r.setValor(550);
//            r.setDescripcion("No es posible cumplil esta meta, ya que la capacidad de ahorro por el tiempo es insuficiente"
//                    + "\nDigite otra fecha por favor");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Modificar_Meta")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Modificar_Meta(Meta meta) {
//        Operaciones_Egreso oe = new Operaciones_Egreso();
//        Operaciones_Ingreso oi = new Operaciones_Ingreso();
//        Operaciones_Meta om = new Operaciones_Meta();
//        System.out.println(meta.toString());
//        respuesta r = new respuesta();
//        double totalIngresos = oi.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
//        double totalEgresos = oe.selectSum(meta.getUsuario(), meta.getDate_begin_objective(), meta.getDate_finish_objective());
//        double flujoDeCaja = totalIngresos - totalEgresos;
//        double cantMeses = om.selectMeses(meta);
//        int b1 = 0;
//        if (flujoDeCaja > (meta.getValue_objective() / cantMeses)) {
//            b1 = om.update(meta);
//            if (b1 != 0) {
//                r.setCodigo(0);
//                r.setValor(b1);
//                r.setDescripcion("Se modifco con exito ");
//            } else {
//                r.setCodigo(2);
//                r.setValor(0);
//                r.setDescripcion("No se modifco");
//            }
//        } else {
//            r.setCodigo(1);
//            r.setValor(550);
//            r.setDescripcion("No es posible cumplir esta meta, ya que la capacidad de ahorro por el tiempo es insuficiente"
//                    + "\nDigite otra fecha por favor");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Eliminar_Meta")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public respuesta Eliminar_Meta(Meta meta) {
//        Operaciones_Meta jap = new Operaciones_Meta();
//        System.out.println(meta.toString());
//        respuesta r = new respuesta();
//        int b1 = jap.delete(meta);
//        if (b1 != 0) {
//            r.setCodigo(0);
//            r.setValor(b1);
//            r.setDescripcion("Se ELIMINO con exito ");
//        } else {
//            r.setCodigo(2);
//            r.setValor(0);
//            r.setDescripcion("No se elimino");
//        }
//        return r;
//    }
//
//    @POST
//    @Path("Consultar_Meta")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Meta> Consultar_Meta(Usuario usurio) {
//        Operaciones_Meta jap = new Operaciones_Meta();
//        System.out.println(usurio.toString());
//        ArrayList<Meta> meta = jap.selectAll(usurio);
//        return meta;
//    }
//
//    @POST
//    @Path("Consultar_Metas")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Meta> Consultar_Metas(Usuario usurio, Date ini, Date fin) {
//        Operaciones_Meta jap = new Operaciones_Meta();
//        System.out.println(usurio.toString());
//        ArrayList<Meta> meta = jap.selectAll(usurio, ini, fin);
//        return meta;
//    }
//
//    @POST
//    @Path("Seguimiento_Metas")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Meta> Seguimiento_Metas(Usuario usurio, Date ini) {
//        Operaciones_Meta jap = new Operaciones_Meta();
//        System.out.println(usurio.toString());
//        Date fin = new Date();
//        ArrayList<Meta> meta = jap.selectAll(usurio, ini, fin, "PENDIENTE");
//        return meta;
//    }
//
//    //-------------------------------SERVICIOS BALANCE GENERAL-----------------------------------------------------
//    @POST
//    @Path("Generar_Balance_General")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Balance_General Generar_Balance_General(Usuario usurio, Date ini, Date fin) {
//        System.out.println(usurio.toString());
//        Balance_General balance_General = new Balance_General();
//        Operaciones_Ingreso operaciones_Ingreso = new Operaciones_Ingreso();
//        Operaciones_Egreso operaciones_Egreso = new Operaciones_Egreso();
//        Operaciones_Activo operaciones_Activo = new Operaciones_Activo();
//        Operaciones_Pasivo operaciones_Pasivo = new Operaciones_Pasivo();
//        balance_General.setListIngresosFijos(operaciones_Ingreso.selectAll(usurio, ini, fin, 1));
//        balance_General.setListIngresosVariables(operaciones_Ingreso.selectAll(usurio, ini, fin, 2));
//        balance_General.setListEgresosFijos(operaciones_Egreso.selectAll(usurio, ini, fin, 1));
//        balance_General.setListEgresosVariables(operaciones_Egreso.selectAll(usurio, ini, fin, 2));
//        balance_General.setActivos(operaciones_Activo.selectAll(usurio, ini, fin));
//        balance_General.setPasivos(operaciones_Pasivo.selectAll(usurio, ini, fin));
//        balance_General.setUsuario(usurio);
//        double totalIngresos = operaciones_Ingreso.selectSum(usurio, ini, fin);
//        double totalEgresos = operaciones_Egreso.selectSum(usurio, ini, fin);
//        double flujoDeCaja = totalIngresos - totalEgresos;
//        balance_General.setFlujoCaja(flujoDeCaja);
//        double totalActivos = operaciones_Activo.selectTotal(usurio, ini, fin);
//        double totalPasivos = operaciones_Pasivo.selectTotal(usurio, ini, fin);
//        double capital = totalActivos - totalPasivos;
//        balance_General.setCapital(capital);
//        return balance_General;
//    }
//}