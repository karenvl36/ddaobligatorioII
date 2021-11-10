/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.VistaLobbyPartida;
import logica.Fachada;
import logica.JugadorPartida;
import logica.Partida;
import observador.Observable;
import observador.Observador;
import interfaz.IVistaMano;
import interfaz.vistas.VistaJugadorLobby;

/**
 *
 * @author chiqu
 */
public class ControladorPartida implements Observador {

    private Partida estaPartida;
    private IVistaMano vistaMano;
    private JugadorPartida player;


    
    public ControladorPartida(IVistaMano vistaMano, Partida unaPartida, JugadorPartida player){
        this.vistaMano = vistaMano;
        this.estaPartida = unaPartida;
        this.player = player;
        estaPartida.subscribir(this);
    
    }

    public void notificar(Observable source, Object event) {
        
   


    }

    public void salir() {
        retirarJugador(this.player);
        estaPartida.desubscribir(this); 
    }

    public void retirarJugador(JugadorPartida jp) {
        estaPartida.retirarJugador(jp);
    }

//    public void mostrarJugadoresFaltantes() {
//        vistaLobby.mostrarJugadoresFaltantes(0);
//    }
//    
  

    public void desuscribir() {
       estaPartida.desubscribir(this);
    }
    
    

}
