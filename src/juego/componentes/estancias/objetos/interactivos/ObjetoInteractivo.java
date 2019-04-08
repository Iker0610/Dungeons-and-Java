package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.interactivos.condiciones.ListaCondiciones;
import juego.componentes.herramientas.LectorConsola;
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
        this.mostrarInfo();
        System.out.println("¿Quieres interactuar?:");
        return LectorConsola.getLectorConsola().leerBoolean();
    }

    protected abstract void interactuar (Jugador pJugador);

    protected boolean comprobarCondiciones(Jugador pJugador){
        return this.lCondiciones.cumpleLasCondiciones(pJugador);
    }
    
    private void mostrarInfo(){
    	System.out.println(this.descripcion);
    }

    public void imprimirNombre(){
        System.out.println(this.nombre);
    }
    
}
