package juego.componentes.dungeon.objetos.recogibles;

public class Consumible extends ObjetoRecogible {

    //atributos
    private int valor;

    //Constructora
    public Consumible (String pNombre, int pValor){
        super(pNombre);
        this.valor = pValor;
    }

    //Otros metodos
    public void consumir (){

    }

}
