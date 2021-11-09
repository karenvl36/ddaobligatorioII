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
public class DatosPrueba {

    public static void cargar() {
 
        Settings settings = Settings.getInstancia(); 
        settings.setApuestaBase(300);
        settings.setCantMaximaJugadores(2);
        
        
        ServicioUsuario su = ServicioUsuario.getInstancia();
        
        //Cargando Admines
        UsuarioAdministrador admin = new UsuarioAdministrador("admin","José Benitez","admin");
        UsuarioAdministrador admin2 = new UsuarioAdministrador("admin2","Maria Becerra","admin2");
        UsuarioAdministrador admin3 = new UsuarioAdministrador("admin3","Jotaro Kujo","admin3");
        su.agregar(admin);
        su.agregar(admin2);
        su.agregar(admin3);
        //Cargando Usuarios
        UsuarioJugador maria = new UsuarioJugador("maria", "Maria Oklahoma" , "maria", 13000);
        UsuarioJugador diego = new UsuarioJugador("diego", "Diego Chiquiar" , "diego", 99000);
        UsuarioJugador karen = new UsuarioJugador("karen", "Karen Vonrotz" , "karen", 77000);
        UsuarioJugador hernan = new UsuarioJugador("hernan", "Hernan Rodriguez" , "hernan", 6000);
        UsuarioJugador gonzalo = new UsuarioJugador("gonzalo", "Gonzalo Elias" , "gonzalo", 100);  //Este no deberia nunca poder entrar pq no tiene saldo suf para jugar
        UsuarioJugador lucia = new UsuarioJugador("lucia", "Lucia Paola" , "lucia", 22000);
        UsuarioJugador aurelio = new UsuarioJugador("aurelio", "Aurelion Sol" , "aurelio", 033); //Este tampoco deberia poder entrar nunca a la partida
        su.agregar(maria);
        su.agregar(diego);
        su.agregar(karen);
        su.agregar(hernan);
        su.agregar(gonzalo);
        su.agregar(lucia);
        su.agregar(aurelio);
        //Definiendo Partida
        
        //int numero, Palo palo, String imagen, String nombre
        for(int p= 1; p<=4; p++){
            for(int n=2; n<=13; n++){
                
                Carta c = new Carta(n, new Palo(p), n + "_"+p); 
          
                 System.out.println(c);
                
            }
        
        }
        
    }
    
}
