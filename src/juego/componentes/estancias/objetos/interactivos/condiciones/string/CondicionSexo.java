package juego.componentes.estancias.objetos.interactivos.condiciones.string;

import juego.componentes.jugador.Jugador;

public class CondicionSexo extends CondicionString {

    //Constructora
    public CondicionSexo(String pValorNecesario){
        super(pValorNecesario);
    }

    //Metodos
    public boolean cumpleLaCondicion(Jugador pJugador){
    	return pJugador.esDeSexo(this.getValorNecesario());
    }
}
