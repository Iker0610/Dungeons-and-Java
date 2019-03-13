package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Npc;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaNPCs {
	//atributos
	private ArrayList<Npc> lista;
	
	//constructora
	public ListaNPCs(){
		
	}

	//Metodos de administracion de listas
	private Iterator<Npc> getIterator(){
		return this.lista.iterator();
	}

	public void anadirNPC(){
		//TODO
	}

	//Metodos imprimir informacion
	public void mostrarNPCs(){
		//TODO
	}

	public void mostrarInformacionNPC(int posNpc){
		//TODO
	}
	
}
