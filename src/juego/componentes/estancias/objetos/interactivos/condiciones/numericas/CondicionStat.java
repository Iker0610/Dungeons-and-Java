package juego.componentes.estancias.objetos.interactivos.condiciones.numericas;

import juego.componentes.jugador.Jugador;

public class CondicionStat extends CondicionNumerica {
    //Atributos
    private String stat;

    //Constructora
    public CondicionStat(String pStat, int pValorMinimo){
        super(pValorMinimo);
        this.stat = pStat;
    }

    //Metodos
    public boolean cumpleLaCondicion(Jugador pJugador){
        //TODO
    }
}
