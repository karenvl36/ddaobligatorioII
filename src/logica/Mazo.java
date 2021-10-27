/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class Mazo {
    public List<Carta> cartas;
    
    public Mazo(){

    }
    
    public List<Carta> getCartas(){
        return this.cartas;
    }
    
    public void barajar(){
        Collections.shuffle(cartas);
    }
    
    public ArrayList<Carta> repartir() {
        ArrayList<Carta> repartidas = new ArrayList<Carta>(5);
        for (int i = 0; i < 5; i++) {
            repartidas.add(cartas.remove(0));
        }
        return repartidas;

    }
    
    
 
    

    
}
