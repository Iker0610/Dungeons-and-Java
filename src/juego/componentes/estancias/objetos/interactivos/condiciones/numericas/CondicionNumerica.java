package juego.componentes.estancias.objetos.interactivos.condiciones.numericas;

import juego.componentes.estancias.objetos.interactivos.condiciones.Condicion;
import juego.componentes.jugador.Jugador;

public abstract class CondicionNumerica extends Condicion {
    //Atributos
	private int valorMinimo;
    //Constructora
    protected CondicionNumerica(int pValorMinimo){
        super();
    }
    protected int getValorMinimo(){
    	return this.valorMinimo;
    }
}
