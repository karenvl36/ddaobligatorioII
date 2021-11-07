/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.ManoException;
import java.util.List;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class Mano extends Observable {

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
    public ApuestaMano getApuesta(){
        return this.apuesta;
    }

    public List<JugadorPartida> getJugadoresActivos() {
        return jugadoresActivos;
    }

    public void setJugadoresActivos(List<JugadorPartida> jugadoresActivos) {
        this.jugadoresActivos = jugadoresActivos;
    }
    
    public List<JugadorPartida> getPasantes() {
        return pasantes;
    }

    public void setPasantes(List<JugadorPartida> pasantes) {
        this.pasantes = pasantes;
    }

    public JugadorPartida getGanador() {
        return ganador;
    }

    public void setGanador(JugadorPartida ganador) {
        this.ganador = ganador;
    }

    public EstadoMano getEstado() {
        return estado;
    }

    public void setEstado(EstadoMano estado) {
        this.estado = estado;
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
        
        this.pasantes.remove(j);
        this.jugadoresActivos.remove(j);
       
    }

    public void sumarPozo(int apuesta) {

        this.setPozo(pozo + apuesta);

    }


    public void recibirApuesta(JugadorPartida unApostante, int monto) throws ManoException {
        try{
        
            estado.recibirApuesta(unApostante, monto, this);
            estado = new EstadoManoApostada();
            pedirApuestas();
       
        }catch(ManoException m){
        
                throw m;
              
        }
        
        
        
    }
    
    public void recibirPasar(JugadorPartida pasante) throws ManoException{
    
        estado.recibirPasar(pasante, this);
        comprobarFinalizacion();
    }

    private void pedirApuestas() {
        for (JugadorPartida jp : jugadoresActivos) {
            if (!jp.equals(this.apuesta.getJugador())) {
               jp.notificar(Observador.Evento.APUESTA_PEDIDA);//TODO: Notificar a los otros jugadores para que elijan match o no
   
            }
        }
    }
    
    private void recibirMatchApuesta(JugadorPartida j) throws ManoException{
        if(j.realizarApuesta(apuesta.getValor())){ //pasamos el valor de la apuesta en juego
            sumarPozo(apuesta.getValor());
            comprobarFinalizacion();
        }
        throw new ManoException("No tiene saldo suficiente para realizar esta apuesta.");
        
    }

    //TODO: tip para hacerlo private y poder acceder desde Estado
    public void agregarPasante(JugadorPartida j) {

        pasantes.add(j);
    }



    public void finalizarMano() {
        estado.finalizarMano(this);
        

       // if(pasantes.size() == jugadoresActivos.size()) //no hay ganador y se pasa el pozo a la próxima mano. 
       //   if(jugadoresActivos.size() == 1 )   es el ganador
       //if(jugadoresACtivos.size() > 1 buscar ganador
    }

   
    public void vaciarListaPasantes() {
        pasantes.clear();
    }

    public void comprobarFinalizacion() {
       if( pasantes.size() == jugadoresActivos.size() || jugadoresActivos.size() <= 1){
       
           finalizarMano();
       }
    }

    public void declararGanador(JugadorPartida jugador) {
        setGanador(jugador);
        jugador.recibirGanancia(pozo);
        this.setPozo(0);
    }
}



