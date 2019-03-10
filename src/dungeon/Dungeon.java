package dungeon;

import java.util.ArrayList;

public class Dungeon {
    private Dungeon dungeon;
    private ArrayList<Estancia> lEstancias;

    //Constructora
    private Dungeon(){

    }
    //Patron singleton

    public Dungeon getDungeon() {
        if (dungeon==null){
            dungeon=new Dungeon();
        }
        return dungeon;
    }
}
