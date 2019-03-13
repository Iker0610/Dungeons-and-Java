package juego.componentes.estancias.objetos.recogibles;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoRecolectable {
    //Atributos
    protected String nombre;

    //Constructora
    protected ObjetoRecolectable(String pNombre){
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
