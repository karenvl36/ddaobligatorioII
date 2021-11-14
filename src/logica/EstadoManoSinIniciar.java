/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import observador.Observador;

/**
 *
 * @author Karen
 */
public class EstadoManoSinIniciar implements EstadoMano {

    @Override
    public void recibirApuesta(JugadorPartida jugador, int monto, Mano mano) throws JugadorException {
       
    }

    @Override
    public void recibirPasar(JugadorPartida jugador, Mano mano) throws JugadorException {
       
    }

    @Override
    public boolean finalizarMano(Mano mano) {
        return false;
    }

    @Override
    public void recibirMatchApuesta(JugadorPartida j, Mano mano) throws JugadorException {
        
    }

    @Override
    public void retirarJugador(JugadorPartida j, Mano m) {  
        if (m.getJugadoresActivos().contains(j)) {      
            j.getJugador().sumarSaldo(m.getApuestaBase());
            m.getJugadoresActivos().remove(j);
        }

    }
    
     public boolean iniciar(Mano m) {
        if (!m.jugadoresInsuficientes()) {
            m.setEstado(new EstadoManoSinApuestas());
            m.getMazo().barajar();
            for (JugadorPartida j : m.getJugadoresActivos()) {
                ManoJugador mj = new ManoJugador(m.getMazo().repartir());

                j.setManoJugador(mj);
            }
          // cartasParaTestear();
         
           m.notificar(Observador.Evento.MANO_COMENZADA);

            return true;
        }
        return false;
    }


    
}
