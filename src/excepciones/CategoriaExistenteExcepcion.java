package excepciones;

public class CategoriaExistenteExcepcion extends Exception {
    public CategoriaExistenteExcepcion(){
        super("Ya existe una categoria con este nombre/ID");
    }
    
}
