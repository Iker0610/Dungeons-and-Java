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
    public Cofre (String pNombre){
        super();
        this.lista = new ArrayList<>();
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Metodos de interaccion
    protected void interactuar(Jugador pJugador) {

    }

    private void darObjetoAPersonaje(Jugador pJugador, int pPosObjeto){

    }

    //Metodos relacionados con al arraylist
    public void anadirObjeto (ObjetoRecolectable pObjeto){
        this.lista.add(pObjeto);
    }

    private void retirarObjeto(ObjetoRecolectable pObjeto){

    }

    private Iterator<ObjetoRecolectable> getIterator(){
        return this.lista.iterator();
    }

    private void imprimirContenido(){
    	//TODO
    }
    private void desbloquear(){

    }
    private int getSeleccionDelJugador(){
        //TODO
    }

    private ObjetoRecolectable obtenerObjetoPorPosicion(int pPos){
        //TODO
    }
}
