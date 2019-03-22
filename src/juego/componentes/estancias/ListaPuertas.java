package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Puerta;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPuertas {
    //Atributos
    private ArrayList<Puerta> lista;

    //Constructora
    public ListaPuertas(){
        this.lista = new ArrayList<>();
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Metodos de administracion de listas
    private Iterator<Puerta> getIterator(){
        return this.lista.iterator();
    }

    private void anadirPuerta(Puerta pPuerta){
        //TODO
    }

    //Metodos de imprimir informacion
    public void mostrarPuertas(){
        //TODO
    }

    public void acercarseAPuerta(int posPuerta){
        //TODO
    }

    private Puerta obtenerPuertaPorPosicion(int pPos){
        //TODO
    }


}
