package Vista;

import Controlador.*;
import DAO_DB.Operaciones_Consejos;
import Modelo.*;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Yuliana Amaya
 */
public class Bienvenido extends javax.swing.JDialog {

    private Usuario usuario;
    private int fechCorte;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getFechCorte() {
        return fechCorte;
    }

    public void setFechCorte(int fechCorte) {
        this.fechCorte = fechCorte;
    }

    public Bienvenido(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        this.fechCorte = 28;
    }

    public String consejoDía() {
        Controlador_Consejo cc = new Controlador_Consejo();
        return cc.Consultar_Consejo();
    }

    public void Seguir_Transaccion() {
        Date fechaSistemam = new Date(System.currentTimeMillis());
        if (fechaSistemam.getDay() == this.fechCorte) {
            Controlador_Ingreso controlador_Ingreso = new Controlador_Ingreso();
            Controlador_Egreso controlador_Egreso = new Controlador_Egreso();
            Controlador_Activo controlador_Activo = new Controlador_Activo();
            Controlador_Pasivo controlador_Pasivo = new Controlador_Pasivo();
            Controlador_Meta controlador_Meta = new Controlador_Meta();

            ArrayList<Ingreso> ingresos = controlador_Ingreso.Consultar_Ingreso(usuario, new Date(fechaSistemam.getYear(), fechaSistemam.getMonth(), 1), fechaSistemam);
            ArrayList<Egreso> egresos = controlador_Egreso.Consultar_Egresos(usuario, new Date(fechaSistemam.getYear(), fechaSistemam.getMonth(), 1), fechaSistemam);
            ArrayList<Activo> activos = controlador_Activo.Consultar_Activo2(usuario, new Date(fechaSistemam.getYear(), fechaSistemam.getMonth(), 1), fechaSistemam);
            ArrayList<Pasivo> pasivos = controlador_Pasivo.Consultar_Pasivo2(usuario, new Date(fechaSistemam.getYear(), fechaSistemam.getMonth(), 1), fechaSistemam);
//            ArrayList<Meta> metas = controlador_Meta.Seguimiento_Metas(usuario, new Date(fechaSistemam.getYear(), fechaSistemam.getMonth(), 1), fechaSistemam);
//            
//            ArrayList list_Egresos = controlador_Egreso.Consultar_Egresos(usuario, new Date(fechaSistemam.getYear(), fechaSistemam.getMonth(), 1), fechaSistemam);
//            for (Ingreso list_Ingreso : list_Ingresos) {
//                if (list_Ingreso.getEstadoIngreso().equals("PENDIENTE")) {
//                    //this.Notificacion.
//                }
//                //ArrayList list_Egresos = controlador_Egreso.Consultar_Egresos(usuario, new Date(fechaSistemam.getYear(), fechaSistemam.getMonth(), 1), fechaSistemam); 
//            }

            if (ingresos.isEmpty()) {
                this.jButton1.setBackground(Color.red);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Calendario"));

        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setText("Notificaciones");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mensajes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Opción");

        jMenu3.setText("Perfil");

        jMenuItem3.setText("Ver Perfil");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Cambiar Contraseña");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenu1.add(jMenu3);

        jMenuItem17.setText("Fecha de corte");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuItem1.setText("Cerrar Sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem16.setText("Salir");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Funcion");

        jMenu7.setText("Ingresos");

        jMenuItem5.setText("Registrar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuItem6.setText("Consultar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenu2.add(jMenu7);

        jMenu8.setText("Egresos");

        jMenuItem9.setText("Registrar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem9);

        jMenuItem10.setText("Consultar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem10);

        jMenu2.add(jMenu8);

        jMenu6.setText("Metas");

        jMenuItem13.setText("Registrar");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem13);

        jMenuItem14.setText("Consultar");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenu2.add(jMenu6);

        jMenu9.setText("Activos");

        jMenuItem7.setText("Registrar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem7);

        jMenuItem8.setText("Consultar");
        jMenu9.add(jMenuItem8);

        jMenu2.add(jMenu9);

        jMenu10.setText("Pasivos");

        jMenuItem11.setText("Registrar");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem11);

        jMenuItem12.setText("Modificar");
        jMenu10.add(jMenuItem12);

        jMenu2.add(jMenu10);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Generar");

        jMenuItem15.setText("Balance General");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem2.setText("Ver Transacciones");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        PerfilUsuario perfilUsuario = new PerfilUsuario(this, true);
        perfilUsuario.setUsuario(usuario);
        this.setVisible(false);
        perfilUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        RegistrarIngresos ingresos = new RegistrarIngresos(this, true);
        ingresos.setUsuario(usuario);
        this.setVisible(false);
        ingresos.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ModificarIngresos reobj = new ModificarIngresos(this, true);
        reobj.setUsuario(usuario);
        this.setVisible(false);
        reobj.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        RegistrarEgresos reobj = new RegistrarEgresos(this, true);
        reobj.setUsuario(usuario);
        this.setVisible(false);
        reobj.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        ModificarEgresos reobj = new ModificarEgresos(this, true);
        reobj.setUsuario(usuario);
        this.setVisible(false);
        reobj.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        RegistrarActivo activos = new RegistrarActivo(this, true);
        activos.setUsuario(usuario);
        this.setVisible(false);
        activos.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        RegistrarMetas metas = new RegistrarMetas(this, true);
        metas.setUsuario(usuario);
        this.setVisible(false);
        metas.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        GenerarBalance generarBalance = new GenerarBalance(this, true);
        generarBalance.setUsuario(usuario);
        this.setVisible(false);
        generarBalance.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CambiarContraseña cambiarContraseña = new CambiarContraseña(this, true);
        this.setVisible(true);
        cambiarContraseña.setUsuario(usuario);
        cambiarContraseña.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        ModificarMetas metas = new ModificarMetas(this, true);
        metas.setUsuario(usuario);
        this.setVisible(false);
        metas.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
//        ConsultarTransacciones consultarTransacciones = new ConsultarTransacciones(this, true);
//        consultarTransacciones.setUsuario(usuario);
//        consultarTransacciones.setFinaly(new Date(this.jCalendar1.getDate().getTime()));
//        consultarTransacciones.setInicial(new Date(this.jCalendar1.getDate().getTime()));
//        this.setVisible(false);
//        consultarTransacciones.setVisible(true);

        if (jCalendar1.mouseEnter(null, WIDTH, WIDTH)) {
            System.out.println("la quito");
        }
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        RegistrarPasivo registrarPasivo = new RegistrarPasivo(this, true);
        registrarPasivo.setUsuario(usuario);
        this.setVisible(false);
        registrarPasivo.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        ConsultarTransacciones consultarTransacciones = new ConsultarTransacciones(this, true);
//        consultarTransacciones.setUsuario(usuario);
//        this.setVisible(false);
//        consultarTransacciones.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        Controlador_Ingreso controlador_Ingreso = new Controlador_Ingreso();
//        Controlador_Egreso controlador_Egreso = new Controlador_Egreso();
//        Controlador_Activo controlador_Activo = new Controlador_Activo();
//        Controlador_Pasivo controlador_Pasivo = new Controlador_Pasivo();
//        Controlador_Meta controlador_Meta = new Controlador_Meta();
//
//        ArrayList<Ingreso> ingresos = controlador_Ingreso.Consultar_Ingreso(usuario);
//        ArrayList<Egreso> egresos = controlador_Egreso.Consultar_Egresos(usuario);
//        ArrayList<Activo> activos = controlador_Activo.Consultar_Activo(usuario);
//        ArrayList<Pasivo> pasivos = controlador_Pasivo.Consultar_Pasivo(usuario);

        Controlador_Ingreso controlador_Ingreso = new Controlador_Ingreso();
        Controlador_Egreso controlador_Egreso = new Controlador_Egreso();
        Controlador_Activo controlador_Activo = new Controlador_Activo();
        Controlador_Pasivo controlador_Pasivo = new Controlador_Pasivo();
        Controlador_Meta controlador_Meta = new Controlador_Meta();

        ArrayList<Ingreso> ingresos = controlador_Ingreso.Consultar_Ingreso(usuario);
        ArrayList<Egreso> egresos = controlador_Egreso.Consultar_Egresos(usuario);
        ArrayList<Activo> activos = controlador_Activo.Consultar_Activo(usuario);
        ArrayList<Pasivo> pasivos = controlador_Pasivo.Consultar_Pasivo(usuario);
        int aasd = 0;
        for (int a = 0; a < ingresos.size(); a++) {
            if (aasd == 0) {
                aasd = JOptionPane.showConfirmDialog(null,"Nombre Ingreso =" + ingresos.get(a).getName_ingreso() + " estado = " + ingresos.get(a).getEstadoIngreso() + "\n");
            }
        }
        aasd = 0;
        for (int a = 0; a < egresos.size(); a++) {
            if (aasd == 0) {
                aasd = JOptionPane.showConfirmDialog(null, "Nombre Egreso = " + egresos.get(a).getName_egreso() + " estado = " + egresos.get(a).getEstado_egreso() + "\n");
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Operaciones_Consejos asd = new Operaciones_Consejos();
        String cate = "Buena";
        ArrayList<String> consejos = asd.selectAll(cate);
        int a = (int) Math.floor(Math.random() * consejos.size() + 1);
        JOptionPane.showMessageDialog(null, "" + consejos.get(a));
        a = 0;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        Configuracion c = new Configuracion(this, true);
        this.setVisible(false);
        c.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Controlador_Ingreso controlador_Ingreso = new Controlador_Ingreso();
        Controlador_Egreso controlador_Egreso = new Controlador_Egreso();
        Controlador_Activo controlador_Activo = new Controlador_Activo();
        Controlador_Pasivo controlador_Pasivo = new Controlador_Pasivo();
        Controlador_Meta controlador_Meta = new Controlador_Meta();
        ArrayList<Ingreso> ingresos = controlador_Ingreso.Consultar_Ingreso(usuario);
        ArrayList<Egreso> egresos = controlador_Egreso.Consultar_Egresos(usuario);
        ArrayList<Activo> activos = controlador_Activo.Consultar_Activo(usuario);
        ArrayList<Pasivo> pasivos = controlador_Pasivo.Consultar_Pasivo(usuario);
        ArrayList<Meta> metas = controlador_Meta.Consultar_Meta(usuario);
        Calendar fecha = new GregorianCalendar();
//      Date fechaSistemam = new Date("");
//        for (int i = 0; i < ingresos.size(); i++) {
////                jCalendar1.getDayChooser().setDay(ingresos.get(i).getDate_ingreso().getDay());
////
////              if(fechaSistemam != (ingresos.get(i).getDate_ingreso()))
////              {
////                  JOptionPane.showMessageDialog(null,""+ingresos.get(i).getDescription());
////              }
//
//        }
//            for(int i = 0;i<egresos.size();i++)
//            {
//                 jCalendar1.setTodayButtonText(""+egresos.get(i).getDate_egreso());
//           }
//            for(int i = 0;i<activos.size();i++)
//            {
//                jCalendar1.setTodayButtonText(""+activos.get(i).getDate_get_activo());
//            }
//            for(int i = 0;i<pasivos.size();i++)
//            {
//                 jCalendar1.setTodayButtonText(""+pasivos.get(i).getDate_get_pasivo());
//           }
//            for(int i = 0;i<metas.size();i++)
//            {
//                jCalendar1.setTodayButtonText(""+metas.get(i).getDate_begin_objective());
//                
//                jCalendar1.setTodayButtonText(""+metas.get(i).getDate_finish_objective());
//            }

        Calendar cal = Calendar.getInstance();
        cal.setTime(jCalendar1.getDate());
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        JPanel jpanel1 = jCalendar1.getDayChooser().getDayPanel();
        Component component1[] = jpanel1.getComponents();
        Component component[] = jpanel1.getComponents();
        String mes = "" + month;
        String ano = "" + (year - 1900);

        String a = "";
        String b = "";

        for (int i = 0; i < ingresos.size(); i++) {

            a = "" + ingresos.get(i).getDate_ingreso().getMonth();
            b = "" + ingresos.get(i).getDate_ingreso().getYear();

            cal.setTime(ingresos.get(i).getDate_ingreso());
            int offset = cal.get(Calendar.DAY_OF_MONTH);
            component[ingresos.get(i).getDate_ingreso().getDay() + offset].setBackground(Color.ORANGE);
        }
        for (int i = 0; i < egresos.size(); i++) {

            a = "" + egresos.get(i).getDate_egreso().getMonth();
            b = "" + egresos.get(i).getDate_egreso().getYear();
            int offset = cal.get(Calendar.DAY_OF_MONTH);
            component1[egresos.get(i).getDate_egreso().getDay() + offset].setBackground(Color.PINK);

        }
        for (int i = 0; i < activos.size(); i++) {

            a = "" + activos.get(i).getDate_get_activo().getMonth();
            b = "" + activos.get(i).getDate_get_activo().getYear();
            cal.setTime(activos.get(i).getDate_get_activo());
            cal.set(Calendar.DAY_OF_MONTH, 1);
            int offset = cal.get(Calendar.DATE) - 2;
            component[activos.get(i).getDate_get_activo().getDay() + offset].setBackground(Color.BLUE);

        }
//                 for (int i = 0; i < ingresos.size(); i++) {
//
//            a=""+ingresos.get(i).getDate_ingreso().getMonth();
//            b=""+ingresos.get(i).getDate_ingreso().getYear();                           
//                cal.setTime(ingresos.get(i).getDate_ingreso());
//                cal.set(Calendar.DAY_OF_MONTH,1);
//                int offset = cal.get(Calendar.DATE)-2;
//                component[ingresos.get(i).getDate_ingreso().getDate()+offset].setBackground(Color.ORANGE);
//
//            
//        }

    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            Bienvenido dialog = new Bienvenido(new javax.swing.JDialog(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
