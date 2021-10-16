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
public class Fachada {
    private static Fachada instancia;
    ServicioUsuario su = ServicioUsuario.getInstancia();
    ServicioPartida sp = ServicioPartida.getInstancia();

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    
    
    public UsuarioGenerico logInAdmin(String name,String pw){
        return su.logInAdmin(name, pw);
    }
    
    
    public UsuarioGenerico logInJugador(String name,String pw){
        return su.logInJugador(name, pw);
    }
    
  
    
}
