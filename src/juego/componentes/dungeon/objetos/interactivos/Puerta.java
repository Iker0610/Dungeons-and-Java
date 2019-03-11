package juego.componentes.dungeon.objetos.interactivos;

import juego.componentes.dungeon.Dungeon;
import juego.componentes.jugador.Jugador;

public class Puerta extends ObjetoInteractivo {
    //Atributos
    private String idEstancia;
    private boolean desbloqueada;

    //Constructora
    public Puerta (String pNombre, String pIdEstancia){
        super();
        this.idEstancia = pIdEstancia;
        this.desbloqueada = false;
    }

    //Otros metodos
    @Override
    public void interactuar(Jugador pJugador) {

    }

    private void cambiarEstancia(){
        Dungeon.getDungeon().cambiarEstanciaActual(this.idEstancia);
    }
    private void debloquear(){
        this.desbloqueada = true;
    }
}
