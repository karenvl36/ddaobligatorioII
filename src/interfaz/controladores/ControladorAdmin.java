/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.IVistaAdmin;
import java.util.List;
import logica.Fachada;
import logica.Partida;
import logica.UsuarioAdministrador;
import observador.Observable;
import observador.Observador;



/**
 *
 * @author chiqu
 */
public class ControladorAdmin implements Observador{
    
    private UsuarioAdministrador admin;
    private IVistaAdmin vista;
    
    
    public ControladorAdmin(IVistaAdmin vista, UsuarioAdministrador adm){
        this.vista = vista;
        this.admin = adm;
        Fachada.getInstancia().subscribir(this);
    }

    public ControladorAdmin(IVistaAdmin vista) {
        this.vista = vista;
         Fachada.getInstancia().subscribir(this);
    }



    @Override
    public void notificar(Observable source, Object event) {
        if(event == Observador.Evento.PARTIDA_INICIADA){
            actualizar();
        }
    }

    public void actualizar() {  
        vista.actualizar(Fachada.getInstancia().getPartidasEnCurso());
    }
    
    
   
    
}
