/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.vistas;

import interfaz.IVistaMano;
import interfaz.controladores.ControladorMano;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logica.JugadorPartida;
import logica.Partida;

/**
 *
 * @author Karen
 */
public class VistaMano extends javax.swing.JFrame implements IVistaMano {

    /**
     * Creates new form VistaPartida
     */
    
    ControladorMano cp;
    JFrame framePanelApuesta;
    JFrame framePanelGanador;

    
    public VistaMano(Partida p, JugadorPartida jp) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this.getParent());

        cp = new ControladorMano(this, p, jp);
        framePanelApuesta = new JFrame();
        framePanelGanador = new JFrame();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lJugadoresEnPartida = new javax.swing.JList();
        btnApostar = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblFigura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        carta1 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        carta4 = new javax.swing.JLabel();
        carta5 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        txtApuestaActual = new javax.swing.JLabel();
        lblCartasFigura = new javax.swing.JLabel();
        lblGanador = new javax.swing.JLabel();
        lblMensajes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblPozo = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setViewportView(lJugadoresEnPartida);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblFigura.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblFigura.setText("Figura");

        jLabel1.setText("Jugadores activos:");

        carta1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta1.setBorder(null);

        carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta3.setBorder(null);

        carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta4.setBorder(null);

        carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta5.setBorder(null);

        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta2.setBorder(null);

        lblCartasFigura.setText("cartasFigura");

        lblGanador.setText("Ganador");

        lblPozo.setEditable(false);
        jScrollPane2.setViewportView(lblPozo);

        jLabel2.setText("Pozo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCartasFigura))
                .addGap(392, 392, 392))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(btnApostar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(carta2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(carta1)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carta3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carta4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carta5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(txtApuestaActual))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(btnPasar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSalir)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(lblMensajes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblGanador)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnSalir)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(txtApuestaActual))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFigura)
                        .addGap(18, 18, 18)
                        .addComponent(lblCartasFigura)
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carta2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(carta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(carta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(carta1))
                            .addComponent(carta3))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPasar)
                            .addComponent(btnApostar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensajes)
                .addGap(39, 39, 39)
                .addComponent(lblGanador)
                .addGap(127, 127, 127))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        abrirDialogoApuesta(null, null);
        
    }//GEN-LAST:event_btnApostarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        abandonarPartida();
    }//GEN-LAST:event_formWindowClosed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        pasar();
    }//GEN-LAST:event_btnPasarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        abandonarPartida();
    }//GEN-LAST:event_btnSalirActionPerformed

    
    

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JLabel carta4;
    private javax.swing.JLabel carta5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lJugadoresEnPartida;
    private javax.swing.JLabel lblCartasFigura;
    private javax.swing.JLabel lblFigura;
    private javax.swing.JLabel lblGanador;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JTextPane lblPozo;
    private javax.swing.JLabel txtApuestaActual;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarCartas(String c1, String c2, String c3, String c4, String c5, String Figura, String cartas) {
        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(c1)));
        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(c2)));
        carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(c3)));
        carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(c4)));
        carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(c5)));
        lblFigura.setText(Figura);
        lblCartasFigura.setText(cartas);
    }
    
    
    @Override
    public void mostrarJugadoresActivos(List<String> jugadores) {
        lJugadoresEnPartida.setListData(jugadores.toArray());
    }

    @Override
    public void abrirDialogoApuesta(Partida p, JugadorPartida jp) {
        new DialogoApostar(this, false, cp).setVisible(true);
    }

    @Override
    public void pasar() {
        
      
        cp.pasar();

      // mostrarCartas("/cartas/Invertida.gif", "/cartas/Invertida.gif", "/cartas/Invertida.gif", "/cartas/Invertida.gif", "/cartas/Invertida.gif");
        btnApostar.setEnabled(false);
        btnPasar.setEnabled(false);
        cp.mostrarJugadoresEnMano(); //TODO: Sacar esto
    }
    
    

  
    public void abandonarPartida() {
        cp.salir();
      
    }

    @Override
    public void init(String nombreJugador, String pozo) {
        btnApostar.setEnabled(true);
        btnPasar.setEnabled(true);
        this.setTitle(nombreJugador);
       // lbJugador.setText(nombreJugador);
        actualizarPozo(pozo);
    }

    @Override
    public void mostrarApuestaActiva(String jugador, int valor) {
        txtApuestaActual.setText("Apuesta por $ " + valor + "realizada por " + jugador);
        btnApostar.setEnabled(false);
        //TODO: Agregar un boton de match a la apuesta
        
    }

    @Override
    public void pedirApuesta(String apostante, int valor, String playerActual) {
        PanelMatchApuesta panel = new PanelMatchApuesta(cp, valor, apostante, playerActual);
        framePanelApuesta.add(panel);
        framePanelApuesta.pack();
        framePanelApuesta.setVisible(true);

    }
    

    

    @Override
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    @Override
    public void fold() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        lblMensajes.setText(mensaje);
    }
    
    
    @Override
      public void mostrarGanador(String nombreGanador, String figura, String cartas, String saldo) {
       // cerrarPanel();
  
        lblGanador.setText(nombreGanador);
        ofrecerSiguienteMano(nombreGanador, figura, cartas, saldo);
    }
    
      

    @Override
    public void cerrarVentana() {
        this.dispose();
    }

    @Override
    public void vistaFolded(String cartaReversa, String mensaje) {
        cerrarPanel();
        mostrarCartas(cartaReversa, cartaReversa, cartaReversa, cartaReversa, cartaReversa, mensaje, "");
        
    }
    
    
    public void cerrarPanel(){
           // framePanel.removeAll();
            //framePanel.setVisible(false);  
    }

    @Override
    public void actualizarPozo(String pozo) {
          lblPozo.setText(pozo);
    }

    @Override
    public void ofrecerSiguienteMano(String ganador, String figura, String cartas, String saldo) {
         PanelGanador panel = new PanelGanador(cp, ganador, figura, cartas, saldo);
        framePanelGanador.add(panel);
        framePanelGanador.pack();
        framePanelGanador.setVisible(true); 
        
    }
    
    
  

      
 
}
