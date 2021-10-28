/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class Partida {

    private Date fechaInicio;
    private List<Mano> manos;
    private List<JugadorPartida> jugadores;
    private Settings settings;
    private Mano manoActual;

    public Partida() {
    }

 



    public Date getFecha() {
        return this.fechaInicio;
    }

    public void setFecha() {
        this.fechaInicio = new Date();
    }
    
    public Partida agregar(JugadorPartida player){
        if(faltanJugadores() != 0 && !jugadorYaEnPartida(player) && saldoSuficiente(player)){  
            this.jugadores.add(player);
            return comprobarInicio();
            //TODO: notificación de Observable
            //TODO: throw la exception que venga de jugadorYaEnPartida?
            //TODO: throw exception de saldo insuficiente
        }
        
        return null;
        
    }
    
    private boolean saldoSuficiente(JugadorPartida player){
        return player.saldoSuficiente(settings.getApuestaBase());
        //TODO: throw exception
    }
    

    
    public Partida comprobarInicio() {
        if (faltanJugadores() == 0) {
            iniciar();
            return this;
        }
        
       return null;
    }

    
    private int faltanJugadores(){
    
        return getCantMaximaJugadores() - cantidadJugadores();
    }
    
    private boolean verificarCantJugadores() {
        return (getCantMaximaJugadores() - jugadores.size()) >= 1;

    }
    

    
    private int cantidadJugadores(){
        return jugadores.size();
    }
    
    public int getApuestaBase(){
        return settings.getInstancia().getApuestaBase();
    }
    
    public int getCantMaximaJugadores(){
        return settings.getInstancia().getCantMaximaJugadores();
    
    }
    
    
    public void iniciar(){
        this.setFecha(new Date());
        guardarSaldoInicialJugadores();
        nuevaMano();
//        TODO: if(cantidadJugadores() == 1){
//            finalizar();
//        }
        
    }
    
 

    private void setFecha(Date date) {
        this.fechaInicio = date;
    }
    
    private void guardarSaldoInicialJugadores(){
        for(JugadorPartida j: jugadores ){
        
            j.guardarSaldoInicial();
        }
    
    }
    
    private void agregar(Mano m){
        manos.add(m);
    }
    
    private void nuevaMano(){
        
        Mano mano = new Mano();
        manoActual = mano;
        agregar(mano);
        asignarJugadoresAMano();
        
        
  
    }
    
    private void asignarJugadoresAMano(){
        for(JugadorPartida j: jugadores ){
        
          if(saldoSuficiente(j)){
              manoActual.agregar(j, getApuestaBase());
              
          }else{
              retirarJugador(j);
              //TODO: throw la exception de saldo Insuficiente
          }
        }
    
    }

    private boolean jugadorYaEnPartida(JugadorPartida player) {
       if(jugadores.contains(player)){
           return true;
       }else{
       
           return false;
           //TODO: throw Exception message "Ya estás en esta partida."
       }
    }
    
    public void retirarJugador(JugadorPartida j){
        jugadores.remove(j);
    
    }
    
    public void jugarPoker(){
    
        while(cantidadJugadores() >1){
            iniciar();        
        }
    
    }
    
    

}
