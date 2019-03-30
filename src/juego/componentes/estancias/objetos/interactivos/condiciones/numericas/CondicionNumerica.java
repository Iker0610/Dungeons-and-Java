package juego.componentes.estancias.objetos.interactivos.condiciones.numericas;

import juego.componentes.estancias.objetos.interactivos.condiciones.Condicion;

public abstract class CondicionNumerica extends Condicion {
    //Atributos
    protected int valorMinimo;
    //Constructora
    protected CondicionNumerica(int pValorMinimo){
        super();
    }

    protected int calcularValorFinal(int pValorNum){
        //TODO
    }
}
