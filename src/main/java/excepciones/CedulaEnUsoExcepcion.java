/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author MI PC
 */
public class CedulaEnUsoExcepcion extends Exception{
    public CedulaEnUsoExcepcion(){
        super("Ya existe un usuario registrado con esta cedula");
    }
    
}
