package juego.objetosDelJuego.dungeon.objetos.interactuables;

import juego.objetosDelJuego.dungeon.objetos.recojibles.ObjetosRecojibles;

import java.util.ArrayList;

public class Cofre extends ObjetosInteractuables {
    //Esta clase englobará todos los objetos de los que se puedan sacar objetos recojibles.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private String nombre;
    private ArrayList<ObjetosRecojibles> lista;

    //Constructora
    public Cofre (String pNombre){
        this.nombre = pNombre;
        this.lista = new ArrayList<>();
    }

    //Otros metodos
    public void anadirObjeto (ObjetosRecojibles pObjeto){
        this.lista.add(pObjeto);
    }
}
