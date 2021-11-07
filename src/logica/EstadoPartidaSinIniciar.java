/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.PartidaException;
import observador.Observador;

/**
 *
 * @author Karen
 */
public class EstadoPartidaSinIniciar implements EstadoPartida {

    @Override
    public JugadorPartida agregar(UsuarioJugador usuarioJ, Partida p) throws PartidaException, JugadorException {

      // estado.agregar(usuarioJ, this); TODO: Fix el problema de la privacidad de los métodos que usa Estado
        JugadorPartida jp = new JugadorPartida(usuarioJ);

        if (p.faltanJugadores() != 0) {
            p.jugadorYaEnPartida(jp);
            p.saldoSuficiente(jp);
            p.guardarJugadorEnLista(jp);
            p.notificar(Observador.Evento.JUGADOR_AGREGADO);
            return jp;
        }
        return null;
    }

}
