package juego.componentes.jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {

    //Atributos
    private static ListaJugadores listaJugadores;
    private ArrayList<Jugador> lista;

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

        if (jugador != null) {
        }
            this.lista.add(jugador);
        }
    }

    //Metodos datos del arraylist
    private Iterator<Jugador> getIterator(){
        return this.lista.iterator();
    }

    private int numJugadores(){
        return this.lista.size();
    }

    //Metodos de control
    public Jugador getSiguienteJugador(Jugador pJugadorActual){
        //TODO
    }

    public void eliminarJugador (Jugador pJugador){
        //TODO
    }

    private void gameOver(){
        //TODO
    }
}
