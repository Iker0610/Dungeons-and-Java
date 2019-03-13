package juego;

import juego.componentes.jugador.Jugador;

public class Partida {
    //Atributos
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

    //Metodos de control
    protected void finalizarPartida(){
        //TODO
    }
}
