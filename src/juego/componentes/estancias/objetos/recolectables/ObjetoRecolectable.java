package juego.componentes.estancias.objetos.recolectables;

public abstract class ObjetoRecolectable {
    //Atributos
    private String nombre;
    private String descripcion;

    //Constructora
    protected ObjetoRecolectable(String pNombre){
        this.nombre = pNombre;
    }

    //Otros metodos
    public void mostrarInfo(){
        System.out.println("Nombre: "+this.nombre);
    }
    
    public boolean tieneEsteNombre(String pNombre){
        return (this.nombre.equals(pNombre));
    }
}
