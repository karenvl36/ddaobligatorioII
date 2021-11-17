/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import logica.JugadorPartida;
import logica.Partida;
import logica.UsuarioGenerico;

/**
 *
 * @author chiqu
 */
public interface LoginVista {
    
    
    public void ingresar();
    public void mostrarError(String error);
    public void abrirFrame(Partida partida, UsuarioGenerico userGenerico, JugadorPartida jp);
    public void abrirFramePartida(Partida p, JugadorPartida jp);
    public void verificarLoginGenerico(String nick,String pw);

    
}
