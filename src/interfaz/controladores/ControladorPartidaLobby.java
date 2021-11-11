/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.IVistaMano;
import interfaz.VistaLobbyPartida;
import logica.JugadorPartida;
import logica.Partida;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Karen
 */
public class ControladorPartidaLobby implements Observador {
    private Partida estaPartida;
    private VistaLobbyPartida vistaLobby;
    private JugadorPartida player;

    public ControladorPartidaLobby(VistaLobbyPartida lobbyView, Partida unaPartida, JugadorPartida player) {
   
        this.estaPartida = unaPartida;
        this.player = player;
        this.vistaLobby = lobbyView;
        estaPartida.subscribir(this);
        vistaLobby.mostrarJugadoresFaltantes(estaPartida.faltanJugadores());

    }
    

    public void notificar(Observable source, Object event) {
        
        if (event == Observador.Evento.PARTIDA_INICIADA) {
            abrirFramePartida();   
            
        }
        if (event == Observador.Evento.JUGADOR_AGREGADO || event == Observador.Evento.JUGADOR_ELIMINADO) {
            
            this.vistaLobby.mostrarJugadoresFaltantes(estaPartida.faltanJugadores());

        }
        

    }

    public void salir() {
        retirarJugador(this.player);
        estaPartida.desubscribir(this); 
    }

    public void retirarJugador(JugadorPartida jp)  {
        estaPartida.retirarJugador(jp);
    }

    public void mostrarJugadoresFaltantes() {
        vistaLobby.mostrarJugadoresFaltantes(0);
    }
    
    public void abrirFramePartida(){  
       
            vistaLobby.abrirFrame(estaPartida, player);
   
        
    }

    public void desuscribir() {
       estaPartida.desubscribir(this);
    }
    
}
