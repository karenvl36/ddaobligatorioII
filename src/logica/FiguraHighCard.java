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
        this.setDescripcion("Carta más alta: ");
        this.setPuntaje(0);
    }

    @Override
    public boolean esFigura(List<Carta> cartasEvaluar) {
          ArrayList<Carta> temp = new ArrayList<>(cartasEvaluar);
            Collections.sort(temp);
            this.setHighCard(temp.get(0)); 
            this.setPalo(temp.get(0).getPalo());
            this.agregar(temp.get(0));
            this.setPuntaje(this.getHighCard().getNumero());
        return true;
    }
    
    


    @Override
    public int desempatar(Figura f) {
          return f.getPalo().getValor() - this.getPalo().getValor();
    }
    
}
