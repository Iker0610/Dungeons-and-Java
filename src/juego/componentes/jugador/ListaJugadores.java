package juego.componentes.jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {

    //Atributos
    private static ListaJugadores listaJugadores;
    private ArrayList<Jugador> lista;
    private int posJugadorAct;
    private int numJugadoresVivos;

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
        //////////////////////////////////////////////////////////}
    }

    //Metodos datos del arraylist
    private Iterator<Jugador> getIterator(){
        return this.lista.iterator();
    }

    private int numJugadoresTotal(){
        return this.lista.size();
    }

    private int numJugadoresVivos(){
        //TODO
    }

    //Metodos de control
    public Jugador getSiguienteJugador(){
        int posAct = this.posJugadorAct;
        if (this.numJugadoresVivos != 1){
            boolean encVivo = false;
            while (!encVivo){
                if (posAct==(this.numJugadoresTotal()-1)){
                    posAct=0;
                }
                else { posAct++; }

                encVivo=this.lista.get(posAct).estaVivo();
            }
        }
        this.posJugadorAct = posAct;
        return this.lista.get(posAct);
    }

    public void eliminarJugador (Jugador pJugador){
        //TODO
    }

    private void gameOver(){
        //TODO
    }
}
