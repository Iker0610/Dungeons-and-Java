package juego.componentes.dungeon.objetos.recojibles;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoRecojible {
    //Atributos
    protected String nombre;

    //Constructora
    protected ObjetoRecojible(String pNombre){
        this.nombre = pNombre;
    }

    //Otros metodos
    public void recoger (Jugador pJugador){

    }
}
