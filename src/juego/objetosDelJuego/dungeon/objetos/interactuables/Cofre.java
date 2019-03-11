package juego.objetosDelJuego.dungeon.objetos.interactuables;

import juego.objetosDelJuego.dungeon.objetos.recojibles.ObjetoRecojible;

import java.util.ArrayList;

public class Cofre extends ObjetoInteractuable {
    //Esta clase englobará todos los objetos de los que se puedan sacar objetos recojibles.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private String nombre;
    private ArrayList<ObjetoRecojible> lista;

    //Constructora
    public Cofre (String pNombre){
        this.nombre = pNombre;
        this.lista = new ArrayList<>();
    }

    //Otros metodos
    public void anadirObjeto (ObjetoRecojible pObjeto){
        this.lista.add(pObjeto);
    }
}
