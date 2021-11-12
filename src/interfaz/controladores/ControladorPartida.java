/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import excepciones.JugadorException;
import excepciones.ManoException;
import excepciones.PartidaException;
import interfaz.IDialogoApuesta;

import logica.Fachada;
import logica.JugadorPartida;
import logica.Partida;
import observador.Observable;
import observador.Observador;
import interfaz.IVistaMano;

import java.util.ArrayList;
import java.util.List;
import logica.Carta;
import observador.ObservadorFines;

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
        player.subscribir(this);
        init();
        
    }
    
    /*
    Problemas:
    -El evento de MANO_FINALIZADa no muestra sus acciones antes de uqe le evento MANO_COMENZADA las pase por arriba
    -Uno de los observables reaccciona distisnto cuando termina la partida
    -Falta pedir match apuesta
    -Falta mostrar ganador solo en caso de que la mano finalice con apostante
    -Probar hacer una vista Partida generica que muestre ganador etc y una vistaMano cada vez que se inicie una neuva mano. 
    
    
    */

    public void setDiApuesta(IDialogoApuesta diApuesta) {
        this.diaApuesta = diApuesta;
        diaApuesta.mostrarSaldo(player.getJugador().getSaldo());
    }

    // <editor-fold defaultstate="collapsed" desc="Iniciar">
    public void init() {
         vistaMano.init(player.getJugador().getNick()); 
        mostrarJugadoresEnMano(); 
        mostrarCartas(); 

        vistaMano.init(player.getJugador().getNick()); 

        vistaMano.mostrarMensaje("Faltan jugar: " + estaPartida.faltanPasar() + "jugadores."); 

        
      

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
        String figura = player.getManoJugador().getFigura().getDescripcion(); //TODO: un método más directo?
        String cartasFigura =  player.getManoJugador().getFigura().getDescripcionCartas();
        
    
        vistaMano.mostrarCartas(c1, c2, c3, c4, c5, figura, cartasFigura);
        
    }
    
    
    private String getFigura(){
    
        String figura = player.getManoJugador().getFigura().getDescripcion()  + "</n>"; //TODO: un método más directo?
        figura += player.getManoJugador().getFigura().getDescripcionCartas();
        
        return figura;
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
    
    public void pasar(){
        try{
            estaPartida.recibirPasar(player);
        
        }catch(JugadorException je){
        
            vistaMano.mostrarError(je.getMessage());
        }catch(ManoException pe){
            vistaMano.mostrarError(pe.getMessage());
            
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
       player.desubscribir(this);
    }
    
    
    // </editor-fold>
    
    
    @Override
    public void notificar(Observable source, Object event) {
        if (event == Observador.Evento.JUGADOR_ELIMINADO) {
            this.mostrarJugadoresEnMano();
        }else if(event == Observador.Evento.APUESTA_RECIBIDA){
             mostrarApuestaActiva();
          
     
          // vistaMano.mostrarMensaje("Faltan jugar: " + estaPartida.faltanPasar() + "jugadores.");
        
        }else if(event == Observador.Evento.MANO_FINALIZADA){
          //  vistaMano.mostrarError("Se terminó la mano");
         
            //vistaMano.mostrarGanador("Mano finalizada. Siguiente mano comenzando...");
           // vistaMano.mostrarCartas("/cartas/Invertida.gif", "/cartas/Invertida.gif", "/cartas/Invertida.gif", "/cartas/Invertida.gif", "/cartas/Invertida.gif", "", "");
          // espera(5000);
        }else if(event == Observador.Evento.MANO_COMENZADA){
              //TODO: Ver como hacer que no sustituya el mensaje de nuva mano. Un frame partida con frame mano?
              init();
              
        }else if(event == Observador.Evento.TURNO_JUGADO){
        
            vistaMano.mostrarMensaje("Faltan jugar: " + estaPartida.faltanPasar() + "jugadores.");
        }else if(event == Observador.Evento.APUESTA_PEDIDA){
            vistaMano.pedirApuesta(estaPartida.getApuestaActiva().getNickJugador(), estaPartida.getApuestaActiva().getValor(), player.getJugador().getNick());
            
        }
        

    }

 
    public void mostrarApuestaActiva(){
    
        String jugador = estaPartida.getApuestaActiva().getNickJugador();
        int valorApuesta = estaPartida.getApuestaActiva().getValor();
        vistaMano.mostrarApuestaActiva(jugador, valorApuesta);    
        
    }
    
    

    
     private static void espera(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {}
    }

}


