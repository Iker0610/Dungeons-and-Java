package juego;

import juego.componentes.estancias.Estancia;
import juego.componentes.jugador.Jugador;
import juego.componentes.jugador.ListaJugadores;

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

    //Patron singleton
    public static Partida getPartida(){
        if (partida==null){
            partida = new Partida();
        }
        return partida;
    }

    //Main
    public static void main(String[] args) {
        //TODO
    }
    //Metodos generacion y jugar partida
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
    public void finalizarPartida(boolean pVictoria){
        this.finPartida = true;
        if (pVictoria){
            System.out.println(//TODO);
        }
        else{
            System.out.println(//TODO);
        }
    }

    private void getSiguienteJugador(){
        this.jugadorActual = ListaJugadores.getListaJugadores().getSiguienteJugador();
    }

    public void cambiarEstancia(Estancia pEstancia){

    }

    //Metodos de menu
    private void comenzarTurno(){
    	//TODO
    }
}
