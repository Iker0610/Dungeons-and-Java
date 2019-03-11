package juego.componentes.dungeon.objetos.recojibles;

import juego.componentes.dungeon.objetos.recojibles.ObjetoRecojible;

public class Consumible extends ObjetoRecojible {

    //atributos
    private int valor;

    //Constructora
    public Consumible (String pNombre, int pValor){
        super(pNombre);
        this.valor = pValor;
    }

    //Otros metodos

}
