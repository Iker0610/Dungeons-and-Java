package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Puerta;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPuertas {
    //Atributos
    private ArrayList<Puerta> lista;

    //Constructora
    protected ListaPuertas(){
        this.lista = new ArrayList<>();
    }

    //Metodos de administracion de listas
    private Iterator<Puerta> getIterator(){
        return this.lista.iterator();
    }

    protected void anadirPuerta(){
        //TODO
    }

    //Metodos de imprimir informacion
    public void imprimirPuertas(){
        //TODO
    }


}
