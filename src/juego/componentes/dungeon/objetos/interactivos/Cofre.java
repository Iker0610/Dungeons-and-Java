package juego.componentes.dungeon.objetos.interactivos;

import juego.componentes.dungeon.objetos.recogibles.ObjetoRecogible;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class Cofre extends ObjetoInteractivo {
    //Esta clase englobará todos los objetos de los que se puedan sacar objetos recogibles.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private ArrayList<ObjetoRecogible> lista;

    //Constructora
    public Cofre (String pNombre){
        super();
        this.lista = new ArrayList<>();
    }

    //Otros metodos
    public void anadirObjeto (ObjetoRecogible pObjeto){
        this.lista.add(pObjeto);
    }

    public void interactuar(Jugador pJugador) {

    }


    private void darObjetoAPersonaje(Jugador pJugador, int posObjeto){

    }

    private void retirarObjeto(){

    }

    private Iterator<ObjetoRecogible> getIterator(){
        return this.lista.iterator();
    }
}
