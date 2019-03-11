package juego.componentes.dungeon.objetos.interactuables;

import juego.componentes.dungeon.objetos.recojibles.ObjetoRecojible;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;

public class Cofre extends ObjetoInteractuable {
    //Esta clase englobará todos los objetos de los que se puedan sacar objetos recojibles.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private ArrayList<ObjetoRecojible> lista;

    //Constructora
    public Cofre (String pNombre){
        super();
        this.lista = new ArrayList<>();
    }

    //Otros metodos
    public void anadirObjeto (ObjetoRecojible pObjeto){
        this.lista.add(pObjeto);
    }

    public void interactuar(Jugador pJugador) {}
}
