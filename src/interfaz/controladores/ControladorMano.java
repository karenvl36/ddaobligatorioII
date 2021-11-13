/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import excepciones.JugadorException;
import excepciones.ManoException;

import interfaz.IDialogoApuesta;

import logica.JugadorPartida;
import logica.Partida;
import observador.Observable;
import observador.Observador;
import interfaz.IVistaMano;

import java.util.ArrayList;
import java.util.List;

import logica.Carta;
import logica.Mano;

/**
 *
 * @author chiqu
 */
public class ControladorMano implements Observador {

    private Partida estaPartida;
    private Mano manoActual;
    private IVistaMano vistaMano;
    private JugadorPartida player;
    private IDialogoApuesta diaApuesta;

    public ControladorMano(IVistaMano vistaMano, Partida unaPartida, JugadorPartida player) {
        this.vistaMano = vistaMano;
        this.estaPartida = unaPartida;
        this.player = player;

        estaPartida.getManoActual().subscribir(this);
        player.subscribir(this);

        init();

    }

    public void setDiApuesta(IDialogoApuesta diApuesta) {
        this.diaApuesta = diApuesta;
        diaApuesta.mostrarSaldo(player.getJugador().getSaldo());
    }

    // <editor-fold defaultstate="collapsed" desc="Iniciar">
    public void init() {
        vistaMano.mostrarApuestaActiva("No hay apuestas.", 0);
        manoActual = estaPartida.getManoActual();
        vistaMano.init(player.getJugador().getNick(), "$" + manoActual.getPozo());
        mostrarJugadoresEnMano();
        mostrarCartas();
        vistaMano.mostrarMensaje("Faltan jugar: " + estaPartida.faltanPasar() + " jugadores.");

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
        String cartasFigura = player.getManoJugador().getFigura().getDescripcionCartas();

        vistaMano.mostrarCartas(c1, c2, c3, c4, c5, figura, cartasFigura);

    }

    // </editor-fold>
    public void realizarApuesta(int apuesta) {
        try {
            estaPartida.recibirApuesta(player, apuesta);
            diaApuesta.cerrarDialogo();
            //Mensaje de éxito???

        } catch (JugadorException je) {
            diaApuesta.mostrarError(je.getMessage());

        }

    }

    public void pasar() {
        try {
            estaPartida.recibirPasar(player);

        } catch (JugadorException je) {

            vistaMano.mostrarError(je.getMessage());
        } catch (ManoException pe) {
            vistaMano.mostrarError(pe.getMessage());

        }

    }

    public void matchApuesta() {

        try {
            estaPartida.recibirMatchApuesta(player);
        } catch (JugadorException je) {

            vistaMano.mostrarError(je.getMessage());
            //vistaMano.cerrarVentana();
            vistaMano.vistaFolded("/cartas/Invertida.gif", "Se saldo era insuficiente para el match de apuesta.");
            this.desuscribir();
        }
    }

    public void fold() {
        try {
            estaPartida.recibirPasar(player);
            vistaMano.vistaFolded("/cartas/Invertida.gif", "Se retiró de la mano.");

        } catch (JugadorException je) {
            vistaMano.mostrarError(je.getMessage());

        } catch (ManoException me) { //TODO: Ver quién está generando esta exception

            vistaMano.mostrarError(me.getMessage());
        }

    }

// <editor-fold defaultstate="collapsed" desc="Terminar">
    public void salir() {
        manoActual.desubscribir(this);
        retirarJugador(this.player);
        // estaPartida.desubscribir(this); 

        vistaMano.cerrarVentana();
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
         if (event == Observador.Evento.MANO_FINALIZADA) {
            vistaMano.mostrarFinMano("No hay ganador en esta mano.", "", "", "$" + player.getJugador().getSaldo(), player.getJugador().getNick());
            vistaMano.mostrarMensaje("Mano finalizada");
           // manoActual.desubscribir(this);
        
        
         }  else if (event == Observador.Evento.JUGADOR_ELIMINADO) {
            this.mostrarJugadoresEnMano();
        } else if (event == Observador.Evento.APUESTA_RECIBIDA) {
            mostrarApuestaActiva();
            vistaMano.actualizarPozo("$" + manoActual.getPozo());
        } else if (event == Observador.Evento.GANADOR_DECLARADO) {

            mostrarGanador();
          //  manoActual.desubscribir(this);

        } else if (event == Observador.Evento.MANO_COMENZADA) {
            // vistaMano.abrirNuevaMano(estaPartida, player);
            init();
        } else if (event == Observador.Evento.TURNO_JUGADO) {
            vistaMano.mostrarMensaje("Faltan jugar: " + estaPartida.faltanPasar() + " jugadores.");
        } else if (event == Observador.Evento.APUESTA_PEDIDA) {
            vistaMano.pedirApuesta(estaPartida.getApuestaActiva().getNickJugador(), estaPartida.getApuestaActiva().getValor(), player.getJugador().getNick());

        
        }else if(event == Observador.Evento.PARTIDA_FINALIZADA){
        
            vistaMano.mostrarError("Terminó la partida.");
        }

    }

    public void mostrarApuestaActiva() {

        String jugador = estaPartida.getApuestaActiva().getNickJugador();
        int valorApuesta = estaPartida.getApuestaActiva().getValor();
        vistaMano.mostrarApuestaActiva(jugador, valorApuesta);

    }

    public void unirAProximaMano() {
        vistaMano.vistaFolded("/cartas/Invertida.gif", "COMENZANDO LA SIGUIENTE MANO...");
        estaPartida.getManoActual().subscribir(this);
        try {
            estaPartida.unirASiguienteMano(player);

            //  init();
        } catch (JugadorException je) {

            vistaMano.mostrarError(je.getMessage());
            //  salir();
        }

    }

    private void mostrarGanador() {
        String figura = manoActual.getGanador().getManoJugador().getFigura().getDescripcion(); //TODO: un método más directo?
        String cartasFigura = manoActual.getGanador().getManoJugador().getFigura().getDescripcionCartas();
        String ganador = manoActual.getGanador().getJugador().getNick();
        String saldo = "$" + player.getJugador().getSaldo();
        vistaMano.mostrarFinMano(ganador, figura, cartasFigura, saldo, player.getJugador().getNick());
    }

}
