/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import observador.Observador;

/**
 *
 * @author Karen
 */
public class EstadoPartidaSinIniciar implements EstadoPartida {

    @Override
    public JugadorPartida agregar(UsuarioJugador jugador, Partida p) {
//        JugadorPartida jp = new JugadorPartida(jugador);
//        if (p.faltanJugadores() != 0 && !p.jugadorYaEnPartida(jp) && p.saldoSuficiente(jp)) {
//            p.jugadores.add(jp);
//            p.notificar(Observador.Evento.JUGADOR_AGREGADO);
//            return jp;
//            //TODO: throw la exception que venga de jugadorYaEnPartida?
//            //TODO: throw exception de saldo insuficiente
//        }
        return null;
    }
    
}
