/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.VistaLobbyPartida;
import interfaz.VistaPartida;
import logica.Fachada;
import logica.JugadorPartida;
import logica.Partida;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class ControladorPartida implements Observador {

    private Partida estaPartida;
    private VistaPartida vistaPartida;
    private VistaLobbyPartida vistaLobby;
    private JugadorPartida player;

    public ControladorPartida(VistaPartida view, VistaLobbyPartida lobbyView, Partida unaPartida, JugadorPartida player) {
        this.vistaPartida = view;
        this.estaPartida = unaPartida;
        this.player = player;
        this.vistaLobby = lobbyView;
        estaPartida.subscribir(this);
        vistaLobby.mostrarJugadoresFaltantes(estaPartida.faltanJugadores());

    }

    public void notificar(Observable source, Object event) {
        if (event == Observador.Evento.JUGADOR_AGREGADO || event == Observador.Evento.JUGADOR_ELIMINADO) {
            this.vistaLobby.mostrarJugadoresFaltantes(estaPartida.faltanJugadores());
        }
    }

    public void salir() {
        estaPartida.desubscribir(this);
        retirarJugador(this.player);
    }

    public void retirarJugador(JugadorPartida jp) {
        estaPartida.retirarJugador(jp);
    }

    public void mostrarJugadoresFaltantes() {
        vistaLobby.mostrarJugadoresFaltantes(0);
    }

}
