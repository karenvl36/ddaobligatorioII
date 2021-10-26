/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author chiqu
 */
public class JugadorPartida {

    private Partida partida;
    private UsuarioJugador jugador;
    private int saldoInicial;
    private int gananciaPartida;
    private int apuestaPartida;
    private ManoJugador manoJugador;

    public JugadorPartida(UsuarioJugador j) {
        this.jugador = j;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public UsuarioJugador getJugador() {
        return jugador;
    }

    public void setJugador(UsuarioJugador jugador) {
        this.jugador = jugador;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public int getGananciaPartida() {
        return gananciaPartida;
    }

    public void setGananciaPartida(int gananciaPartida) {
        this.gananciaPartida = gananciaPartida;
    }

    public int getApuestaPartida() {
        return apuestaPartida;
    }

    public void setApuestaPartida(int apuestaPartida) {
        this.apuestaPartida = apuestaPartida;
    }

    public ManoJugador getManoJugador() {
        return manoJugador;
    }

    public void setManoJugador(ManoJugador manoJugador) {
        this.manoJugador = manoJugador;
    }
    
    
    
    public boolean saldoSuficiente(int valorAApostar){
        return valorAApostar <= jugador.getSaldo();
        
    }
    
    public void restarSaldo(int apuesta){
        sumarApuestaPartida(apuesta);
        this.jugador.restarSaldo(apuesta);
    
    }
    
    public void sumarApuestaPartida(int apuesta){
        apuestaPartida += apuesta;
    }

}
