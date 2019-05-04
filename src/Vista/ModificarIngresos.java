package Vista;

import Controlador.Controlador_Ingreso;
import Modelo.Ingreso;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author yuliana
 */
public class ModificarIngresos extends javax.swing.JDialog {

    private Usuario usuario;
    private boolean activo;

    private JPopupMenu popup = new JPopupMenu();
    private JMenuItem jMItemModificar = new JMenuItem("Modificar Registro");
    private JMenuItem jMItemEliminar = new JMenuItem("Eliminar Registro");
    private JMenuItem jMItemSelect = new JMenuItem("Seleccionar Registro");

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.nombre.setText(usuario.getFirst_name());
        this.actualizarTabla();
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
        jMItemSelect.addActionListener((ActionEvent e) -> {
            this.Seleccionar();
        });
    }

    public ModificarIngresos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        popup.add(jMItemModificar);
        popup.add(jMItemEliminar);
        this.tablaIngresos.setComponentPopupMenu(popup);
        jMItemModificar.addActionListener((ActionEvent e) -> {
            this.Modificar();
        });
        jMItemEliminar.addActionListener((ActionEvent e) -> {
            this.Eliminar();
        });
    }

    private void Seleccionar() {
        int fila = this.tablaIngresos.getSelectedRow();
        if (fila != -1) {
            String nomb = (String) this.tablaIngresos.getValueAt(fila, 0);
            String descripcion = (String) this.tablaIngresos.getValueAt(fila, 1);
            float valor = (float) this.tablaIngresos.getValueAt(fila, 2);
            Date fecha = (Date) this.tablaIngresos.getValueAt(fila, 3);
            String estado = (String) this.tablaIngresos.getValueAt(fila, 4);
            Ingreso ingreso = new Ingreso(nomb, descripcion, fecha, valor, estado, null, usuario);
            Controlador_Ingreso ci = new Controlador_Ingreso();
            ingreso = ci.Consultar_Ingreso(ingreso);
            if (ingreso != null) {
                RegistrarActivo registrarActivo = new RegistrarActivo(this, true);
                registrarActivo.setUsuario(usuario);
                this.setVisible(false);
                registrarActivo.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha selecionado ningun registro");
        }
    }

    private void Modificar() {
        int fila = this.tablaIngresos.getSelectedRow();
        if (fila != -1) {
            String nomb = (String) this.tablaIngresos.getValueAt(fila, 0);
            String descripcion = (String) this.tablaIngresos.getValueAt(fila, 1);
            float valor = (float) this.tablaIngresos.getValueAt(fila, 2);
            Date fecha = (Date) this.tablaIngresos.getValueAt(fila, 3);
            String estado = (String) this.tablaIngresos.getValueAt(fila, 4);
            Ingreso ingreso = new Ingreso(nomb, descripcion, fecha, valor, estado, null, usuario);
            Controlador_Ingreso ci = new Controlador_Ingreso();
            ingreso = ci.Consultar_Ingreso(ingreso);
            if (ingreso != null) {
                ModificarIngreso updateIngreso = new ModificarIngreso(this, true);
                this.setVisible(false);
                updateIngreso.setUsuario(usuario);
                updateIngreso.setIngreso(ingreso);
                updateIngreso.setVisible(true);
                this.actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha selecionado ningun registro");
        }
    }

    private void Eliminar() {
        int fila = this.tablaIngresos.getSelectedRow();
        if (fila != -1) {
            String nomb = (String) this.tablaIngresos.getValueAt(fila, 0);
            String descripcion = (String) this.tablaIngresos.getValueAt(fila, 1);
            float valor = (float) this.tablaIngresos.getValueAt(fila, 2);
            Date fecha = (Date) this.tablaIngresos.getValueAt(fila, 3);
            String estado = (String) this.tablaIngresos.getValueAt(fila, 4);
            Ingreso ingreso = new Ingreso(nomb, descripcion, fecha, valor, estado, null, usuario);
            Controlador_Ingreso ci = new Controlador_Ingreso();
            ingreso = ci.Consultar_Ingreso(ingreso);
            if (ingreso != null) {
                ModificarIngreso updateIngreso = new ModificarIngreso(this, true);
                ci.Eliminar_Ingreso(ingreso, fecha, new Date(System.currentTimeMillis()));
                this.actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha selecionado ningun registro");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngresos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tus ingresos ");

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "String", "Descripción", "Valor", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaIngresos);

        jLabel1.setText("Lista de ingresos: ");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
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
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        this.actualizarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Bienvenido b = new Bienvenido(this, true);
        b.setUsuario(usuario);
        b.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void actualizarTabla() {
        Controlador_Ingreso controlador_Ingreso = new Controlador_Ingreso();
        ArrayList<Ingreso> list = controlador_Ingreso.Consultar_Ingreso(usuario);
        int n = list.size();
        Object[][] ingresos = new Object[n][5];
        for (int i = 0; i < n; i++) {
            ingresos[i][0] = list.get(i).getName_ingreso();
            ingresos[i][1] = list.get(i).getDescription();
            ingresos[i][2] = list.get(i).getValue_ingreso();
            ingresos[i][3] = list.get(i).getDate_ingreso();
            ingresos[i][4] = list.get(i).getEstadoIngreso();
        }

        tablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
                ingresos,
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            ModificarIngresos dialog = new ModificarIngresos(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel nombre;
    private javax.swing.JTable tablaIngresos;
    // End of variables declaration//GEN-END:variables
}
