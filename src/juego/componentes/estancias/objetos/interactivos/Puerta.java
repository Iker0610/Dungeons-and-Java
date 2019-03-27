package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.Dungeon;
import juego.componentes.jugador.Jugador;

public class Puerta extends ObjetoInteractivo {
    //Atributos
    private String idEstancia;
    private boolean desbloqueada;

    //Constructora
    public Puerta (String pDir){
        super();
        //TODO
    }

    //Otros metodos
    protected void interactuar(Jugador pJugador) {
        //TODO
    }

    private void cambiarEstancia(){
        Dungeon.getDungeon().cambiarEstancia(this.idEstancia);
    }

    private void debloquear(){
        this.desbloqueada = true;
    }
}
