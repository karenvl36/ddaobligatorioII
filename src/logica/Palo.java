/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Karen
 */
public class Palo {
    int valor;
    String descripcion;

    public Palo(int valor) {
        this.valor = valor;
        definirDescripcion();
    }

    @Override
    public String toString() {
        return "Palo{" + "valor=" + valor + ", descripcion=" + descripcion + '}';
    }

    private void definirDescripcion() {
        switch (valor) {
            case 1:
                descripcion = "Picas";
                break;
            case 2:
                descripcion = "Tréboles";
                break;
            case 3:
                descripcion = "Diamantes";
                break;
            case 4:
                descripcion = "Corazones";
                break;
        }

    }
    
    
}
