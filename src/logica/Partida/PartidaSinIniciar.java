/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Partida;

import excepciones.JugadorException;
import excepciones.ManoException;
import excepciones.PartidaException;
import observador.Observador;

/**
 *
 * @author Karen
 */
public class PartidaSinIniciar implements EstadoPartida {

    @Override
    public Partida agregar(JugadorPartida jp, Partida p) throws PartidaException, JugadorException, ManoException {

   


        if (p.faltanJugadores() != 0) {
            p.jugadorYaEnPartida(jp);
            p.saldoSuficienteLuz(jp);
            p.getJugadores().add(jp);
            p.getManoActual().agregar(jp, p.getApuestaBase());
            p.modificarTotalApostado(p.getApuestaBase());
            p.notificar(Observador.Evento.JUGADOR_AGREGADO);
            return p;
        }
        return null;
    }

}
