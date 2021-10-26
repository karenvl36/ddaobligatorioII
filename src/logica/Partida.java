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
        if(verificarCantJugadores()){
            this.jugadores.add(player);
            return comprobarInicio();
        }
        return null;
        
    }
    
    public Partida comprobarInicio() {
        if (!verificarCantJugadores()) {
            iniciar();
            return this;
        }
        
       return null;
    }

    private boolean verificarCantJugadores() {
        return (settings.getInstancia().getCantMaximaJugadores() - jugadores.size()) >= 1;

    }
    
    public int jugadoresFaltantes(){
        return settings.getInstancia().getCantMaximaJugadores()- jugadores.size();
    }
    
    public void iniciar(){
        this.setFecha(new Date());
        
    }

    private void setFecha(Date date) {
        this.fechaInicio = date;
    }
    
    private void guardarSaldoInicialJugadores(){
        for(JugadorPartida j: jugadores ){
        
            j.setSaldoInicial(j.getJugador().getSaldo());
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
        
          if(j.saldoSuficiente(settings.getInstancia().getApuestaBase())){
              manoActual.agregar(j, settings.getInstancia().getApuestaBase());
              
          }
        }
    
    }
    
    

}
