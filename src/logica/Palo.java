/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Objects;

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.valor;
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palo other = (Palo) obj;
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
