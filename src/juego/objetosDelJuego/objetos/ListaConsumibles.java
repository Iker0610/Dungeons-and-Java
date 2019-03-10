package juego.objetosDelJuego.objetos;

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
}
