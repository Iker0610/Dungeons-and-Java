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
    }

    //Metodos del arraylist
    private Iterator<Condicion> getIterator(){
        return this.lista.iterator();
    }

    public boolean cumpleLasCondiciones(Jugador pJugador){
        Iterator<Condicion> itr=this.getIterator();
        boolean cumple = true;
        while(itr.hasNext()&& cumple){
        	cumple = itr.next().cumpleLaCondicion(pJugador);
        }
        return cumple;
    }

    public void anadirCondicion(Condicion pCondicion){
        this.lista.add(pCondicion);
    }
}
