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
		//post: los stats de la lista parametro se han sumado a la lista invocadora
		this.lStats.put("Fuerza",this.lStats.get("Fuerza")+pLStats.getValorStat("Fuerza"));
		this.lStats.put("Defensa",this.lStats.get("Defensa")+pLStats.getValorStat("Defensa"));
		this.lStats.put("Inteligencia",this.lStats.get("Inteligencia")+pLStats.getValorStat("Inteligencia"));
		this.lStats.put("Destreza",this.lStats.get("Destreza")+pLStats.getValorStat("Destreza"));
	}

	public void restarStats(ListaStat pLStats){
		//post: los stats de la lista parametro se han restado a la lista invocadora
		this.lStats.put("Fuerza",this.lStats.get("Fuerza")-pLStats.getValorStat("Fuerza"));
		this.lStats.put("Defensa",this.lStats.get("Defensa")-pLStats.getValorStat("Defensa"));
		this.lStats.put("Inteligencia",this.lStats.get("Inteligencia")-pLStats.getValorStat("Inteligencia"));
		this.lStats.put("Destreza",this.lStats.get("Destreza")-pLStats.getValorStat("Destreza"));
	}

	public int getValorStat(String pStat) {
		//TODO
	}

	public void imprimirStats(){
		//TODO
	}
}
