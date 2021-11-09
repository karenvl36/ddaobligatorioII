/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class Mazo {
    public List<Carta> cartas;
    //public HashSet<Carta> cartas = new HashSet<Carta>();
    //TODO: Deberíamos hacer el mazo un hashset para que no repita cartas?
    
    public Mazo(){

         this.cartas = new ArrayList<Carta>();
         crearMazo();
    }
    
    public List<Carta> getCartas(){
        return this.cartas;
    }
    
    public void barajar(){
        Collections.shuffle(cartas);
        //Collections.shuffle(cartas);
    }
    
    public ArrayList<Carta> repartir() {
        ArrayList<Carta> repartidas = new ArrayList<Carta>(5);
        
        for (int i = 0; i < 5; i++) {
          repartidas.add(cartas.remove(0));
         
        }
        return repartidas;

    }
    
    public void agregar(Carta c){
        if(!cartas.contains(c)){
            cartas.add(c);
        }
       
        
    }
    
    private void crearMazo(){
        //int numero, Palo palo, String imagen, String nombre
        for(int p= 1; p<=4; p++){
            for(int n=2; n<=13; n++){
                
                Carta c = new Carta(n, new Palo(p), n + "_"+p); 
                this.agregar(c);       
            }
        
        }
    
    }
    

    
    
 
    

    
}
