/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.ManoException;
import excepciones.PartidaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class Partida extends Observable implements Observador {

    private Date fechaInicio;
    private List<Mano> manos;
    private List<JugadorPartida> jugadores = new ArrayList();
    private Settings settings;
    private Mano manoActual;
    private EstadoPartida estado;

    public Partida() {
        settings = Settings.getInstancia();
        estado = new EstadoPartidaSinIniciar();
        manos = new ArrayList<Mano>();
    }

    
    // <editor-fold defaultstate="collapsed" desc=" Getter-Setter ">
    public Date getFecha() {
        return this.fechaInicio;
    }

    public void setFecha() {
        this.fechaInicio = new Date();
    }

    public int getApuestaBase() {
        return settings.getInstancia().getApuestaBase();
    }

    public int getCantMaximaJugadores() {
        return settings.getInstancia().getCantMaximaJugadores();

    }

    private void setFecha(Date date) {
        this.fechaInicio = date;
    }

    // </editor-fold>
           

    // <editor-fold defaultstate="collapsed" desc="Iniciación de Partida">
    public Partida agregar(JugadorPartida jp) throws JugadorException, PartidaException {
        estado.agregar(jp, this);
        return comprobarInicio();
    }

    public Partida comprobarInicio() throws JugadorException, PartidaException {
        if (faltanJugadores() == 0) {   
           iniciar();
           this.estado = new EstadoPartidaIniciada();        
          return this;
        }

        return null;
    }

    public void guardarEnLista(JugadorPartida player) {
        this.jugadores.add(player);
    }

    public void iniciar() throws JugadorException { //Tira la excepción si un jugador a unirse a la nueva mano no tiene saldo
        this.setFecha(new Date());
        guardarSaldoInicialJugadores();
        this.notificar(Observador.Evento.PARTIDA_INICIADA);
        nuevaMano();
    }

    private void guardarSaldoInicialJugadores() {
        for (JugadorPartida j : jugadores) {

            j.guardarSaldoInicial();
        }

    }

    private void agregar(Mano m){
        manos.add(m);
    }

    private void nuevaMano() throws JugadorException {

        Mano mano = new Mano();
        manoActual = mano;
        agregar(mano);
        asignarJugadoresAMano();

      //  manoActual.subscribir(this);
        if (manoActual.iniciar()) {
            //this.notificar(Observador.Evento.MANO_COMENZADA);
             this.notificar(Observador.Evento.PARTIDA_INICIADA);
        } else {

            finalizarMano();
        }

        //TODO: else finalizarPartida???

    }

    private void asignarJugadoresAMano() throws JugadorException {

        for (JugadorPartida j : jugadores) {
            try {
                
                manoActual.agregar(j, getApuestaBase()); //Esta función ya comprueba si el saldo es suficiente para laluz

            } catch (JugadorException jp) {
                retirarJugador(j);
                throw jp;
            }

        }

    }



// </editor-fold>



   

    // <editor-fold defaultstate="collapsed" desc="Validaciones">
    public int faltanJugadores() {

        return getCantMaximaJugadores() - cantidadJugadores();
    }

    private int cantidadJugadores() {
        if (jugadores != null) {
            return jugadores.size();
        }
        return 0;
    }

    public void jugadorYaEnPartida(JugadorPartida player) throws JugadorException {

        for (JugadorPartida j : jugadores) {
            if (j.getJugador().equals(player.getJugador())) {
                throw new JugadorException("Ya se encuenta en espera en esta Partida.");
            }
        }

    }

    public void saldoSuficiente(JugadorPartida player) throws JugadorException {
        player.saldoSuficiente(this.settings.getApuestaBase());
    }

    private boolean verificarCantJugadores() {
        return (getCantMaximaJugadores() - jugadores.size()) >= 1;

    }
    
    public boolean jugadoresInsuficientes() {
        return jugadores.size() >= 1;

    }
// </editor-fold>



    // <editor-fold defaultstate="collapsed" desc="Delega a Mano">
    
     public void recibirApuesta(JugadorPartida unApostante, int monto) throws JugadorException {
         manoActual.recibirApuesta(unApostante, monto);
         //TODO: Notifica partida?
         
    }

    public void recibirPasar(JugadorPartida pasante) throws ManoException, JugadorException {
          manoActual.recibirPasar(pasante);
          if(manoActual.manoFinalizada()){
             finalizarMano();
          }

    }

    public void finalizarMano() throws JugadorException{
         JugadorPartida ganador = manoActual.finalizarMano();
         siguienteMano(ganador);
        
    }

    

    // </editor-fold>











   
    public void retirarJugador(JugadorPartida j) {
        if (jugadores.remove(j)) {
            if (manoActual != null) {
                manoActual.eliminar(j);
            }
            this.notificar(Observador.Evento.JUGADOR_ELIMINADO);

        }else{
        
           System.out.println("Nop");
        }

    }

 



    public void siguienteMano(JugadorPartida ganadorAnterior) throws JugadorException {
        int pozoAnterior = 0;
        if (!jugadoresInsuficientes()) {
            if(ganadorAnterior == null){
                pozoAnterior = manoActual.getPozo(); 
            }
            nuevaMano();
            manoActual.sumarPozo(pozoAnterior);

        } else {

            //Finalizar partida??
        }

    }

  
    //TODO: Preguntar si la sigueinte mano tiene que iniciar automáticamente sin dar tiempo a salir del juuego antes de descontarle la luz
    @Override
    public void notificar(Observable source, Object event) {
        if (event == Observador.Evento.MANO_FINALIZADA) {
            manoActual.desubscribir(this);
        }

    }

}



//    public JugadorPartida agregar(UsuarioJugador usuarioJ) throws PartidaException{
//       // estado.agregar(usuarioJ, this); TODO: Fix el problema de la privacidad de los métodos que usa Estado
//         JugadorPartida jp = new JugadorPartida(usuarioJ);
//        if (faltanJugadores() != 0 && !jugadorYaEnPartida(jp) && saldoSuficiente(jp)) {
//            this.jugadores.add(jp);
//            this.notificar(Observador.Evento.JUGADOR_AGREGADO);
//            return jp;
//        }
//        return null;
//    }
    //Agregar con Exceptions    


//    private boolean asignarJugadoresAMano_Prueba() {
//        boolean noHayJugadores = false;
//        int i = 0;
//        while (i < jugadores.size() && !noHayJugadores) {
//            try {
//                saldoSuficiente(jugadores.get(i));
//                manoActual.agregar(jugadores.get(i), getApuestaBase());
//                i++;
//
//            } catch (JugadorException ex) {
//                retirarJugador(jugadores.get(i));
//                noHayJugadores = jugadoresInsuficientes();
//                throw ex;
//
//            } finally {
//                return noHayJugadores;
//
//            }
//
//            //TODO: throw la exception de saldo Insuficiente
//        }
//        return noHayJugadores;
//    }