package juego;

import juego.componentes.estancias.Estancia;
import juego.componentes.jugador.Jugador;

public class Partida {
    //Atributos
    private boolean jugadoresListos;
    private boolean finPartida;
    private static Partida partida;
    private Jugador jugadorActual;
    private Estancia estanciaActual;

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
        //TODO
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

    private Jugador getSiguienteJugador(){
        //TODO
    }

    public void cambiarEstancia(){
        //TODO
    }

    //Metodos de menu
    public void comenzarTurno(){
    	//TODO
    }
    
}
