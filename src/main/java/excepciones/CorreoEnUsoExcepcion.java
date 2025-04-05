package excepciones;

public class CorreoEnUsoExcepcion extends Exception {
    public CorreoEnUsoExcepcion(){
        super("El correo ya esta en uso");
    }
}
