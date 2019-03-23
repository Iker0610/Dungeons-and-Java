package juego.componentes.estancias.objetos.interactivos.condiciones.string;

import juego.componentes.estancias.objetos.interactivos.condiciones.Condicion;
import juego.componentes.jugador.Jugador;

public abstract class CondicionString extends Condicion {
    //Atributos
    protected String valorNecesario;

    //Constructora
    protected CondicionString(String pValorNecesario){
        super();
    }
}
