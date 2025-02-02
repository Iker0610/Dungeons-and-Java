package juego;

import juego.componentes.estancias.Dungeon;
import juego.componentes.estancias.Estancia;
import juego.componentes.jugador.Jugador;
import juego.componentes.jugador.ListaJugadores;
import juego.herramientas.LectorConsola;

public class Partida {
    //Atributos
    private boolean finPartida;
    private static Partida partida;
    private Jugador jugadorActual;
    private Estancia estanciaActual;

    //Constructora
    private Partida (){
        this.finPartida = false;
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
        partida = new Partida();
        System.out.println("DUNGEONS & JAVA");
        System.out.print("*Pulsa enter para aventurarte en una mazmorra*");
        LectorConsola.getLectorConsola().leerString();
        System.out.println();
        partida.generarDungeon();
        partida.crearJugadores();
        partida.jugarPartida();
    }


    //Metodos generacion y jugar partida
    private void generarDungeon(){
        Dungeon.getDungeon();
    }

    private void crearJugadores(){
        boolean jugadoresListos = false;
        int numJugadores = 0;
        while(!jugadoresListos && (numJugadores<=0 || numJugadores<5)) {
            ListaJugadores.getListaJugadores().generarJugador();
            numJugadores++;
            System.out.println("¿Hay más jugadores que deseen aventurarse en esta aventura?");
            jugadoresListos = !LectorConsola.getLectorConsola().leerBoolean();
            System.out.println();
        }
        this.getSiguienteJugador();
    }

    private void jugarPartida(){
        boolean finTurno;
        while (!finPartida){
            System.out.print("Turno de: ");
            this.jugadorActual.imprimirNombre();
            finTurno = estanciaActual.administrarMenuPrincipal(jugadorActual);
            if(finTurno){
                this.getSiguienteJugador();
            }
        }
    }

    //Mtodos de control
    public void finalizarPartida(boolean pVictoria){
        this.finPartida = true;
        if (pVictoria){
            System.out.println("Habéis logrado derrotar al jefe de esta mazmorra.");
            System.out.println("ENHORABUENA!!!");
        }
        else{
            System.out.println("GAME OVER");
        }
    }

    private void getSiguienteJugador(){
        this.jugadorActual = ListaJugadores.getListaJugadores().getSiguienteJugador();
    }

    public void cambiarEstancia(Estancia pEstancia){
        if (pEstancia!=null){
            this.estanciaActual = pEstancia;
            System.out.print("Se ha accedido a ");
            this.estanciaActual.imprimirInfoEstancia();
        }
    }
}
