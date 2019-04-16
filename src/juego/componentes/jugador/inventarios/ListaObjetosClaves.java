package juego.componentes.jugador.inventarios;

import juego.componentes.estancias.objetos.recolectables.ObjetoClave;

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

    public void anadirObjClave (ObjetoClave pObjeto){
        this.lista.add(pObjeto);
    }

    public boolean estaObjClave(String pNombre){
    	Iterator<ObjetoClave> itr=this.getIterator();
        ObjetoClave objetoActual=null;
        boolean enc=false;
        while(itr.hasNext()||!enc){
        	objetoActual=itr.next();
        	enc=objetoActual.tieneEsteNombre(pNombre);
        	}
        return enc;
    }
    public void imprimirObjClaves(){
        Iterator<ObjetoClave> itr=this.getIterator();
        ObjetoClave objetoActual=null;
        while(itr.hasNext()){
        	objetoActual=itr.next();
        	objetoActual.mostrarInfo();
        }
    }


}
