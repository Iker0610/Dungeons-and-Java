package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.NPC;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaNPCs {
	//atributos
	private ArrayList<NPC> lista;
	
	//constructora
	public ListaNPCs(){
		this.lista=new ArrayList<>();
	}

	//Metodos de administracion de listas
	private Iterator<NPC> getIterator(){
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
