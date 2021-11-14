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
public class Partida extends Observable {

    private Date fechaInicio;
    private List<Mano> manos;
    private List<JugadorPartida> jugadores = new ArrayList();
    private Settings settings;
    private Mano manoActual;
    private EstadoPartida estado;
    // private Mano ultimaManoJugada;

    public Partida() {
        settings = Settings.getInstancia();
        estado = new EstadoPartidaSinIniciar();
        manos = new ArrayList<Mano>();
        manoActual = new Mano();

    }

    @Override
    public String toString() {
        return "Partida{" + "fechaInicio=" + fechaInicio + '}';
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

    public EstadoPartida getEstado() {
        return estado;
    }

    public void setEstado(EstadoPartida estado) {
        this.estado = estado;
    }

    public Mano getManoActual() {
        return manoActual;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Iniciación de Partida">
    public Partida agregar(JugadorPartida jp) throws JugadorException, PartidaException {
        if (estado.agregar(jp, this) != null) {

            return comprobarInicio();
        }
        return null;
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
    } //Para que el estado pueda agregar

    public void iniciar() throws JugadorException { //Tira la excepción si un jugador a unirse a la nueva mano no tiene saldo
        this.setFecha(new Date());
        guardarSaldoInicialJugadores();
        iniciarNuevaMano();
        this.notificar(Observador.Evento.PARTIDA_INICIADA);

    }

    private void guardarSaldoInicialJugadores() {
        for (JugadorPartida j : jugadores) {

            j.guardarSaldoInicial();
        }

    }

    private void agregar(Mano m) {
        manos.add(m);
    }

    private void iniciarNuevaMano() {

        if (this.jugadores.size() == this.manoActual.getJugadoresActivos().size()) {

            agregar(manoActual);
            manoActual.iniciar();

        } else {
            // comprobarFinalizarMano();

        }

        //TODO: else finalizarPartida???
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
        player.saldoSuficiente(this.settings.getApuestaBase()+1);
    }

    public boolean jugadoresInsuficientes() {
        return jugadores.size() <= 1;

    }

    public boolean ultimoJugadorEnUnirse() {
        return faltanJugadores() == 0;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Delega a Mano">
    public void recibirApuesta(JugadorPartida unApostante, int monto) throws JugadorException {
        manoActual.recibirApuesta(unApostante, monto);
        //TODO: Ver si esto va acá o donde para notificar solo a los no
        //  notificar(Observador.Evento.TURNO_JUGADO);

    }

    public void recibirPasar(JugadorPartida pasante) throws ManoException, JugadorException {
        manoActual.recibirPasar(pasante);
        comprobarFinalizarMano();
         jugadorTieneSaldoParaContinuar(pasante);
    }
    
    

    public void recibirMatchApuesta(JugadorPartida jugador) throws JugadorException {
        try {

            manoActual.recibirMatchApuesta(jugador);

        } catch (JugadorException je) {
            jugadorTieneSaldoParaContinuar(jugador);
            throw je;

        } finally {

            comprobarFinalizarMano();

        }

    }
    
    public void jugadorTieneSaldoParaContinuar(JugadorPartida jugador) {
        if (jugador.getSaldo() < getApuestaBase()) {
            retirarJugador(jugador);
            jugador.notificar(Observador.Evento.JUGADOR_RETIRADO_SALDO);
        }
    }

    public void comprobarFinalizarMano() {
        if (manoActual.manoFinalizada()) {
            //  retirarJugadoresSaldoInsuficiente();
            settearSiguienteMano();
            // ultimaManoJugada = manoActual;
            //  manoActual = null;

        }

    }

    public int faltanPasar() {
        return manoActual.faltanPasar();
    }

    public List<JugadorPartida> jugadoresManoActual() {

        return manoActual.getJugadoresActivos();
    }

    public ApuestaMano getApuestaActiva() {
        return manoActual.getApuesta();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Finalizar">
    public void retirarJugador(JugadorPartida j) {
        if (jugadores.remove(j)) {
            if (manoActual != null) {

                manoActual.eliminar(j);
                comprobarFinalizarMano();
           

            }

        }

    }
    
    public boolean partidaFinalizada() {
        return jugadoresInsuficientes();
          
            //TODO: FinalizarPartida
    }

    public void settearSiguienteMano() {
        if (jugadoresInsuficientes()) { //Solo queda un jugador en la partida
            //FinalizarPartida
            //throw exception????
            // manoActual.notificar(Observador.Evento.PARTIDA_FINALIZADA); // Ver si vale la pena suscribir a Partida solo para este evento
        }
        int pozoAnterior = 0;
        JugadorPartida ganadorAnterior = manoActual.getGanador();
        if (ganadorAnterior == null) {
            pozoAnterior = manoActual.getPozo();
        }
        manoActual = new Mano();
      //  iniciarNuevaMano();
        manoActual.sumarPozo(pozoAnterior);
    }

    private void retirarJugadoresSaldoInsuficiente() throws JugadorException {
        for (JugadorPartida j : this.jugadores) {
            try {
                saldoSuficiente(j);
            } catch (JugadorException je) {
                retirarJugador(j);
                j.notificar(Observador.Evento.JUGADOR_RETIRADO_SALDO);
                continue;
            }
        }
    }

    public void unirASiguienteMano(JugadorPartida jp) throws JugadorException {

 
            manoActual.agregar(jp, this.getApuestaBase());
            iniciarNuevaMano();


    }

    // </editor-fold>
}
