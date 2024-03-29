/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Partida;

import excepciones.JugadorException;
import excepciones.ManoException;
import excepciones.PartidaException;
import java.util.ArrayList;
import java.util.List;
import logica.Fachada;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class ServicioPartida {

    public List<Partida> partidasEnCurso;
    public Partida partidaAIniciar;
//    private static ServicioPartida instancia;
//
//    public static ServicioPartida getInstancia() {
//
//        if (instancia == null) {
//            instancia = new ServicioPartida();
//        }
//        return instancia;
//    }

    public ServicioPartida() {
        this.partidasEnCurso = new ArrayList<>();
        partidaAIniciar = new Partida();

    }

    public boolean agregar(Partida p) {
        return this.partidasEnCurso.add(p);
    }

    public boolean terminar(Partida p) {
        return this.partidasEnCurso.add(p);
    }

    private void crearPartida(Partida p) {
        if (p != null) {
            partidasEnCurso.add(p);
            Fachada.getInstancia().notificar(Observador.Evento.PARTIDA_INICIADA);
        }
        Partida partidaNueva = new Partida();
        partidaAIniciar = partidaNueva;
    }

    public Partida getPartidaSinIniciar() {
        return this.partidaAIniciar;
    }

    public Partida unirJugadorPartida(JugadorPartida j) throws PartidaException, JugadorException, ManoException {
        //  JugadorPartida jugadorRetorno = null;
        Partida partida = partidaAIniciar;
        if (partida != null) {

            if (partida.agregar(j) != null) {
                crearPartida(partida);
            }
        }
        return partida;

    }

    public List<Partida> getPartidasEnCurso() {
        return this.partidasEnCurso;
    }

    public void apostar(Partida p, JugadorPartida j, int apuesta) throws JugadorException {
        p.recibirApuesta(j, apuesta);
        Fachada.getInstancia().notificar(Observador.Evento.POZO_MODIFICADO);

    }

    public void pasar(Partida p, JugadorPartida j) throws ManoException, JugadorException {
        p.recibirPasar(j);
        notificarSiFinMano(p);

    }

    public void matchApuesta(Partida p, JugadorPartida j) throws JugadorException {
        try {
            p.recibirMatchApuesta(j);
            Fachada.getInstancia().notificar(Observador.Evento.POZO_MODIFICADO);
           
        } catch (JugadorException je) {
                
            throw je;
        }finally{
            notificarSiFinMano(p);
        } 

    }

    public void retirarJugador(Partida p, JugadorPartida j) {
        p.retirarJugador(j);
        Fachada.getInstancia().notificar(Observador.Evento.JUGADOR_ELIMINADO);
        notificarSiFinMano(p);
        notificarSiInicioMano(p);
        notificarSiFinPartida(p);

    }

//    public void rechazarNuevaMano(Partida p, JugadorPartida j){
//        p.rechazarNuevaMano(j);
//        notificarSiInicioMano(p);
//        notificarSiFinPartida(p);  
//    }
    private void notificarSiFinMano(Partida p) {
        if (p.comprobarFinalizarMano()) {

            Fachada.getInstancia().notificar(Observador.Evento.MANO_FINALIZADA);
        }
    }

    private void notificarSiFinPartida(Partida p) {
        if (p.partidaFinalizada()) {
            this.partidasEnCurso.remove(p);
            Fachada.getInstancia().notificar(Observador.Evento.PARTIDA_FINALIZADA);
        }

    }

    private void notificarSiInicioMano(Partida p) {

        if (p.iniciarNuevaMano()) {

            Fachada.getInstancia().notificar(Observador.Evento.MANO_COMENZADA);
        }
    }

    public void unirJugadorASiguienteMano(Partida p, JugadorPartida j) throws JugadorException, ManoException {
        p.unirASiguienteMano(j);
        notificarSiInicioMano(p);

//          if(!(p.getManoActual().getEstado() instanceof EstadoManoSinIniciar)){
//            //notify finMano
//        }
    }

}
