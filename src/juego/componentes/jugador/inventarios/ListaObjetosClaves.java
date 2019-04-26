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
    	Iterator<ObjetoClave> itr = this.getIterator();
        boolean enc = false;
        while(itr.hasNext()&& !enc){
        	enc=itr.next().tieneEsteNombre(pNombre);
        }
        return enc;
    }
    public void imprimirObjClaves(){
        Iterator<ObjetoClave> itr=this.getIterator();
        System.out.println("Inventario de objetos clave:");
        if(this.lista.size()>0){
            while(itr.hasNext()){
                itr.next().mostrarInfo();
                System.out.println();
            }
        }
        else {System.out.println("Vacío");}
        System.out.println();
    }
}
