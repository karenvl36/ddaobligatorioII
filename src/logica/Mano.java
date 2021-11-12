/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.ManoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

 

   
    
    

    // <editor-fold defaultstate="collapsed" desc="IniciarMano">
    public void agregar(JugadorPartida j, int luz) throws JugadorException {
       j.realizarApuesta(luz); //Si falla retorna una exception
       this.jugadoresActivos.add(j) ;
        sumarPozo(luz);
        
       
       

    }

    public boolean iniciar() {
        if (!jugadoresInsuficientes()) {
            mazo.barajar();
            for (JugadorPartida j : jugadoresActivos) {
                ManoJugador mj = new ManoJugador(mazo.repartir());

                j.setManoJugador(mj);
            }
          // cartasParaTestear();
      //      this.notificar(Observador.Evento.MANO_COMENZADA);
            return true;
        }
        return false;
    }

   

    public void eliminar(JugadorPartida j) {

        this.jugaronTurno.remove(j);
        this.jugadoresActivos.remove(j);
        this.notificar(Observador.Evento.JUGADOR_ELIMINADO);

    }

    public void sumarPozo(int apuesta) {

        this.setPozo(pozo + apuesta);

    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="JugarMano">
    public void recibirApuesta(JugadorPartida unApostante, int monto) throws JugadorException {

        estado.recibirApuesta(unApostante, monto, this);
        estado = new EstadoManoApostada();
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

    //TODO: tip para hacerlo private y poder acceder desde Estado
    public void agregarTurnoJugado(JugadorPartida j) {

        jugaronTurno.add(j);
       
    }
    
    public void vaciarListaPasantes() {
        jugaronTurno.clear();
    }

    // </editor-fold>

   
 
    // <editor-fold defaultstate="collapsed" desc="FinalizarMano">
    
//    public JugadorPartida revisarGanador(){
//        JugadorPartida ganador = null;
//        ArrayList<ManoJugador> cartasJugadores = new ArrayList();
//        
//        for(JugadorPartida jp: jugadoresActivos){
//            //if(jp.getManoJugador().figura.compareTo(o))
//            cartasJugadores.add(jp.getManoJugador());
//        }
//        ArrayList<ManoJugador> temp = new ArrayList<>(cartasJugadores);
//        Collections.sort(temp);
//        System.out.println(temp.get(0).getFigura().getDescripcionCartas());
//        //TODO: Esto está mal. Tenemso que evaluar por JugadorPartida para saber quién es el dueño del set ganador
//        return ganador;
//    }
    
     public JugadorPartida revisarGanador(){ 
          JugadorPartida ganador = jugadoresActivos.get(0); 
          for(int i=1; i<jugadoresActivos.size(); i++){ 
              JugadorPartida jp = jugadoresActivos.get(i); 
              if(jp.getManoJugador().figura.compareTo(ganador.getManoJugador().figura) < 0){ 
                  ganador = jp; 
              }    
          } 
           
          System.out.println(ganador.getManoJugador().getFigura().getDescripcionCartas()); 
    
          return ganador; 
      } 
    
    
    public JugadorPartida finalizarMano() {
        return estado.finalizarMano(this);

        // if(pasantes.size() == jugadoresActivos.size()) //no hay ganador y se pasa el pozo a la próxima mano. 
        //   if(jugadoresActivos.size() == 1 )   es el ganador
        //if(jugadoresACtivos.size() > 1 buscar ganador
    }

    

    
     public boolean manoFinalizada() {
        if (jugaronTurno.size() == jugadoresActivos.size() || jugadoresInsuficientes()) {
            finalizarMano();
            notificar(Observador.Evento.MANO_FINALIZADA);
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
   private void cartasParaTestear(){
       
         ArrayList<Carta> cartas = new ArrayList<Carta>(); 
        //For testing 
        cartas.add(new Carta(8, new Palo(4), 8 + "_" + 4 + ".gif", "8")); 
        cartas.add(new Carta(8, new Palo(3), 8 + "_" + 3 + ".gif", "8")); 
        cartas.add(new Carta(8, new Palo(1), 8 + "_" + 1 + ".gif", "8")); 
        cartas.add(new Carta(9, new Palo(1), 9 + "_" + 1 + ".gif", "9")); 
        cartas.add(new Carta(9, new Palo(2), 9 + "_" + 2 + ".gif", "9")); 
        ManoJugador mj = new ManoJugador(cartas); 
 
        jugadoresActivos.get(0).setManoJugador(mj); 
         
         ArrayList<Carta> cartas2 = new ArrayList<Carta>(); 
    
        cartas2.add(new Carta(8, new Palo(4), 8 + "_" + 4 + ".gif", "8")); 
        cartas2.add(new Carta(8, new Palo(3), 8 + "_" + 3 + ".gif", "8")); 
        cartas2.add(new Carta(8, new Palo(1), 8 + "_" + 1 + ".gif", "8")); 
        cartas2.add(new Carta(9, new Palo(1), 9 + "_" + 1 + ".gif", "9")); 
        cartas2.add(new Carta(9, new Palo(2), 9 + "_" + 2 + ".gif", "9")); 
        ManoJugador mj2 = new ManoJugador(cartas2); 
 
        jugadoresActivos.get(1).setManoJugador(mj2); 
   
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



