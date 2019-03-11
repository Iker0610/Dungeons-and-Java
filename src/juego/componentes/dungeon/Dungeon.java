package juego.componentes.dungeon;

import java.util.ArrayList;

public class Dungeon {
    private static Dungeon dungeon;
    private ArrayList<Estancia> lEstancias;
    private Estancia estanciaActual;

    //Constructora
    private Dungeon(){

    }
    //Patron singleton

    public static Dungeon getDungeon() {
        if (dungeon==null){
            dungeon=new Dungeon();
        }
        return dungeon;
    }
}