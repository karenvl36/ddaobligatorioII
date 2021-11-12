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
 * @author Karen
 */
public class FiguraPierna extends Figura {

    public FiguraPierna() {
        this.setDescripcion("Pierna");
        this.setPuntaje(15);
    }

    
    
    @Override
    public boolean esFigura(List<Carta> cartasEvaluar) {
        List<Carta> cartasRestantes = new ArrayList<Carta>();
        // cartasEvaluar.removeAll(this.getCartas());

        for (Carta c : cartasEvaluar) {
            if (!this.getCartas().contains(c)) {
                cartasRestantes.add(c);
                if (c.getNumero() == this.getCartas().get(0).getNumero()) {

                    this.getCartas().add(c);
                    return true;

              
                }

            }
        }    
        
        if (cartasRestantes.get(0).getNumero() == cartasRestantes.get(1).getNumero() && cartasRestantes.get(2).getNumero() == cartasRestantes.get(1).getNumero()) {

                this.setCartas(cartasRestantes);
                return true;
            }

            return false;
        }

 
    @Override
    public int desempatar(Figura f) {
          return  f.getCartas().get(0).getNumero() - this.getCartas().get(0).getNumero();
    }



    

    
}
