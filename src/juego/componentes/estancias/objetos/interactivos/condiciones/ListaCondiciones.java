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

    public boolean cumpleLasCondiciones(Jugador pJugador){
        Iterator<Condicion> itr=this.getIterator();
        Condicion condicionActual=null;
        boolean cumple=false;
        while(itr.hasNext()||cumple){
        	condicionActual=itr.next();
        	if(!condicionActual.cumpleLaCondicion(pJugador)){
        		cumple=false;
        	}
        }
        return cumple;
    }

    //Metodos del arraylist
    private Iterator<Condicion> getIterator(){
        return this.lista.iterator();
    }

    public void anadirCondicion(Condicion pCondicion){
    	Iterator<Condicion> itr=this.getIterator();
        Condicion condicionActual=null;
        boolean enc=false;
        while(itr.hasNext()||!enc){
        	condicionActual=itr.next();
        	if(condicionActual==pCondicion){
        		enc=true;
        	}
        }
        if(!enc){
        	this.lista.add(pCondicion);
        }
    }
}
