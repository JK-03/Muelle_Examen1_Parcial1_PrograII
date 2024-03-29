/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Examen_PrograII;

import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jenniferbueso
 */
public class BuscarPorFecha extends javax.swing.JFrame {

    /**
     * Creates new form BuscarPorFecha
     */
    public BuscarPorFecha() {
        initComponents();
        
        DefaultComboBoxModel<String> añosModel = new DefaultComboBoxModel<>();
        Calendar calendar = Calendar.getInstance();
        for (int indice = 2000; indice <= 2100; indice++) {
            añosModel.addElement(String.valueOf(indice));
        }
        FechaBox.setModel(añosModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PasajerosArea = new javax.swing.JTextArea();
        FechaBox = new javax.swing.JComboBox<>();
        BotonAgregar = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        PasajerosArea.setEditable(false);
        PasajerosArea.setBackground(new java.awt.Color(228, 208, 208));
        PasajerosArea.setColumns(20);
        PasajerosArea.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        PasajerosArea.setForeground(new java.awt.Color(113, 91, 91));
        PasajerosArea.setRows(5);
        jScrollPane1.setViewportView(PasajerosArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 630, 170));

        FechaBox.setBackground(new java.awt.Color(213, 180, 180));
        FechaBox.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        FechaBox.setForeground(new java.awt.Color(113, 91, 91));
        FechaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Pesquero", "Pasajero" }));
        jPanel1.add(FechaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 178, 160, 30));

        BotonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAgregarMouseClicked(evt);
            }
        });
        jPanel1.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 160, 40));

        BotonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(BotonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 40, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/BuscarPorFecha.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarMouseClicked
        int fecha = Integer.parseInt(FechaBox.getSelectedItem().toString());
        
        String mostrar = Main_Muelle.muelle.barcosDesde(fecha);
        
        if (mostrar == null) {
            PasajerosArea.setText("No se encontraron barcos.");
        } else {
            PasajerosArea.setText("LISTA DE BARCOS: \n" + mostrar);
        }

    }//GEN-LAST:event_BotonAgregarMouseClicked

    private void BotonRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegresarMouseClicked
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonRegresarMouseClicked

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
            java.util.logging.Logger.getLogger(BuscarPorFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPorFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPorFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPorFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPorFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonAgregar;
    private javax.swing.JLabel BotonRegresar;
    private javax.swing.JComboBox<String> FechaBox;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextArea PasajerosArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
