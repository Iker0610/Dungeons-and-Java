package juego.componentes.dungeon.objetos.interactivos;

import juego.componentes.jugador.Jugador;

public class Npc extends ObjetoInteractivo {
    //Atributos
    private String pista;
    private String primeraBienvenida;
    private String bienvenidaPosterior;
    private String primerRechazo;
    private String rechazoPosterior;
    private boolean primerEncuentro;

    //Constructora
    public Npc (String pNombre){
        super();
    }

    //Otros metodos
    @Override
    public void interactuar(Jugador pJugador) {}

    private void bienvenida(){}
    private void mostrarPista(){}
    private void mostrarRechazo(){}

}
