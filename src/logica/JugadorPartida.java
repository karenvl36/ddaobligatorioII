/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import observador.Observable;

/**
 *
 * @author chiqu
 */
public class JugadorPartida extends Observable {

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
    
    public int getSaldo(){
        return getJugador().getSaldo();
    }
   
    
    public void guardarSaldoInicial(){
        setSaldoInicial(this.getSaldo());
    }
    
    
    
    
    
    public boolean saldoSuficiente(int valorAApostar) {
    
        return valorAApostar <= jugador.getSaldo();
     
        
    }
    
    private void restarSaldo(int apuesta){
        sumarApuestaPartida(apuesta);
        this.jugador.restarSaldo(apuesta);
    
    }
    
     private void sumarSaldo(int valor){
        sumarApuestaPartida(valor);
        this.jugador.sumarSaldo(valor);
    }
    
    private void sumarApuestaPartida(int apuesta){
        apuestaPartida += apuesta;
    }
    
    private void sumarGananciaPartida(int valor){
        gananciaPartida += valor;
    }
    
   
    
    public void recibirGanancia(int pozo){
        sumarSaldo(pozo);
        
    }
    
    public boolean realizarApuesta(int apuesta){
        if(saldoSuficiente(apuesta)){
       
            restarSaldo(apuesta);
            return true;
        }
        return false;
        
        //TODO: throw Exception que le llega del método anterior
    }


}
