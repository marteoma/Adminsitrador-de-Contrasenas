/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import archivo.Lectura_Escritura;
import datos.Contraseña;
import datos.Lista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hhade
 */
public final class MainFrame extends javax.swing.JFrame {

    public static Lista<Contraseña> contraseñas = new Lista<>();
    Contraseña editable = null;
    private static boolean editando = false;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();        
        
        DefaultTableModel modelo = (DefaultTableModel) tableContraseñas.getModel();
        for(int i = 0; i < contraseñas.size(); i++){
            Object[] fila = new Object[4];
            fila[0] = contraseñas.get(i).getNombre();
            fila[1] = contraseñas.get(i).getContraseña();
            fila[2] = contraseñas.get(i).getDescripcion();
            fila[3] = contraseñas.get(i).getFlag();
            modelo.addRow(fila);
        }
        MainFrame.getTabla().setModel(modelo);
        
        tableContraseñas.getModel().addTableModelListener((TableModelEvent e) -> {
            if(editando){
                Contraseña copia = new Contraseña(editable);
                String contraseñaNueva = (String)tableContraseñas.getModel().getValueAt(
                        tableContraseñas.getSelectedRow(), 1);
                contraseñas.Editar(editable, contraseñaNueva);
                Lectura_Escritura.editar(copia,
                        editable.setContraseña(contraseñaNueva));
                editando = false;
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableContraseñas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administra  Contraseñas");
        setResizable(false);

        tableContraseñas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Contraseña", "Descripcion", "Flag"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContraseñas.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tableContraseñas.getTableHeader().setReorderingAllowed(false);
        tableContraseñas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContraseñasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableContraseñas);
        if (tableContraseñas.getColumnModel().getColumnCount() > 0) {
            tableContraseñas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableContraseñas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tableContraseñas.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        NuevoFrame ventanaNuevo = new NuevoFrame();
        ventanaNuevo.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * Evento de clic en el el botón eliminar
     * Elimina la contraseña que estaba seleccionada al apretar el boton
     * O manda un mensaje si no había nada seleccioandao
     * @param evt 
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableContraseñas.getModel();

        int a = tableContraseñas.getSelectedRow();
        if (a < 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila de la tabla");
        }else if(model.getValueAt(a,3).equals('M')){
            JOptionPane.showMessageDialog(null,
                    "No se puede eliminar la contraseña maestra");
        }else {
            int confirmar = JOptionPane.showConfirmDialog(null,
                    "Esta seguro que desea Eliminar el registro? ");

            if (JOptionPane.OK_OPTION == confirmar) {
                String contraseña = (String) model.getValueAt(a, 1);
                contraseñas.remove(contraseña);
                Lectura_Escritura.eliminar(editable);
                model.removeRow(a);
                JOptionPane.showMessageDialog(null,
                        "Registro Eliminado");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Crea la contraseña editable con la que se trabajaran algunos de los metodos
     * de cambio de contraseña
     * @param evt 
     */
    private void tableContraseñasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContraseñasMouseClicked
        if(tableContraseñas.getSelectedRow() != -1){
            int row = tableContraseñas.getSelectedRow();
            editable = new Contraseña((String)tableContraseñas.getModel().getValueAt(row, 0),
                    (String)tableContraseñas.getModel().getValueAt(row, 2),
                    (String)tableContraseñas.getModel().getValueAt(row, 1),
                    (Character)tableContraseñas.getModel().getValueAt(row, 3));
        }
    }//GEN-LAST:event_tableContraseñasMouseClicked

    /**
     * Cambia la propiedad editando a true  para decirle al programa que
     * se editará una contraseña
     * @param evt 
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editando = true;
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    public static JTable getTabla() {
        return tableContraseñas;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tableContraseñas;
    // End of variables declaration//GEN-END:variables
}
