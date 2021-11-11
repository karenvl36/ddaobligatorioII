/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chiqu
 */
public class Carta implements Comparable<Carta> {
    
    private int numero;
    private Palo palo;
    private String imagen;
    private String nombre;
 
    @Override
    public String toString() {
        return "Carta{" + "numero=" + numero + ", palo=" + palo + ", imagen=" + imagen + ", nombre=" + nombre + '}';
    }
    


    public Carta(int numero, Palo palo, String imagen, String desc) {
        this.numero = numero;
        this.palo = palo;
        this.imagen = imagen;
        this.nombre = desc;
        cambiarDesc();
    }
   

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    private void cambiarDesc(){
       switch (numero) {
            case 14:
                nombre = "As";
                break;
            case 13:
                nombre = "K";
                break;
            case 12:
                nombre = "Q";
                break;
            case 11:
                nombre = "J";
                break;
        }
    }

    @Override
    public int compareTo(Carta o) {
        Carta c = (Carta)o;
       // return (this.numero + this.palo.valor) - (c.numero + c.palo.valor); 
       return c.numero - this.numero;
                

    }
   
    
    
    
    
    
    
}
