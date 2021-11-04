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
    private ApuestaMano apuesta;   
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

    public void setApuesta(ApuestaMano apuesta) {
        this.apuesta = apuesta;
    }

    public List<JugadorPartida> getJugadoresActivos() {
        return jugadoresActivos;
    }

    public void setJugadoresActivos(List<JugadorPartida> jugadoresActivos) {
        this.jugadoresActivos = jugadoresActivos;
    }

    public void agregar(JugadorPartida j, int luz) {
        if (j.realizarApuesta(luz)) {

            this.jugadoresActivos.add(j);  
            sumarPozo(luz);
            iniciarMano();
            //TODO: Throw Exception que le llega del método anterior
        }
    }

    public void iniciarMano() {

        mazo.barajar();
        for (JugadorPartida j : jugadoresActivos) {
            ManoJugador mj = new ManoJugador();
            mj.setCartas(mazo.repartir());
            j.setManoJugador(mj);
        }

    }

    public void eliminar(JugadorPartida j) {

        this.jugadoresActivos.remove(j);

    }

    public void sumarPozo(int apuesta) {

        this.setPozo(pozo + apuesta);

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
    public void recibirApuesta(JugadorPartida unApostante, int monto) throws ManoException {
        estado.recibirApuesta(unApostante, monto, this);
        estado = new EstadoManoApostada();
        pedirApuestas();
    }

    private void pedirApuestas() {
        for (JugadorPartida jp : jugadoresActivos) {
            if (!jp.equals(this.apuesta.getJugador())) {
                //TODO: Notificar a los otros jugadores para que elijan match o no
            }
        }
    }
    
    private void recibirMatchApuesta(JugadorPartida j){
        //chequea el saldo suficiente
        //resta el saldo al jugador
        //suma al pozo
        
    
    }

    //TODO: tip para hacerlo private y poder acceder desde Estado
    public void agregarPasante(JugadorPartida j) {

        pasantes.add(j);
    }

//    public void recibirApuesta(int apuesta, JugadorPartida j){
//        setApuesta(apuesta);
//        //TODO: notificar con Observable la apuesta a matchear a los otros jugadores. 
//
//    
//    }
//    public void vaciarListaPasantes(){
//    
//        this.pasantes.clear();
//    }
    public void finalizarMano() {

        //TODO: Si todos pasan, termina la mano. El pozo pasa a la próxima mano
    }

    //TODO: Si la mano se jugó, evaluar las manos de cada jugador aun en juego para determinar ganador
    //TODO: Acreditar pozo a saldo ganador
    void vaciarListaPasantes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//    public int getApuesta() {
//        return apuesta.d;
//    }
//

