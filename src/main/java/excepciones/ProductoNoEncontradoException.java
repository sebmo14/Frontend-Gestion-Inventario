/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author MI PC
 */
public class ProductoNoEncontradoException extends Exception{
    public ProductoNoEncontradoException(){
        super("No se encontro el producto");
    }
    
}
