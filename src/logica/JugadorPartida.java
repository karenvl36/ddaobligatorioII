/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import excepciones.JugadorException;
import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author chiqu
 */
public class JugadorPartida extends Observable {

   
    private UsuarioJugador jugador;
    private int saldoInicial;
    private int gananciaPartida;
    private int apuestaPartida;
    private ManoJugador manoJugador;

    public JugadorPartida(UsuarioJugador j) {
        this.jugador = j;
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
    
    public int getGananciaNeta(){ 
     
        return this.gananciaPartida - this.apuestaPartida; 
    } 
   
    
    public void guardarSaldoInicial(){
        setSaldoInicial(this.getSaldo());
    }
    
    
    
    
    
    public void saldoSuficiente(int valorAApostar) throws JugadorException {
    
        if(!(valorAApostar <= jugador.getSaldo())){
            throw new JugadorException("Su saldo es insuficiente.");
        
        }
     
        
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
    
    public void realizarApuesta(int apuesta) throws JugadorException {
       
        
        saldoSuficiente(apuesta);
        restarSaldo(apuesta);

    }
    
    public ArrayList<Carta> getCartasManoJugador(){
        return manoJugador.getCartas();
    }


}
