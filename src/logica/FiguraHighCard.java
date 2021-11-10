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
public class FiguraHighCard extends Figura{
    
      public FiguraHighCard() {
        this.setDescripcion("No tiene figuras");
        this.setPuntaje(0);
    }

    @Override
    public boolean esFigura(List<Carta> cartasEvaluar, Carta ref) {
          ArrayList<Carta> temp = new ArrayList<>(cartasEvaluar);
            Collections.sort(temp);
            this.setHighCard(temp.get(0)); //TODO: Chequear que esté ordenado descenndente
            this.agregar(temp.get(0));
        return true;
    }
    
    


    @Override
    public int desempatar(Figura f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
