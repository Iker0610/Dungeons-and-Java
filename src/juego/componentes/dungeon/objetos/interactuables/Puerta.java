package juego.componentes.dungeon.objetos.interactuables;

import juego.componentes.dungeon.Dungeon;
import juego.componentes.jugador.Jugador;

public class Puerta extends ObjetoInteractuable {
    //Atributos
    private String idEstancia;

    //Constructora
    public Puerta (String pNombre, String pIdEstancia){
        super();
        this.idEstancia = pIdEstancia;
    }

    //Otros metodos
    @Override
    public void interactuar(Jugador pJugador) {

    }

    private void cambiarEstancia(){
        Dungeon.getDungeon().cambiarEstanciaActual(this.idEstancia);
    }
}
