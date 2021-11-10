/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Karen
 */
public class ManoJugador {
   // int apuestaTurno;
    ArrayList<Carta> cartas;
    Figura figura;

    public ManoJugador(ArrayList<Carta> cartas) {
        this.cartas = cartas;
        evaluar();
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Getters-Setters">
//    public int getApuestaTurno() {
//        return apuestaTurno;
//    }
//
//    public void setApuestaTurno(int apuestaTurno) {
//        this.apuestaTurno = apuestaTurno;
//    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }


    // </editor-fold>
    
    public void evaluar(){
        Figura color = new FiguraColor();
        Figura par = new FiguraPar();
        Figura pierna = new FiguraPierna();
        Figura highCard = new FiguraHighCard();
        
        if(color.esFigura(cartas)){
            this.figura = color;
     
//        }else if (pierna.esFigura(cartas)){
//            this.figura = pierna; //TODO: Agregar evaluacion de Pierna
        
        }else if(par.esFigura(cartas)){
            this.figura = par;
        }else if(highCard.esFigura(cartas)){
            this.figura = highCard;
        }
    
    }
    
    
    //TODO: la mano tiene que definir qué figura tiene apenas se arma, para poder mostrar al jugador
    
}
