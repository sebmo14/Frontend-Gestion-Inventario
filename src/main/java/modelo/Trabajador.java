
package Modelo;

import java.util.UUID;

/**
 *
 * @author MI PC
 */
public class Trabajador {
    //Atributos
    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;
    private String id;
    private String contraseña;
    private double salario;
    private int añosExpe;
    
    //Constructor

    public Trabajador(String nombre, String apellidos, int edad, String correo, String contraseña, double salario, int añosExpe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.id = UUID.randomUUID().toString();
        this.contraseña = contraseña;
        this.salario = salario;
        this.añosExpe = añosExpe;
    }

    public Trabajador() {
         this.id = UUID.randomUUID().toString();
    }
    
    

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAñosExpe() {
        return añosExpe;
    }

    public void setAñosExpe(int añosExpe) {
        this.añosExpe = añosExpe;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "salario=" + salario +
                ", añosExpe=" + añosExpe +
                '}';
    }
}
