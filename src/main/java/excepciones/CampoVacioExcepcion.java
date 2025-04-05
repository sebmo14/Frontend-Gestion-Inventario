/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author MI PC
 */
public class CampoVacioExcepcion extends Exception {
    public CampoVacioExcepcion(){
        super("Debe rellenar todos los campos");
    }
    
}
