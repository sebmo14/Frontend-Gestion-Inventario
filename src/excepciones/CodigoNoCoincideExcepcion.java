package excepciones;

public class CodigoNoCoincideExcepcion extends Exception{
    public CodigoNoCoincideExcepcion(){
        super("Este codigo no coincide con ningun producto");
    }
}
