package juego;

import juego.componentes.jugador.Jugador;
import juego.componentes.jugador.Mago;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {

    //Atributos
    private static ListaJugadores listaJugadores;
    private ArrayList<Jugador> lista;
    private Jugador jugadorActual;

    //Constructora
    private ListaJugadores(){
        lista = new ArrayList<>();
    }

    //Patrón singleton
    public static ListaJugadores getListaJugadores (){
        if (listaJugadores == null){
            listaJugadores = new ListaJugadores();
        }
        return listaJugadores;
    }

    //Metodo para añadir jugadores
    public void generarJugador(){
        String nombre=null;
        String sexo=null;
        String raza=null;
        String clase=null;
        Jugador jugador=null;

        //////////////////////////////////////////////////////////
        //TODO
        //Comandos de in/out para recopilar los datos del jugador
        //////////////////////////////////////////////////////////

        switch (clase){
            case "mago":
                jugador = new Mago(nombre,sexo,raza);
        }

        if (jugador != null) {
            this.lista.add(jugador);
        }
    }

    //Metodos datos del arraylist
    private Iterator<Jugador> getIterator(){
        return this.lista.iterator();
    }

    public int numJugadores(){
        return this.lista.size();
    }

    //Metodos de control
    public void acabarTurno(){
        //TODO
    }

    public void eliminarJugador (Jugador pJugador){
        //TODO
    }

}