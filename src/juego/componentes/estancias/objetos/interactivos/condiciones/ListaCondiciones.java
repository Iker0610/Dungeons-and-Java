package juego.componentes.estancias.objetos.interactivos.condiciones;

import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;


public class ListaCondiciones {
    //Atributos
    private ArrayList<Condicion> lista;

    //constructora
    public ListaCondiciones (){
        this.lista = new ArrayList<>();
        //TODO
    }

    public boolean cumpleLasCondiciones(Jugador pJugador){
        //TODO
        return false;
    }

    //Metodos del arraylist
    private Iterator<Condicion> getIterator(){
        return this.lista.iterator();
    }

    public void anadirCondicion(Condicion pCondicion){
        //TODO
    }
}
