package juego.componentes.estancias;

import java.util.ArrayList;
import java.util.Iterator;

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

    private Estancia buscarEstancia (String pIdEstancia){
        //TODO
    }

    //Otros metodos
    public void cambiarEstancia(String pIdEstancia){
        //TODO
    }
}
