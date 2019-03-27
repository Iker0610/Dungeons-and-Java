package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.interactivos.condiciones.ListaCondiciones;
import juego.componentes.jugador.Jugador;

public abstract class ObjetoInteractivo {

    //Atributos
    private String nombre;
    private String descripcion;
    private ListaCondiciones lCondiciones;

    //Constructora
    protected ObjetoInteractivo(){
        //TODO
    }

    //Metodo de carga de datos
    protected void cargarDatos (String pNombre, String pDescripcion, String pDirCondiciones){
        //TODO
    }

    //Otros metodos
    public boolean acercarse (Jugador pJugadorActual){
        //TODO
    }

    protected abstract void interactuar (Jugador pJugador);

    protected boolean comprobarCondicion(Jugador pJugador){
        return this.lCondiciones.cumpleLasCondiciones(pJugador);
    }
    
    private void mostrarInfo(){
    	
    }

    public void imprimirNombre(){
        //TODO
    }
    
}
