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
    private int apuestaBase;
    private List<JugadorPartida> jugadores;
    private int cantMaximaJugadores;

    public Partida(int cantMaxJugadores) {
        fechaInicio = new Date();
        manos = new ArrayList<>();
        this.apuestaBase = 1500;
        this.cantMaximaJugadores = cantMaxJugadores;
    }

    public int getApuestaBase() {
        return apuestaBase;
    }

    public Date getFecha() {
        return this.fechaInicio;
    }

    public void setFecha() {
        this.fechaInicio = new Date();
    }
    
    public boolean agregar(JugadorPartida player){
        if(verificarCantJugadores()){
            this.jugadores.add(player);
            if(!verificarCantJugadores()){
                iniciar();
            }
        }
        return false;
        
    }

    private boolean verificarCantJugadores() {
        return (this.cantMaximaJugadores - jugadores.size()) >= 1;

    }
    
    public int jugadoresFaltantes(){
        return this.cantMaximaJugadores - jugadores.size();
    }
    
    public void iniciar(){
        this.setFecha(new Date());
    }

    private void setFecha(Date date) {
        this.fechaInicio = date;
    }
    
    
    

}
