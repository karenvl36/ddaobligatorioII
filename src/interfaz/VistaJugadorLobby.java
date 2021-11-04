
package interfaz;

import logica.Fachada;
import logica.JugadorPartida;
import logica.Partida;
import logica.UsuarioJugador;
import observador.Observable;
import observador.Observador;




public class VistaJugadorLobby extends javax.swing.JFrame implements Observador {

private Partida estaPartidaNoIniciada;
private UsuarioJugador jugador;
private JugadorPartida jugadorP;

    public VistaJugadorLobby(UsuarioJugador jugador) {
        this.estaPartidaNoIniciada = Fachada.getInstancia().getPartidaSinIniciar();
        this.jugador=jugador;
        
        estaPartidaNoIniciada.subscribir(this);
        initFrame();
        initComponents();
        
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEsperandoJugadores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        labelEsperandoJugadores.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(labelEsperandoJugadores)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(labelEsperandoJugadores)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       estaPartidaNoIniciada.desubscribir(this);
       estaPartidaNoIniciada.retirarJugador(jugadorP);
    }//GEN-LAST:event_formWindowClosed

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelEsperandoJugadores;
    // End of variables declaration//GEN-END:variables

       private void initFrame() {
        jugadorP = Fachada.getInstancia().unirJugadorPartida(this.jugador); //Une jugador al lobby.
        
    }
       
          @Override
    public void notificar(Observable source, Object event) {
        if(event == Observador.Evento.JUGADOR_AGREGADO){
            cambiarTitulo();
        }
    }

    private void cambiarTitulo() {
        //labelEsperandoJugadores.setText();
        this.setTitle("Esperando jugadores, faltan: " + this.estaPartidaNoIniciada.faltanJugadores());
    }
  
}
