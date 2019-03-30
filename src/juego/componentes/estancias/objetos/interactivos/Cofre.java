package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.recogibles.ObjetoRecolectable;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class Cofre extends ObjetoInteractivo {
    //Esta clase englobará todos los objetos de los que se puedan sacar objetos recogibles.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private ArrayList<ObjetoRecolectable> lista;
    private boolean desbloqueado;

    //Constructora
    public Cofre (String pDir){
        super();
        this.lista = new ArrayList<>();
    }

    //Metodos de interaccion
    public void anadirObjeto (ObjetoRecolectable pObjeto){
        this.lista.add(pObjeto);
    }

    private Iterator<ObjetoRecolectable> getIterator(){
        return this.lista.iterator();
    }

    private int numObj(){
        //TODO
    }

    protected void interactuar(Jugador pJugador) {

    }

    private void desbloquear(){

    }

    private void darObjetoAPersonaje(Jugador pJugador, int pPosObjeto){

    }

    //Metodos relacionados con al arraylist
    private void eliminarObjeto(ObjetoRecolectable pObjeto){

    }

    private void imprimirContenido(){
    	//TODO
    }
}
