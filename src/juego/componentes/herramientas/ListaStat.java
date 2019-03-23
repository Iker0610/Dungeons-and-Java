package juego.componentes.herramientas;

import java.util.HashMap;

public class ListaStat {

	//atributos
	private HashMap<String,Integer> lStats;

	//constructora
	public ListaStat(int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		lStats = new HashMap<>();
		lStats.put("Fuerza",pFuerza);
		lStats.put("Defensa",pDefensa);
		lStats.put("Inteligencia",pInteligencia);
		lStats.put("Destreza",pDestreza);
	}
	
	//otros metodos
	public void sumarStats(ListaStat pLStats){
		//TODO
	}

	public void restarStats(ListaStat pLStats){
		//TODO
	}

	public int getValorStat(String pStat) {
		//TODO
	}
}
