package juego.componentes.dungeon.objetos.recojibles.consumibles;

import juego.componentes.dungeon.objetos.recojibles.ObjetoRecojible;

public class Consumible extends ObjetoRecojible {

    //atributos
    private String nombre;
    private String tipo;
    private int valor;

    //Constructora
    public Consumible (String pNombre, String pTipo, int pValor){
        this.nombre = pNombre;
        this.tipo = pTipo;
        this.valor = pValor;
    }

    //Otros metodos

}
