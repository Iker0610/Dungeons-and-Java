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

	private void anadirCofre(Cofre pCofre){
		//TODO
	}

	//Metodos para mostrar informacion
	public boolean administrarMenuSecundario(Jugador pJugador){
		//TODO
	}

	private void mostrarCofres(){
		//TODO
	}

	private boolean acercarseACofre(int posCofre){
		//TODO
	}

	private Cofre obtenerCofrePorPosicion(int pPos){
		//TODO
	}
	
}
