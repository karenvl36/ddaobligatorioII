/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author chiqu
 */
public class Carta {
    
    private int numero;
    private Palo palo;
    private String imagen;
    private String nombre;

    @Override
    public String toString() {
        return "Carta{" + "numero=" + numero + ", palo=" + palo + ", imagen=" + imagen + ", nombre=" + nombre + '}';
    }

    public Carta(int numero, Palo palo, String imagen) {
        this.numero = numero;
        this.palo = palo;
        this.imagen = imagen;
     
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
   
    
    
    
    
    
    
}
