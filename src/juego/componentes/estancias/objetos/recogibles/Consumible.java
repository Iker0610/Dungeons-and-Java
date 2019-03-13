package juego.componentes.estancias.objetos.recogibles;

public class Consumible extends ObjetoRecolectable {

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
