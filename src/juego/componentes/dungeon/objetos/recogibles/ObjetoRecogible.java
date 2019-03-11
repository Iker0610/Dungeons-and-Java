package juego.componentes.dungeon.objetos.recogibles;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoRecogible {
    //Atributos
    protected String nombre;

    //Constructora
    protected ObjetoRecogible(String pNombre){
        this.nombre = pNombre;
    }

    //Otros metodos
    public void recoger (Jugador pJugador){
        pJugador.anadirObjetoRecojible(this);
    }

    public void imprimir(){
        System.out.println(this.nombre);
    }
}
