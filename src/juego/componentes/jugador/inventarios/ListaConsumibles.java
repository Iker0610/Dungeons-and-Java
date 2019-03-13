package juego.componentes.jugador.inventarios;

import juego.componentes.estancias.objetos.recogibles.Consumible;

import java.util.*;

public class ListaConsumibles {
    //atributos
    private ArrayList<Consumible> lista;

    //constructora
    public ListaConsumibles(){
        lista = new ArrayList<Consumible>();
    }

    //Otros Metodos

    public void anadirConsumible (Consumible pConsumible){
        this.lista.add(pConsumible);
    }
    private Iterator<Consumible> getIterator(){
        return this.lista.iterator();
    }
}
