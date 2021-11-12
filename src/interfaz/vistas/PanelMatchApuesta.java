/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.vistas;

import interfaz.controladores.ControladorMano;
import java.awt.Window;
import javax.swing.SwingUtilities;

/**
 *
 * @author Karen
 */
public class PanelMatchApuesta extends javax.swing.JPanel {

    /**
     * Creates new form PanelMatchApuesta
     */
    
    ControladorMano cm;
    public PanelMatchApuesta(ControladorMano cp, int valor, String apostante, String playerActual) {
        initComponents();
        cm = cp;
        init(valor, apostante, playerActual);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMatch = new javax.swing.JButton();
        btnFold = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblValorApuesta = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        lblDeJugador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });

        btnMatch.setText("Match");
        btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchActionPerformed(evt);
            }
        });

        btnFold.setText("Abandonar");
        btnFold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoldActionPerformed(evt);
            }
        });

        jLabel1.setText("Apuesta:");

        jLabel2.setText("Jugador:");

        lblValorApuesta.setText("jLabel3");

        lblJugador.setText("jLabel4");

        lblDeJugador.setText("jLabel3");

        jLabel3.setText("¿Desea aceptar la apuesta actual?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorApuesta)
                            .addComponent(lblJugador)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMatch)
                                .addGap(117, 117, 117)
                                .addComponent(btnFold))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblDeJugador)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblDeJugador)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblValorApuesta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatch)
                    .addComponent(btnFold))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed
        
        matchApuesta();
        cerrarPanel();
    }//GEN-LAST:event_btnMatchActionPerformed

    private void btnFoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoldActionPerformed
        cerrarPanel();
     //   fold();
    }//GEN-LAST:event_btnFoldActionPerformed

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        fold();
    }//GEN-LAST:event_formAncestorRemoved

    public void init(int valor, String jugador, String playerActual){
        this.lblDeJugador.setText(playerActual); //Para identificar de quien es la ventana
        lblValorApuesta.setText("$" + valor);
        lblJugador.setText(jugador);
        Window win = SwingUtilities.getWindowAncestor(this);
        
        
    }
    
    
    public void matchApuesta(){
    
        cm.matchApuesta();

    }
    
    
    public void fold(){
    
        cm.fold();
    
    }
    
    public void cerrarPanel(){
          Window win = SwingUtilities.getWindowAncestor(this);
         win.dispose();
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFold;
    private javax.swing.JButton btnMatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDeJugador;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblValorApuesta;
    // End of variables declaration//GEN-END:variables
}
