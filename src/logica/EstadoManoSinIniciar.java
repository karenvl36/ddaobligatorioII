/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;

/**
 *
 * @author Karen
 */
public class EstadoManoSinIniciar implements EstadoMano {

    @Override
    public void recibirApuesta(JugadorPartida jugador, int monto, Mano mano) throws JugadorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirPasar(JugadorPartida jugador, Mano mano) throws JugadorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JugadorPartida finalizarMano(Mano mano) {
        return null;
    }

    @Override
    public void recibirMatchApuesta(JugadorPartida j, Mano mano) throws JugadorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void retirarJugador(JugadorPartida j, Mano m) {  
        if (m.getJugadoresActivos().contains(j)) {

            int devolucion = m.getPozo() / m.getJugadoresActivos().size();
            j.getJugador().sumarSaldo(devolucion);
            m.getJugadoresActivos().remove(j);
        }

    }
    
}
