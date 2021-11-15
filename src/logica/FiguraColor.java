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
public class FiguraColor extends Figura{

    public FiguraColor() {
        this.setDescripcion("Color");
        this.setPuntaje(300);
    }
    
    



    @Override
    public boolean esFigura(List<Carta> cartasEvaluar) {

        for (int i = 0; i < cartasEvaluar.size(); i++) {
            for (int j = 1; j < cartasEvaluar.size(); j++) {
                if (!cartasEvaluar.get(i).getPalo().equals(cartasEvaluar.get(j).getPalo())) {
                    
                    return false;
                }
            }
           
            this.setPalo(cartasEvaluar.get(i).getPalo());
            this.setCartas(cartasEvaluar);
            return true;
           
        }

        return true;

    }
    
    
    

    @Override
    public int desempatar(Figura f) {
        return f.getPalo().getValor() - this.getPalo().getValor();
    }

    @Override
    public String getDescripcionCartas(){
        return  super.getDescripcion() + " de " + getPalo().getDescripcion();    
    }


        
        

    
}
