package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.NPC;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaNPCs {
	//atributos
	private ArrayList<NPC> lista;
	
	//constructora
	public ListaNPCs(String pDir, int pNumNPCs){
		this.lista=new ArrayList<>();

		for (int i = 1; i <= pNumNPCs; i++){
			this.lista.add(new NPC(pDir+"npc"+i+ File.separator));
		}
	}

	//Metodos de administracion de listas
	private Iterator<NPC> getIterator(){
		return this.lista.iterator();
	}

	public boolean administrarMenuSecundario(Jugador pJugador){
		boolean finTurno=false;

		this.mostrarNPCs();
		System.out.println("0- Volver atrás");

		int input=LectorConsola.getLectorConsola().leerOpcionNum(0, this.lista.size());
		System.out.println();

		if(input!=0){
			finTurno=this.acercarseANPC(input,pJugador);
		}
		return finTurno;
	}

	private void mostrarNPCs(){
		Iterator<NPC> itr=this.getIterator();
		System.out.println("Elementos disponibles:");
		int cont = 1;
		while(itr.hasNext()){
			System.out.print(cont+"- ");
			itr.next().imprimirNombre();
			cont++;
		}
	}

	private boolean acercarseANPC(int posNPC, Jugador pJugador){
		NPC npcSelec = this.lista.get(posNPC-1);
		return npcSelec.acercarse(pJugador);
	}
}