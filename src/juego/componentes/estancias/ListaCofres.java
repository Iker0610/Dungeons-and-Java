package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Cofre;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCofres {
	//atributos
	private ArrayList<Cofre> lista;
	
	//constructora
	public ListaCofres(){
		this.lista=new ArrayList<>();
	}

	//Metodos de administracion de listas
	private Iterator<Cofre> getIterator(){
		return this.lista.iterator();
	}

	public void anadirCofre(){
		//TODO
	}
	
	public void eliminarCofre(){
		//TODO
	}

	//Metodos para mostrar informacion
	public void mostrarCofres(){
		//TODO
	}

	public void mostrarInformacionCofre(int posCofre){
		//TODO
	}
	
}
