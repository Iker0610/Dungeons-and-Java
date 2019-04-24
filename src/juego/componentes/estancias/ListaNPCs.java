package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.NPC;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaNPCs {
	//atributos
	private ArrayList<NPC> lista;
	
	//constructora
	public ListaNPCs(){
		this.lista=new ArrayList<>();
	}

	//Metodo de carga de datos
	private void cargarDatos (String pDireccionFichero){
		//TODO
	}

	//Metodos de administracion de listas
	private Iterator<NPC> getIterator(){
		return this.lista.iterator();
	}

	private void anadirNPC(NPC pNPC){
		Iterator<NPC> itr=this.getIterator();
		NPC npc=null;
		boolean enc=false;
		while(!enc&&itr.hasNext()){
			npc=itr.next();
			if(npc.equals(pNPC)){
				enc=true;
			}
		}
		if(!enc){
			this.lista.add(pNPC);
		}
	}

	//Metodos imprimir informacion
	public boolean administrarMenuSecundario(Jugador pJugador){
		this.mostrarNPCs();
		boolean resultado=false;
		int input;

		LectorConsola lector=LectorConsola.getLectorConsola();

		input=lector.leerOpcionNum(0, this.lista.size());

		if(input!=0){
			resultado=this.acercarseANPC(input,pJugador);
		}
		return resultado;
	}

	private void mostrarNPCs(){
		Iterator<NPC> itr=this.getIterator();
		NPC npc=null;
		while(itr.hasNext()){
			npc=itr.next();
			npc.imprimirNombre();
		}
	}

	private boolean acercarseANPC(int posNPC, Jugador pJugador){
		Iterator<NPC> itr=this.getIterator();
		NPC npc=null;
		boolean enc=false;
		boolean resultado=false;
		int cont=0;
		while(!enc){
			npc=itr.next();
			cont=cont+1;
			if(cont==posNPC){
				enc=true;
			}
		}
		resultado=npc.acercarse(pJugador);
		return resultado;
	}
}
