
package interfaz.vistas;

import interfaz.VistaLobbyPartida;
import interfaz.controladores.ControladorMano;
import interfaz.controladores.ControladorPartidaLobby;
import logica.Partida.JugadorPartida;
import logica.Partida.Partida;
import logica.UsuarioJugador;




public class VistaJugadorLobby extends javax.swing.JFrame implements VistaLobbyPartida {

//private Partida estaPartidaNoIniciada;
//private JugadorPartida jugadorP;
//private ControladorPartida cp;
private ControladorPartidaLobby cp;

    public VistaJugadorLobby(Partida partidaLobby,JugadorPartida jugador) {
        initComponents();
       // this.estaPartidaNoIniciada = partidaLobby;
     //   jugadorP = jugador;
        
        //(VistaPartida view, VistaLobbyPartida lobbyView, Partida unaPartida, JugadorPartida player)
       // cp = new ControladorPartida(this,estaPartidaNoIniciada,jugadorP);
        cp = new ControladorPartidaLobby(this,partidaLobby,jugador);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEsperandoJugadores = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        labelEsperandoJugadores.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        labelEsperandoJugadores.setText("Falatan");

        jLabel1.setText("Esperando jugadores para iniciar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEsperandoJugadores)
                    .addComponent(jLabel1))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEsperandoJugadores)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       cp.desuscribir();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cp.salir();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
         
    }//GEN-LAST:event_formWindowDeactivated

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelEsperandoJugadores;
    // End of variables declaration//GEN-END:variables


    
    @Override
    public void mostrarJugadoresFaltantes(int cantJugadoresFaltantes) {
        labelEsperandoJugadores.setText("Faltan: " + cantJugadoresFaltantes);
        this.setTitle("Faltan: " + cantJugadoresFaltantes);
    }


    @Override
    public void abrirFrame(Partida p, JugadorPartida jp) {
        //new VistaPartida(p, jp).setVisible(true);
        VistaMano vm = new VistaMano(p, jp);
        vm.setVisible(true); 
        this.dispose();
       
       
    }

 



  
}
