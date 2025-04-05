package excepciones;

  public class ContraseñaDiferenteExcepcion extends Exception{
    public ContraseñaDiferenteExcepcion(){
        super("La contraseña debe ser igual en los dos campos");
    } 
}

