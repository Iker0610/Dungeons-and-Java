package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Cofre;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaCofres {
	//atributos
	private ArrayList<Cofre> lista;
	
	//constructora
	public ListaCofres(String pDir, int pNumCofres){
		this.lista=new ArrayList<>();

		for (int i = 1; i <= pNumCofres; i++){
			this.lista.add(new Cofre(pDir+"cofre"+i+ File.separator));
		}
	}

	//Metodos de administracion de listas
	private Iterator<Cofre> getIterator(){
		return this.lista.iterator();
	}

	public boolean administrarMenuSecundario(Jugador pJugador){
		boolean finTurno=false;
		this.mostrarCofres();
		System.out.println("0- Volver atrás");
		int input=LectorConsola.getLectorConsola().leerOpcionNum(0, this.lista.size());
		if(input!=0){
			finTurno=this.acercarseACofre(input,pJugador);
		}
		return finTurno;
	}

	private void mostrarCofres(){
		Iterator<Cofre> itr=this.getIterator();
		System.out.println("Cofres disponibles:");
		int cont = 1;
		while(itr.hasNext()){
			System.out.print(cont+"- ");
			itr.next().imprimirNombre();
			cont++;
		}
	}

	private boolean acercarseACofre(int posCofre, Jugador pJugador){
		Cofre cofreSelec = this.lista.get(posCofre-1);
		return cofreSelec.acercarse(pJugador);
	}
}