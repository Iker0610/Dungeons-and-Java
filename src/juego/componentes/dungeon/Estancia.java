package juego.componentes.dungeon;

import juego.componentes.dungeon.objetos.interactuables.Cofre;
import juego.componentes.dungeon.objetos.interactuables.Npc;
import juego.componentes.dungeon.objetos.interactuables.Puerta;

import java.util.ArrayList;

public class Estancia {
    private String idEstancia;
    //Listado de objetos interactuables
    private ArrayList<Puerta> listaPuertas;
    private ArrayList<Cofre> listaCofres;
    private ArrayList<Npc> listaNpc;
}
