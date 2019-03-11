package juego.componentes.dungeon.objetos.interactuables;

import juego.componentes.jugador.Jugador;

public class Npc extends ObjetoInteractuable {
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
}
