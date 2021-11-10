/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.ManoException;
import java.util.ArrayList;
import java.util.List;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class Mano extends Observable {

    private List<JugadorPartida> jugadoresActivos;
    private List<JugadorPartida> pasantes = new ArrayList<JugadorPartida>();
    private Mazo mazo;
    private int pozo;
    private ApuestaMano apuesta;   
    private JugadorPartida ganador;
    private EstadoMano estado;

//    public Mano(List<JugadorPartida> players, Mazo mazo, int pozo) {
//        estado = new EstadoManoSinApuestas();
//        this.jugadoresActivos = players;
//        this.mazo = mazo;
//        this.pozo = pozo;
//    }
    
    public Mano() {
        estado = new EstadoManoSinApuestas();
        this.jugadoresActivos = new ArrayList<JugadorPartida>();
        this.mazo = new Mazo();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Getter-Setters">
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

    public ApuestaMano getApuesta() {
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
    // </editor-fold>

 

   
    
    

    // <editor-fold defaultstate="collapsed" desc="IniciarMano">
    public void agregar(JugadorPartida j, int luz) throws JugadorException {
        j.realizarApuesta(luz); //Si falla retorna una exception
        this.jugadoresActivos.add(j);
        sumarPozo(luz);

    }

    public boolean iniciar() {
        if (!jugadoresInsuficientes()) {
            mazo.barajar();
            for (JugadorPartida j : jugadoresActivos) {
              //  ArrayList<Carta> cartas = new ArrayList<Carta>();
                //For testing
//                cartas.add(new Carta(14, new Palo(1), 14 + "_"+1+".gif")); 
//                cartas.add(new Carta(14, new Palo(2), 14 + "_"+2+".gif")); 
//                cartas.add(new Carta(13, new Palo(3), 13 + "_"+3+".gif")); 
//                cartas.add(new Carta(2, new Palo(1), 2 + "_"+1+".gif"));
//                cartas.add(new Carta(4, new Palo(1), 4 + "_"+1+".gif"));
//                 ManoJugador mj = new ManoJugador(cartas);
                ManoJugador mj = new ManoJugador(mazo.repartir());

                j.setManoJugador(mj);
            }
            return true;
        }
        return false;
    }

   

    public void eliminar(JugadorPartida j) {

        this.pasantes.remove(j);
        this.jugadoresActivos.remove(j);

    }

    public void sumarPozo(int apuesta) {

        this.setPozo(pozo + apuesta);

    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="JugarMano">
    public void recibirApuesta(JugadorPartida unApostante, int monto) throws JugadorException {

        estado.recibirApuesta(unApostante, monto, this);
        estado = new EstadoManoApostada();
        pedirApuestas();

    }

    public void recibirPasar(JugadorPartida pasante) throws ManoException {

        estado.recibirPasar(pasante, this);
        comprobarFinalizacion(); 
    }

    private void pedirApuestas() {
        for (JugadorPartida jp : jugadoresActivos) {
            if (!jp.equals(this.apuesta.getJugador())) {
                jp.notificar(Observador.Evento.APUESTA_PEDIDA);

            }
        }
    }

    //TODO: tip para hacerlo private y poder acceder desde Estado
    public void agregarPasante(JugadorPartida j) {

        pasantes.add(j);
    }
    
    public void vaciarListaPasantes() {
        pasantes.clear();
    }

    // </editor-fold>

   
 
    // <editor-fold defaultstate="collapsed" desc="FinalizarMano">
    public JugadorPartida finalizarMano() {
        return estado.finalizarMano(this);

        // if(pasantes.size() == jugadoresActivos.size()) //no hay ganador y se pasa el pozo a la próxima mano. 
        //   if(jugadoresActivos.size() == 1 )   es el ganador
        //if(jugadoresACtivos.size() > 1 buscar ganador
    }

    
    //TODO: Definir quién es responsable de esta parte: Mano o Partida?
    public void comprobarFinalizacion() {
        if (pasantes.size() == jugadoresActivos.size() || jugadoresInsuficientes()) {

            finalizarMano();
        }
    }
    
     public boolean manoFinalizada() {
        if (pasantes.size() == jugadoresActivos.size() || jugadoresInsuficientes()) {

            return true;
        }
        
        return false;
    }

    public void declararGanador(JugadorPartida jugador) {
        setGanador(jugador);
        jugador.recibirGanancia(pozo);
        this.setPozo(0);
    }
    
    public boolean jugadoresInsuficientes(){
    
        return jugadoresActivos.size() <= 1;
    }
    // </editor-fold>



   


      
//    private void recibirMatchApuesta(JugadorPartida j) throws JugadorException{
//        j.realizarApuesta(apuesta.getValor()); //pasamos el valor de la apuesta en juego
//            sumarPozo(apuesta.getValor());
//            comprobarFinalizacion();
//    
//        
//    }



}



