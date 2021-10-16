/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class Mazo {
    public List<Carta> cartas;
    
    public Mazo(List<Carta> cartas){
        this.cartas = cartas;
    }
    
    public List<Carta> getCartas(){
        return this.cartas;
    }
    
    public void barajar(){
        Collections.shuffle(cartas);
    }
    
 
    
}
