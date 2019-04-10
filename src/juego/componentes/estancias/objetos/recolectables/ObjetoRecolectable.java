package juego.componentes.estancias.objetos.recolectables;

public abstract class ObjetoRecolectable {
    //Atributos
    private String nombre;
    private String descripcion;

    //Constructora
    protected ObjetoRecolectable(String pNombre, String pDescripcion){
        this.nombre = pNombre;
        this.descripcion = pDescripcion;
    }

    //Otros metodos
    public void mostrarInfo(){
        System.out.println(this.nombre);
        System.out.println(this.descripcion);
    }
    
    public boolean tieneEsteNombre(String pNombre){
        return (this.nombre == pNombre);
    }
}
