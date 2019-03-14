package juego.componentes.estancias.objetos.interactivos.condiciones;

import juego.componentes.jugador.Jugador;

public abstract class Condicion {
    //Atributos

    //Constructora
    protected Condicion(){}

    //Otros metodos
    public abstract boolean cumpleLaCondicion(Jugador pJugador);
}

