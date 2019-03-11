package juego.componentes.dungeon.objetos.interactuables;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoInteractuable {

    //Atributos
    private String nombre;
    private String descripcion;

    //Constructora
    protected ObjetoInteractuable(){
    }

    //Metodos de carga de datos

    //Otros metodos
    public void acercarse (){
        System.out.println(this.descripcion);
    }
    public abstract void interactuar (Jugador pJugador);
}
