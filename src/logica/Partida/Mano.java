/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Partida;

import excepciones.JugadorException;
import excepciones.ManoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import logica.Mazo;
import logica.Settings;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class Mano extends Observable {

    private List<JugadorPartida> jugadoresActivos;
    private List<JugadorPartida> jugaronTurno = new ArrayList<JugadorPartida>();
    private Mazo mazo;
    private int pozo;
    private ApuestaMano apuesta;   
    private JugadorPartida ganador;
    private EstadoMano estado;
     private Settings settings;
     

    
    public Mano() {
        settings = Settings.getInstancia();
        estado = new ManoSinIniciar();
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
        return jugaronTurno;
    }

    public void setPasantes(List<JugadorPartida> pasantes) {
        this.jugaronTurno = pasantes;
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

    public List<JugadorPartida> getJugaronTurno() {
        return jugaronTurno;
    }
    
    public int getApuestaBase() {
        return settings.getInstancia().getApuestaBase();
    }
 

   
    
    

    // <editor-fold defaultstate="collapsed" desc="IniciarMano">
    public void agregar(JugadorPartida j, int luz) throws JugadorException, ManoException {
       jugadorYaEnMano(j); 
       j.realizarApuesta(luz); //Si falla retorna una exception
       this.jugadoresActivos.add(j) ;
       this.notificar(Observador.Evento.JUGADOR_AGREGADO);
        sumarPozo(luz);
       // iniciar();

    }
    
     public void jugadorYaEnMano(JugadorPartida player) throws JugadorException, ManoException {

        for (JugadorPartida j : jugadoresActivos) {
            if (j.getJugador().equals(player.getJugador())) {
                throw new ManoException("La nueva mano comenzará cuando todos los jugadores acepten.");
            }
        }

    }

    public boolean iniciar() {
        
        return estado.iniciar(this);
    }

   

    protected void eliminar(JugadorPartida j) {
        estado.retirarJugador(j, this);
        this.notificar(Observador.Evento.JUGADOR_ELIMINADO);
    }

    protected void sumarPozo(int apuesta) {

        this.setPozo(pozo + apuesta);

    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="JugarMano">
    public void recibirApuesta(JugadorPartida unApostante, int monto) throws JugadorException {

        estado.recibirApuesta(unApostante, monto, this);
        estado = new ManoApostada();
        notificar(Observador.Evento.APUESTA_RECIBIDA);
        notificar(Observador.Evento.TURNO_JUGADO);
        pedirApuestas();

    }

    public void recibirPasar(JugadorPartida pasante) throws ManoException, JugadorException {

        estado.recibirPasar(pasante, this);
        notificar(Observador.Evento.TURNO_JUGADO);
        
    }
    
    public void recibirMatchApuesta(JugadorPartida jugador) throws JugadorException{
        
        estado.recibirMatchApuesta(jugador, this);
        notificar(Observador.Evento.APUESTA_RECIBIDA);
        notificar(Observador.Evento.TURNO_JUGADO);
    }
    
    public int faltanPasar(){
        return this.getJugadoresActivos().size() - this.getPasantes().size();
    }

    private void pedirApuestas() {
        for (JugadorPartida jp : jugadoresActivos) {
            if (!jp.equals(this.apuesta.getJugador())) {
                jp.notificar(Observador.Evento.APUESTA_PEDIDA);

            }
        }
    }


    protected void agregarTurnoJugado(JugadorPartida j) {

        jugaronTurno.add(j);
       
    }
    
    public void vaciarListaPasantes() {
        jugaronTurno.clear();
    }

    // </editor-fold>

   
 
    // <editor-fold defaultstate="collapsed" desc="FinalizarMano">
    

    
     protected JugadorPartida revisarGanador(){ 
          JugadorPartida ganadorMano = jugadoresActivos.get(0); 
          for(int i=1; i<jugadoresActivos.size(); i++){ 
              JugadorPartida jp = jugadoresActivos.get(i); 
              if(jp.getManoJugador().figura.compareTo(ganadorMano.getManoJugador().figura) < 0){ 
                  ganadorMano = jp; 
              }    
          } 
          declararGanador(ganadorMano);
          return ganadorMano; 
      } 
   
    
     public boolean manoFinalizada() {
        if (jugaronTurno.size() == jugadoresActivos.size() || jugadoresInsuficientes()) {
          
            return estado.finalizarMano(this);
           

        }
        
        return false;
    }

    protected void declararGanador(JugadorPartida jugador) {
        setGanador(jugador);
        jugador.recibirGanancia(pozo);
        this.setPozo(0);
    }
    
    protected boolean jugadoresInsuficientes(){
    
        return jugadoresActivos.size() <= 1;
    }
    // </editor-fold>

   

   // <editor-fold defaultstate="collapsed" desc="Testing"> 
//   private void cartasParaTestear() { 
// 
//        ArrayList<Carta> cartas = new ArrayList<Carta>(); 
//        //For testing 
//        cartas.add(new Carta(8, new Palo(4), 8 + "_" + 4 + ".gif", "8")); 
//        cartas.add(new Carta(10, new Palo(4), 10 + "_" + 4 + ".gif", "10")); 
//        cartas.add(new Carta(13, new Palo(4), 13 + "_" + 4 + ".gif", "13")); 
//        cartas.add(new Carta(2, new Palo(4), 2 + "_" + 4 + ".gif", "2")); 
//        cartas.add(new Carta(4, new Palo(4), 4 + "_" + 4 + ".gif", "4")); 
//        ManoJugador mj = new ManoJugador(cartas); 
// 
//        jugadoresActivos.get(1).setManoJugador(mj); 
//         
//         ArrayList<Carta> cartas2 = new ArrayList<Carta>(); 
//    
//        cartas2.add(new Carta(8, new Palo(2), 8 + "_" + 2 + ".gif", "8")); 
//        cartas2.add(new Carta(10, new Palo(2), 10 + "_" + 2 + ".gif", "10")); 
//        cartas2.add(new Carta(13, new Palo(2), 13 + "_" + 2 + ".gif", "13")); 
//        cartas2.add(new Carta(2, new Palo(2), 2 + "_" + 2 + ".gif", "2")); 
//        cartas2.add(new Carta(4, new Palo(2), 4 + "_" + 2 + ".gif", "4")); 
//        ManoJugador mj2 = new ManoJugador(cartas2);  
//        jugadoresActivos.get(1).setManoJugador(mj2); 
//
// 
//    } 
//   
//   private void cartasParaTestear(){
//       
//         ArrayList<Carta> cartas = new ArrayList<Carta>(); 
//        //For testing 
//        cartas.add(new Carta(8, new Palo(4), 8 + "_" + 4 + ".gif", "8")); 
//        cartas.add(new Carta(8, new Palo(3), 8 + "_" + 3 + ".gif", "8")); 
//        cartas.add(new Carta(8, new Palo(1), 8 + "_" + 1 + ".gif", "8")); 
//        cartas.add(new Carta(9, new Palo(1), 9 + "_" + 1 + ".gif", "9")); 
//        cartas.add(new Carta(9, new Palo(2), 9 + "_" + 2 + ".gif", "9")); 
//        ManoJugador mj = new ManoJugador(cartas); 
// 
//        jugadoresActivos.get(0).setManoJugador(mj); 
//         
//         ArrayList<Carta> cartas2 = new ArrayList<Carta>(); 
//    
//        cartas2.add(new Carta(8, new Palo(4), 8 + "_" + 4 + ".gif", "8")); 
//        cartas2.add(new Carta(8, new Palo(3), 8 + "_" + 3 + ".gif", "8")); 
//        cartas2.add(new Carta(8, new Palo(1), 8 + "_" + 1 + ".gif", "8")); 
//        cartas2.add(new Carta(9, new Palo(1), 9 + "_" + 1 + ".gif", "9")); 
//        cartas2.add(new Carta(9, new Palo(2), 9 + "_" + 2 + ".gif", "9")); 
//        ManoJugador mj2 = new ManoJugador(cartas2); 
// 
//        jugadoresActivos.get(1).setManoJugador(mj2); 
//   
//   }
   
   
//      public void cartasParaTestear(){
//       
//         ArrayList<Carta> cartas = new ArrayList<Carta>(); 
//        //For testing 
//        cartas.add(new Carta(14, new Palo(3), 14 + "_" + 4 + ".gif", "14")); 
//        cartas.add(new Carta(5, new Palo(3), 5 + "_" + 3 + ".gif", "5")); 
//        cartas.add(new Carta(2, new Palo(1), 2 + "_" + 1 + ".gif", "2")); 
//        cartas.add(new Carta(4, new Palo(1), 4 + "_" + 1 + ".gif", "4")); 
//        cartas.add(new Carta(3, new Palo(2), 3 + "_" + 2 + ".gif", "3")); 
//        ManoJugador mj = new ManoJugador(cartas); 
// 
//        jugadoresActivos.get(0).setManoJugador(mj); 
//         
//         ArrayList<Carta> cartas2 = new ArrayList<Carta>(); 
//    
//        cartas2.add(new Carta(13, new Palo(4), 13 + "_" + 3 + ".gif", "14")); 
//        cartas2.add(new Carta(5, new Palo(4), 5 + "_" + 4 + ".gif", "5")); 
//        cartas2.add(new Carta(2, new Palo(2), 2 + "_" + 2 + ".gif", "2")); 
//        cartas2.add(new Carta(4, new Palo(2), 4 + "_" + 2 + ".gif", "4")); 
//        cartas2.add(new Carta(3, new Palo(1), 3 + "_" + 1 + ".gif", "3")); 
//        ManoJugador mj2 = new ManoJugador(cartas2); 
// 
//        jugadoresActivos.get(1).setManoJugador(mj2); 
//   
//   }
 // </editor-fold> 


      




}



