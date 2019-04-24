package juego.componentes.estancias.objetos.recolectables;

public class ObjetoClave extends ObjetoRecolectable {
    //Atributos
    String descripcion;

    //Constructor
    public ObjetoClave (String pNombre, String pDescripcion){
        super(pNombre);
        this.descripcion = pDescripcion;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Descripción: "+descripcion);
    }
}

