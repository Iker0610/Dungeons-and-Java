package juego.componentes.dungeon.objetos.interactivos;

import juego.componentes.dungeon.objetos.interactivos.condiciones.ListaCondiciones;
import juego.componentes.jugador.Jugador;

public abstract class ObjetoInteractivo {

    //Atributos
    private String nombre;
    private String descripcion;
    private ListaCondiciones lCondiciones;

    //Constructora
    protected ObjetoInteractivo(){}

    //Otros metodos
    public void acercarse (){
        System.out.println(this.descripcion);
    }

    public abstract void interactuar (Jugador pJugador);

    private boolean comprobarCondicion(Jugador pJugador){
        return this.lCondiciones.cumpleLasCondiciones(pJugador);
    }


}
