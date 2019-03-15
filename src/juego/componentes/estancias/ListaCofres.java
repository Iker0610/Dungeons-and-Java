package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Cofre;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCofres {
	//atributos
	private ArrayList<Cofre> lista;
	
	//constructora
	public ListaCofres(){
		this.lista=new ArrayList<>();
	}

	//Metodo de carga de datos
	private void cargarDatos (String pDireccionFichero){
		//TODO
	}

	//Metodos de administracion de listas
	private Iterator<Cofre> getIterator(){
		return this.lista.iterator();
	}

	public void anadirCofre(Cofre pCofre){
		//TODO
	}
	
	public void eliminarCofre(Cofre pCofre){
		//TODO
	}

	//Metodos para mostrar informacion
	public void mostrarCofres(){
		//TODO
	}

	public void acercarseACofre(int posCofre){
		//TODO
	}

	public void interactuarConCofre(int posCofre, Jugador pJugador){
		//TODO
	}
	
}
