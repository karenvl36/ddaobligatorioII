/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class Partida extends Observable {

    private Date fechaInicio;
    private List<Mano> manos;
    private List<JugadorPartida> jugadores = new ArrayList();
    private Settings settings;
    private Mano manoActual;
    private EstadoPartida estado;

    public Partida() {
        settings = Settings.getInstancia();
        estado = new EstadoPartidaSinIniciar();
    }

    public Date getFecha() {
        return this.fechaInicio;
    }

    public void setFecha() {
        this.fechaInicio = new Date();
    }

    public JugadorPartida agregar(UsuarioJugador usuarioJ) {
       // estado.agregar(usuarioJ, this); TODO: Fix el problema de la privacidad de los métodos que usa Estado
         JugadorPartida jp = new JugadorPartida(usuarioJ);
        if (faltanJugadores() != 0 && !jugadorYaEnPartida(jp) && saldoSuficiente(jp)) {
            this.jugadores.add(jp);
            this.notificar(Observador.Evento.JUGADOR_AGREGADO);
            return jp;
            //TODO: throw la exception que venga de jugadorYaEnPartida?
            //TODO: throw exception de saldo insuficiente
        }
        return null;
    }

    private boolean jugadorYaEnPartida(JugadorPartida player) {

          for(JugadorPartida j: jugadores){
              if(j.getJugador().equals(player.getJugador())) return true;
          }  
          
          return false;
    }

    private boolean saldoSuficiente(JugadorPartida player) {
         return player.saldoSuficiente(this.settings.getApuestaBase());
//        return player.saldoSuficiente(300); //cambie esto para probar porque settings tira null exception
        //TODO: throw exception
    }

    public int cantJugadoresActualmente() {
        return this.jugadores.size();
    }

    public Partida comprobarInicio() {
        if (faltanJugadores() == 0) {
            iniciar();
            
            return this;
        }

        return null;
    }

    public int faltanJugadores() {

        return getCantMaximaJugadores() - cantidadJugadores();
    }

    private boolean verificarCantJugadores() {
        return (getCantMaximaJugadores() - jugadores.size()) >= 1;

    }

    private int cantidadJugadores() {
        if (jugadores != null) {
            return jugadores.size();
        }
        return 0;
    }

    public int getApuestaBase() {
        return settings.getInstancia().getApuestaBase();
    }

    public int getCantMaximaJugadores() {
        return settings.getInstancia().getCantMaximaJugadores();

    }

    public void iniciar() {
        estado = new EstadoPartidaIniciada();
        this.setFecha(new Date());
        guardarSaldoInicialJugadores();
        nuevaMano();
//        TODO: if(cantidadJugadores() == 1){
//            finalizar();
//        }

    }

    private void setFecha(Date date) {
        this.fechaInicio = date;
    }

    private void guardarSaldoInicialJugadores() {
        for (JugadorPartida j : jugadores) {

            j.guardarSaldoInicial();
        }

    }

    private void agregar(Mano m) {
        manos.add(m);
    }

    private void nuevaMano() {

        Mano mano = new Mano();
        manoActual = mano;
        agregar(mano);
        asignarJugadoresAMano();

    }

    private void asignarJugadoresAMano() {
        for (JugadorPartida j : jugadores) {

            if (saldoSuficiente(j)) {
                manoActual.agregar(j, getApuestaBase());

            } else {
                retirarJugador(j);
                //TODO: throw la exception de saldo Insuficiente
            }
        }

    }

    public void retirarJugador(JugadorPartida j) {
        jugadores.remove(j);
        this.notificar(Observador.Evento.JUGADOR_AGREGADO);

    }

    public void jugarPoker() {

        while (cantidadJugadores() > 1) {
            iniciar();
        }

    }

}
