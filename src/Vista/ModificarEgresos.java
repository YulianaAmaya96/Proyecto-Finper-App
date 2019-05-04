package Vista;

import Controlador.Controlador_Egreso;
import Modelo.Egreso;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author Yuliana Amaya
 */

public class ModificarEgresos extends javax.swing.JDialog {

    private Usuario usuario;
    private boolean pasivo;

    private JPopupMenu popup = new JPopupMenu();
    private JMenuItem jMItemModificar = new JMenuItem("Modificar Registro");
    private JMenuItem jMItemEliminar = new JMenuItem("Eliminar Registro");
    private JMenuItem jMItemSelect = new JMenuItem("Seleccionar Registro");

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.actualizarTabla();
    }

    public boolean isPasivo() {
        return pasivo;
    }

    public void setPasivo(boolean pasivo) {
        this.pasivo = pasivo;
        jMItemSelect.addActionListener((ActionEvent e) -> {
            this.Seleccionar();
        });
    }

    public ModificarEgresos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        popup.add(jMItemModificar);
        popup.add(jMItemEliminar);
        this.tablaEgresos.setComponentPopupMenu(popup);
        jMItemModificar.addActionListener((ActionEvent e) -> {
            this.Modificar();
        });
        jMItemEliminar.addActionListener((ActionEvent e) -> {
            this.Eliminar();
        });
    }

    private void Seleccionar() {
        int fila = this.tablaEgresos.getSelectedRow();
        if (fila != -1) {
            String nomb = (String) this.tablaEgresos.getValueAt(fila, 0);
            String descripcion = (String) this.tablaEgresos.getValueAt(fila, 1);
            float valor = (float) this.tablaEgresos.getValueAt(fila, 2);
            Date fecha = (Date) this.tablaEgresos.getValueAt(fila, 3);
            String estado = (String) this.tablaEgresos.getValueAt(fila, 4);
            Egreso egreso = new Egreso(nomb, descripcion, fecha, valor, estado, 0, null, usuario);
            Controlador_Egreso ci = new Controlador_Egreso();
            egreso = ci.Consultar_Egreso(egreso);
            if (egreso != null) {
                RegistrarPasivo registrarPasivo = new RegistrarPasivo(this, true);
                registrarPasivo.setUsuario(usuario);
                this.setVisible(false);
                registrarPasivo.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha selecionado ningun registro");
        }
    }

    private void Modificar() {
        int fila = this.tablaEgresos.getSelectedRow();
        if (fila != -1) {
            String nomb = (String) this.tablaEgresos.getValueAt(fila, 0);
            String descripcion = (String) this.tablaEgresos.getValueAt(fila, 1);
            float valor = (float) this.tablaEgresos.getValueAt(fila, 2);
            Date fecha = (Date) this.tablaEgresos.getValueAt(fila, 3);
            String estado = (String) this.tablaEgresos.getValueAt(fila, 4);
            Egreso egreso = new Egreso(nomb, descripcion, fecha, valor, estado, 0, null, usuario);
            Controlador_Egreso ci = new Controlador_Egreso();
            egreso = ci.Consultar_Egreso(egreso);
            if (egreso != null) {
                ModificarEgreso updateEgreso = new ModificarEgreso(this, true);
                this.setVisible(false);
                updateEgreso.setUsuario(usuario);
                updateEgreso.setIngreso(egreso);
                updateEgreso.setVisible(true);
                this.actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha selecionado ningun registro");
        }
    }

    private void Eliminar() {
        int fila = this.tablaEgresos.getSelectedRow();
        if (fila != -1) {
            String nomb = (String) this.tablaEgresos.getValueAt(fila, 0);
            String descripcion = (String) this.tablaEgresos.getValueAt(fila, 1);
            float valor = (float) this.tablaEgresos.getValueAt(fila, 2);
            Date fecha = (Date) this.tablaEgresos.getValueAt(fila, 3);
            String estado = (String) this.tablaEgresos.getValueAt(fila, 4);
            Egreso egreso = new Egreso(nomb, descripcion, fecha, valor, estado, 0, null, usuario);
            Controlador_Egreso ci = new Controlador_Egreso();
            egreso = ci.Consultar_Egreso(egreso);
            if (egreso != null) {
                ci.Eliminar_Egreso(egreso);
                this.actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha selecionado ningun registro");
        }
    }

    public void actualizarTabla() {
        Controlador_Egreso controlador_Egreso = new Controlador_Egreso();
        ArrayList<Egreso> list = controlador_Egreso.Consultar_Egresos(usuario);
        int n = list.size();
        Object[][] egresos = new Object[n][5];
        for (int i = 0; i < n; i++) {
            egresos[i][0] = list.get(i).getName_egreso();
            egresos[i][1] = list.get(i).getDesciption_egreso();
            egresos[i][2] = list.get(i).getValue_egreso();
            egresos[i][3] = list.get(i).getDate_egreso();
            egresos[i][4] = list.get(i).getEstado_egreso();
        }

        tablaEgresos.setModel(new javax.swing.table.DefaultTableModel(
                egresos,
                new String[]{
                    "Nombre", "Descripción", "Valor", "Fecha", "Estado"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEgresos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tus Egresos ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        tablaEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción", "Valor", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEgresos);

        jLabel1.setText("Lista de egresos: ");

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Bienvenido bienvenido = new Bienvenido(this, pasivo); 
        bienvenido.setUsuario(usuario);
        this.setVisible(false);
        bienvenido.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            ModificarEgresos dialog = new ModificarEgresos(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEgresos;
    // End of variables declaration//GEN-END:variables
}
