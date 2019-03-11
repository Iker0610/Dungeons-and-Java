package juego.componentes.dungeon;

import juego.componentes.dungeon.objetos.interactivos.Cofre;
import juego.componentes.dungeon.objetos.interactivos.Npc;
import juego.componentes.dungeon.objetos.interactivos.Puerta;

import java.util.ArrayList;

public class Estancia {

    //Atributos
    private String idEstancia;

    //Listado de objetos interactivos
    private ArrayList<Puerta> listaPuertas;
    private ArrayList<Cofre> listaCofres;
    private ArrayList<Npc> listaNpc;

    //Constructora
    protected Estancia (String pIdEstancia){
        this.idEstancia = pIdEstancia;
    }


}
