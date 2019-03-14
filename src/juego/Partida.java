package juego;

import juego.componentes.estancias.Dungeon;
import juego.componentes.jugador.Jugador;
import juego.componentes.jugador.ListaJugadores;

public class Partida {
    //Atributos
    private Dungeon dungeon;
    private ListaJugadores lJugadores;
    private Jugador jugadorActual;
    private boolean jugadoresListos;
    private boolean finPartida;
    private static Partida partida;

    //Constructora
    private Partida (){
        this.jugadoresListos = false;
        this.finPartida = false;
        //TODO
    }

    //Patron singleston
    public Partida getPartida(){
        if (partida==null){
            partida = new Partida();
        }
        return partida;
    }

    //Main
    public static void main(String[] args) {

    }

    //Metodo generacion y jugar partida
    private void generarDungeon(){
        //TODO
    }

    private void crearJugadores(){
        //TODO
    }

    private void jugarPartida(){
        //TODO
    }

    //Mtodos de control
    public void finalizarPartida(){
        //TODO
    }

    public void finalizarTurno(){
        //TODO
    }

    private Jugador getSiguienteJugador(){
        //TODO
    }

    public void cambiarEstancia(){
        //TODO
    }

    //Metodos de menu
    private void imprimirPrimerMenu(){
        //TODO
    }

    private void imprimirSubmenu(){
        //TODO
    }

    //Metodo encargado de recoger las interacciones del usuario
    private int leerOpcionMenu(){
        //TODO
    }


}
