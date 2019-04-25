package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.interactivos.condiciones.ListaCondiciones;
import juego.herramientas.LectorConsola;
import juego.componentes.jugador.Jugador;

public abstract class ObjetoInteractivo {

    //Atributos
    private String nombre;
    private String descripcion;
    private ListaCondiciones lCondiciones;

    //Constructora
    protected ObjetoInteractivo(){
        this.lCondiciones = new ListaCondiciones();
    }

    //Metodo de carga de datos
    protected void cargarDatos (String pNombre, String pDescripcion, String pDirCondiciones){
        //TODO
    }

    //Otros metodos
    public boolean acercarse (Jugador pJugadorActual){
        this.mostrarInfo();
        System.out.println();
        System.out.println("¿Quieres interactuar?:");
        boolean interactuar = LectorConsola.getLectorConsola().leerBoolean();
        System.out.println();
        if (interactuar){
            this.interactuar(pJugadorActual);
        }
        return interactuar;
    }

    protected abstract void interactuar (Jugador pJugador);

    protected boolean comprobarCondiciones(Jugador pJugador){
        return this.lCondiciones.cumpleLasCondiciones(pJugador);
    }
    
    private void mostrarInfo(){
        System.out.println(this.nombre);
    	System.out.println(this.descripcion);
    }

    public void imprimirNombre(){
        System.out.println(this.nombre);
    }
    
}
