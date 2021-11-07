/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import logica.UsuarioGenerico;

/**
 *
 * @author chiqu
 */
public interface LoginVista {
    
    
    public void ingresar();
    public void mostrarError(String error);
    public void abrirDialogo(UsuarioGenerico userGenerico);
    public void logIn(String nick,String pw);
   // public UsuarioGenerico metodoAuxiliar(UsuarioGenerico userG);
    
}
