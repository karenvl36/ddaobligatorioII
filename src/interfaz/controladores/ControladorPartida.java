/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import excepciones.JugadorException;
import interfaz.IDialogoApuesta;
import interfaz.VistaLobbyPartida;
import logica.Fachada;
import logica.JugadorPartida;
import logica.Partida;
import observador.Observable;
import observador.Observador;
import interfaz.IVistaMano;
import interfaz.vistas.VistaJugadorLobby;
import java.util.ArrayList;
import java.util.List;
import logica.Carta;

/**
 *
 * @author chiqu
 */
public class ControladorPartida implements Observador {

    private Partida estaPartida;
    private IVistaMano vistaMano;
    private JugadorPartida player;
    private IDialogoApuesta diaApuesta;


    
    public ControladorPartida(IVistaMano vistaMano, Partida unaPartida, JugadorPartida player){
        this.vistaMano = vistaMano;
        this.estaPartida = unaPartida;
        this.player = player;
        estaPartida.subscribir(this);
        init();
        
    }

    public void setDiApuesta(IDialogoApuesta diApuesta) {
        this.diaApuesta = diApuesta;
        diaApuesta.mostrarSaldo(player.getJugador().getSaldo());
    }

    // <editor-fold defaultstate="collapsed" desc="Iniciar">
    public void init() {
        mostrarJugadoresEnMano();
        mostrarCartas();
        vistaMano.init(player.getJugador().getNick());

    }

    public void mostrarJugadoresEnMano() {
        List<String> list = new ArrayList<>();
        estaPartida.jugadoresManoActual().forEach(jp -> {
            list.add(jp.getJugador().getNombreCompleto());
        });

        vistaMano.mostrarJugadoresActivos(list);

    }

    public void mostrarCartas() {

        String rootPath = "/cartas/";
        ArrayList<Carta> cartas = player.getCartasManoJugador();
        String c1 = rootPath + cartas.get(0).getImagen();
        String c2 = rootPath + cartas.get(1).getImagen();
        String c3 = rootPath + cartas.get(2).getImagen();
        String c4 = rootPath + cartas.get(3).getImagen();
        String c5 = rootPath + cartas.get(4).getImagen();
        vistaMano.mostrarCartas(c1, c2, c3, c4, c5);
    }

    // </editor-fold>


    public void realizarApuesta(int apuesta){
        try{
            estaPartida.recibirApuesta(player, apuesta);
            diaApuesta.cerrarDialogo();
            //Mensaje de éxito???
            
        }catch(JugadorException je){
            diaApuesta.mostrarError(je.getMessage());
            
        }
    
    }
    
    
    
    
// <editor-fold defaultstate="collapsed" desc="Terminar">

    public void salir() {
        retirarJugador(this.player);
        estaPartida.desubscribir(this); 
    }

    private void retirarJugador(JugadorPartida jp) {
        estaPartida.retirarJugador(jp);
    }


  

    public void desuscribir() {
       estaPartida.desubscribir(this);
    }
    
    
    // </editor-fold>
    
    
    @Override
    public void notificar(Observable source, Object event) {
        if (event == Observador.Evento.JUGADOR_ELIMINADO) {
            this.mostrarJugadoresEnMano();
        }else if(event == Observador.Evento.APUESTA_RECIBIDA){
           mostrarApuestaActiva();
        }
        

    }

 
    public void mostrarApuestaActiva(){
    
        String jugador = estaPartida.getApuestaActiva().getNickJugador();
        int valorApuesta = estaPartida.getApuestaActiva().getValor();
        vistaMano.mostrarApuestaActiva(jugador, valorApuesta);
        
    }
    
    
    public void test(){
    
        estaPartida.notificar(this);
    }

}


