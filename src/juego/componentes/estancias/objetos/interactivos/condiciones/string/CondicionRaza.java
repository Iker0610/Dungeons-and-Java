package juego.componentes.estancias.objetos.interactivos.condiciones.string;

import juego.componentes.jugador.Jugador;

public class CondicionRaza extends CondicionString {

    //Constructora
    public CondicionRaza(String pValorNecesario){
        super(pValorNecesario);
    }

    //Metodos
    public boolean cumpleLaCondicion(Jugador pJugador){
    	return pJugador.esDeRaza(this.getValorNecesario());
    }
}
