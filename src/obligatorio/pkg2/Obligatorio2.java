/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.pkg2;

import interfaz.vistas.MenuPrincipal;
import logica.DatosPrueba;

/**
 *
 * @author chiqu
 */
public class Obligatorio2 {

  
    public static void main(String[] args) {
      DatosPrueba.cargar();
      MenuPrincipal mp = new MenuPrincipal();
      mp.setVisible(true);
    }
    
}
