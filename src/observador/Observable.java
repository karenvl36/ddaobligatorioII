/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    public List<Observador> subscriptores = new ArrayList();

    public void subscribir(Observador obs) {
        subscriptores.add(obs);
    }

    public void desubscribir(Observador obs) {
        subscriptores.remove(obs);
    }

    public void notificar(Object event) {
        //subscriptores.stream().forEach(observer -> {observer.notificar(this, event);});
        for(Observador s: subscriptores){
            s.notificar(this, event);
        }
    }
}
