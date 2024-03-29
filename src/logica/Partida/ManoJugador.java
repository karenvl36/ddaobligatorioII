/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Partida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import logica.Carta;
import logica.Figura;
import logica.FiguraColor;
import logica.FiguraHighCard;
import logica.FiguraPar;
import logica.FiguraPierna;


/**
 *
 * @author Karen
 */
public class ManoJugador implements Comparable<ManoJugador> {
   // int apuestaTurno;
    ArrayList<Carta> cartas;
    Figura figura;

    public ManoJugador(ArrayList<Carta> cartas)  {
        this.cartas = cartas;
        evaluar();
    }
    
//    public void hacerElMapa(){
//    
//        HashMap<Integer,Integer> mapa = new HashMap<Integer, Integer>();
//        for(Carta c: cartas){
//            if (mapa.containsKey(c.getNumero())){
//               Integer remainder = mapa.get(c.getNumero());
//               mapa.put(c.getNumero(), remainder +1);
//            }
//            else {
//                mapa.put(c.getNumero(), 1);
//            }
//        }
//        for(int key: mapa.keySet()){
//            System.out.print(key);
//            System.out.print(":");
//            System.out.print(mapa.get(key));
//            System.out.println("-----");
//             
//        }
//    
//    }
   
    
    

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
    
    public void evaluar() {
        Figura color = new FiguraColor();
        Figura par = new FiguraPar();
        Figura pierna = new FiguraPierna();
        Figura highCard = new FiguraHighCard();
       

        if (color.esFigura(cartas)) {
            this.figura = color;

        } else if (par.esFigura(cartas)) {
            
            this.figura = par;
            
            pierna.setCartas(par.getCartas());
            
            if (pierna.esFigura(cartas)) {
                this.figura = pierna;
            }
            
        } else if (highCard.esFigura(cartas)) {
            this.figura = highCard;
        }

    }
    
    
    
    @Override
    public int compareTo(ManoJugador o) {
        return figura.compareTo(o.figura);
    }

   
}
