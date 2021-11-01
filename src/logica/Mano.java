/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.ManoException;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class Mano {

    private List<JugadorPartida> jugadoresActivos;
    private List<JugadorPartida> pasantes;
    private Mazo mazo;
    private int pozo;
    private ApuestaMano apuesta;    //PREGUNTAR SI VALE LA PENA Y COMO HACER EL ESTADOMANO, DND VAN LAS LISTAS?
    private JugadorPartida ganador;
    private EstadoMano estado;

    public Mano(List<JugadorPartida> players, Mazo mazo, int pozo) {
        this.jugadoresActivos = players;
        this.mazo = mazo;
        this.pozo = pozo;
    }

    public Mano() {
        estado = new EstadoManoEnJuego();
        this.mazo = new Mazo();
    }

//      public void paso(JugadorPartida jp){
//          pasantes.add(jp);
//      }
//      public void aposto(JugadorPartida jp,int montoApostado){
//          ApuestaMano apuestaMano = new ApuestaMano(jp,montoApostado);
//          this.apuesta = apuestaMano;
//          pasantes.clear();
//          pedirApuestas();
//      }
    public void apostar(JugadorPartida unApostante, int monto) throws ManoException{
        estado.apostar(unApostante, monto);
        estado = new EstadoManoApostada();
        pedirApuestas();
    }

    private void pedirApuestas() {
        for (JugadorPartida jp : jugadoresActivos) {
            if (!jp.equals(this.apuesta.getJugador())) {
       //TODO: Meter notificar
            }
        }
    }

    public List<JugadorPartida> getJugadoresActivos() {
        return jugadoresActivos;
    }

    public void setJugadoresActivos(List<JugadorPartida> jugadoresActivos) {
        this.jugadoresActivos = jugadoresActivos;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public void agregar(JugadorPartida j, int apuesta) {
        if (j.saldoSuficiente(apuesta)) {

            this.jugadoresActivos.add(j);
            j.restarSaldo(apuesta);
            sumarPozo(apuesta);
            iniciarMano();
        }
    }

    public void sumarPozo(int apuesta) {

        this.setPozo(pozo + apuesta);

    }

    public void iniciarMano() {

        mazo.barajar();
        for (JugadorPartida j : jugadoresActivos) {
            ManoJugador mj = new ManoJugador();
            mj.setCartas(mazo.repartir());
            j.setManoJugador(mj);
        }

    }

//    public void recibirApuesta(int apuesta, JugadorPartida j){
//        setApuesta(apuesta);
//        //TODO: notificar con Observable la apuesta a matchear a los otros jugadores. 
//
//    
//    }
    public void setApuesta(ApuestaMano apuesta) {
        this.apuesta = apuesta;
    }

    public void finalizarMano() {

        //TODO: Si todos pasan, termina la mano. El pozo pasa a la próxima mano
    }

    //TODO: Si la mano se jugó, evaluar las manos de cada jugador aun en juego para determinar ganador
    //TODO: Acreditar pozo a saldo ganador
}

//    public int getApuesta() {
//        return apuesta.d;
//    }
//

