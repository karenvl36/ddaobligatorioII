/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author chiqu
 */
public abstract class Figura implements Comparable<Figura>{
    
    private String descripcion;
    private Palo palo;
    private Carta highCard;
    private List<Carta> cartas = new ArrayList<Carta>();
    private int puntaje;
    
    
    public abstract boolean esFigura(List<Carta> cartasEvaluar);
    public abstract int desempatar(Figura f); 
 

    @Override
    public int compareTo(Figura o){
        int resultado =  o.puntaje - this.puntaje;
        if(resultado == 0){
            return this.desempatar(o);
        }

        return resultado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public Carta getHighCard() {
        return highCard;
    }

    public void setHighCard(Carta highCard) {
        this.highCard = highCard;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public void agregar(Carta c){
        this.cartas.add(c);
    }
    
    public String getDescripcionCartas(){
        String ret = "";
         for(Carta c: cartas){
            ret += c.getNombre() + " de " + c.getPalo().getDescripcion() + " - ";
        }
         
         return ret;
        
    }
    
           
    
}
