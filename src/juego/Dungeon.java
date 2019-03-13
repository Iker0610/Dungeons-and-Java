package juego;

import juego.componentes.estancias.Estancia;

import java.util.ArrayList;
import java.util.Iterator;

public class Dungeon {

    //Atributos
    private static Dungeon dungeon;
    private ArrayList<Estancia> lEstancias;
    private Estancia estanciaActual;

    //Constructora
    private Dungeon(){
        lEstancias = new ArrayList<>();
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Patron singleton
    public static Dungeon getDungeon() {
        if (dungeon==null){
            dungeon=new Dungeon();
        }
        return dungeon;
    }

    //Otros metodos
    public void cambiarEstancia(String pIdEstancia){

    }

    private Iterator<Estancia> getIterator(){
        return this.lEstancias.iterator();
    }
}
