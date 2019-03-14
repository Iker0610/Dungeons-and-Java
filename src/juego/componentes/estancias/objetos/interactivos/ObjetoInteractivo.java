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
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Otros metodos
    public void acercarse (){
        System.out.println(this.descripcion);
        //TODO
    }

    public abstract void interactuar (Jugador pJugador);

    protected boolean comprobarCondicion(Jugador pJugador){
        return this.lCondiciones.cumpleLasCondiciones(pJugador);
    }
    
    private void mostrarInfo(){
    	
    }
    
}
