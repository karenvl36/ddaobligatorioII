/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Karen
 */
public class FiguraPierna extends Figura {

    public FiguraPierna() {
        this.setDescripcion("Pierna");
        this.setPuntaje(15);
    }

    
    
    @Override
    public boolean esFigura(List<Carta> cartasEvaluar, Carta ref) {
       for(Carta c: cartasEvaluar){
           if(!this.getCartas().contains(c)){
              
               if(c.getNumero() == ref.getNumero()){
                    this.getCartas().add(c);
                    return true;
                    
               }
               
           }
       }
       
       return false;
    }

 
    @Override
    public int desempatar(Figura f) {
          return  f.getCartas().get(0).getNumero() - this.getCartas().get(0).getNumero();
    }



    

    
}
