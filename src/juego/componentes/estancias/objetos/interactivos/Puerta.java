package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.Dungeon;
import juego.componentes.jugador.Jugador;

public class Puerta extends ObjetoInteractivo {
    //Atributos
    private String idEstancia;
    private boolean desbloqueada;

    //Constructora
    public Puerta (String pDir){
        //TODO
    }

    //Otros metodos
    protected void interactuar(Jugador pJugador) {
        if (this.comprobarCondiciones(pJugador)){
        	this.desbloquear();
        	this.cambiarEstancia();
        }
        
        
    }

    private void cambiarEstancia(){
        Dungeon.getDungeon().cambiarEstancia(this.idEstancia);
    }

    private void desbloquear(){
        this.desbloqueada = true;
    }
}
