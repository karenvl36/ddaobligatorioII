/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.vistas;

import interfaz.controladores.ControladorMano;

/**
 *
 * @author Karen
 */
public class DialogoMatchApuesta extends javax.swing.JDialog {

    ControladorMano cm;
     
     
    public DialogoMatchApuesta(java.awt.Frame parent, boolean modal, ControladorMano controlador, int valor, String apostante, String playerActual, int saldo) {
        super(parent, modal);
        initComponents();
        this.cm = controlador;
        init(valor, apostante, playerActual, saldo);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDeJugador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblValorApuesta = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        btnMatch = new javax.swing.JButton();
        btnFold = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblDeJugador.setText("nombreJugador");

        jLabel1.setText("¿Desea aceptar la apuesta actual?");

        jLabel2.setText("Apuesta:");

        jLabel3.setText("Jugador:");

        lblValorApuesta.setText("jLabel4");

        lblJugador.setText("jLabel4");

        btnMatch.setText("Aceptar");
        btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchActionPerformed(evt);
            }
        });

        btnFold.setText("Rendirse");
        btnFold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoldActionPerformed(evt);
            }
        });

        jLabel4.setText("Saldo:");

        lblSaldo.setText("lblSaldo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnMatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(btnFold)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblDeJugador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblJugador))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(33, 33, 33)
                                    .addComponent(lblValorApuesta))))))
                .addGap(18, 18, 18)
                .addComponent(lblSaldo)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeJugador)
                    .addComponent(jLabel4)
                    .addComponent(lblSaldo))
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblValorApuesta))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblJugador))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatch)
                    .addComponent(btnFold))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed
        matchApuesta();
    }//GEN-LAST:event_btnMatchActionPerformed

    private void btnFoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoldActionPerformed
        fold();
    }//GEN-LAST:event_btnFoldActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fold();
    }//GEN-LAST:event_formWindowClosing

     public void init(int valor, String jugador, String playerActual, int saldo) {
        this.lblDeJugador.setText(playerActual); //Para identificar de quien es la ventana    
        this.lblSaldo.setText("$" + saldo);
        lblValorApuesta.setText("$" + valor);
        lblJugador.setText(jugador);

    }

    public void matchApuesta() {
        cm.matchApuesta();
        this.dispose();
    }

    public void fold() {
        cm.fold();
        this.dispose();
    }



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFold;
    private javax.swing.JButton btnMatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblDeJugador;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblValorApuesta;
    // End of variables declaration//GEN-END:variables
}
