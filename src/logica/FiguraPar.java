/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Karen
 */
public class FiguraPar extends Figura {

    public FiguraPar() {
        this.setDescripcion("Par");
        this.setPuntaje(5);
    }

    
    @Override
    public boolean esFigura(List<Carta> cartasEvaluar, Carta ref) {
        ArrayList<Carta> temp = new ArrayList<>(cartasEvaluar);
        Collections.sort(temp);
        for(int i= 0; i<temp.size(); i++){
            for(int j=i+1; j<temp.size(); j++){
              
                if(temp.get(i).getNumero() == temp.get(j).getNumero()){
                    this.agregar(temp.get(i));
                    this.agregar(temp.get(j));
                    return true;
                }
            }
          
        }
        
        return false;
    }

    @Override
    public int desempatar(Figura f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




 
    
}
