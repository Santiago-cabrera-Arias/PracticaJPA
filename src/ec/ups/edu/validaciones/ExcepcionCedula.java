/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.validaciones;

/**
 *
 * @author santi
 */
public class ExcepcionCedula extends Exception{

    public ExcepcionCedula() {
    
        super("La cedula no es correcta.");
    
    }
    
}
