package juego.componentes.estancias;

import java.util.ArrayList;
import java.util.Iterator;

import juego.Partida;

public class Dungeon {

    //Atributos
    private static Dungeon dungeon;
    private ArrayList<Estancia> lEstancias;

    //Constructora
    private Dungeon(){
        lEstancias = new ArrayList<>();
        //TODO
    }

    //Patron singleton
    public static Dungeon getDungeon() {
        if (dungeon==null){
            dungeon=new Dungeon();
        }
        return dungeon;
    }

    //Metodos arraylist
    private Iterator<Estancia> getIterator(){
        return this.lEstancias.iterator();
    }

    private Estancia buscarEstancia(String pIdEstancia){
        Iterator<Estancia> itr=getIterator();
        Estancia estanciaPos=null;
        boolean chivato=false;
        while (itr.hasNext()&&!chivato){
        	estanciaPos=itr.next();
        	chivato=estanciaPos.tieneEsteId(pIdEstancia);
        }
        return estanciaPos;
    }

    //Otros metodos
    public void cambiarEstancia(String pIdEstancia){
    	Partida.getPartida().cambiarEstancia(this.buscarEstancia(pIdEstancia));
    }
}
