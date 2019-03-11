package juego.componentes.dungeon.objetos.recogibles;

public class ObjetoClave extends ObjetoRecogible {
    //Atributos
    private String descripcion;
    //Constructor
    public ObjetoClave (String pNombre, String pDescripcion){
        super(pNombre);
        this.descripcion = pDescripcion;
    }
}
