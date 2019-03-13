package juego.componentes.estancias.objetos.recogibles;

public class ObjetoClave extends ObjetoRecolectable {
    //Atributos
    private String descripcion;
    //Constructor
    public ObjetoClave (String pNombre, String pDescripcion){
        super(pNombre);
        this.descripcion = pDescripcion;
    }
}
