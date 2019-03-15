package juego.componentes.jugador.inventarios;

import juego.componentes.estancias.objetos.recogibles.ObjetoClave;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaObjetosClaves {

    //Atributos
    private ArrayList<ObjetoClave> lista;

    //Constructora
    public ListaObjetosClaves(){ lista = new ArrayList<ObjetoClave>(); }

    //Metodos de gestion del arraylist
    private Iterator<ObjetoClave> getIterator(){
        return this.lista.iterator();
    }

    public void anadirObjeto (ObjetoClave pObjeto){
        this.lista.add(pObjeto);
    }

    public boolean estaObjClave(String pNombre){
        //TODO
    }
    public void imprimirObjClaves(){
        //TODO
    }


}
