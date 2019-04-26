package juego.herramientas;

import java.util.HashMap;

public class ListaStat {

	//atributos
	private HashMap<String,Integer> lStats;

	//constructora
	public ListaStat(int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		lStats = new HashMap<>();

		if(pFuerza>100)				{pFuerza		= 100;}
		else if (pFuerza<0)			{pFuerza		= 0;}
		if(pDefensa>100)			{pDefensa		= 100;}
		else if (pDefensa<0)		{pDefensa		= 0;}
		if(pInteligencia>100)		{pInteligencia	= 100;}
		else if (pInteligencia<0)	{pInteligencia	= 0;}
		if(pDestreza>100)			{pDestreza		= 100;}
		else if (pDestreza<0)		{pDestreza		= 0;}

		lStats.put("Fuerza",pFuerza);
		lStats.put("Defensa",pDefensa);
		lStats.put("Inteligencia",pInteligencia);
		lStats.put("Destreza",pDestreza);
	}
	
	//otros metodos
	public void sumarStats(ListaStat pLStats){
		//post: los stats de la lista parametro se han sumado a la lista invocadora
		int fuerza = this.lStats.get("Fuerza")+pLStats.getValorStat("Fuerza");
		int defensa = this.lStats.get("Defensa")+pLStats.getValorStat("Defensa");
		int inteligencia = this.lStats.get("Inteligencia")+pLStats.getValorStat("Inteligencia");
		int destreza = this.lStats.get("Destreza")+pLStats.getValorStat("Destreza");

		if(fuerza>100)				{fuerza			= 100;}
		if(defensa>100)				{defensa		= 100;}
		if(inteligencia>100)		{inteligencia	= 100;}
		if(destreza>100)			{destreza		= 100;}

		this.lStats.put("Fuerza",fuerza);
		this.lStats.put("Defensa",defensa);
		this.lStats.put("Inteligencia",inteligencia);
		this.lStats.put("Destreza",destreza);
	}

	public void restarStats(ListaStat pLStats){
		//post: los stats de la lista parametro se han restado a la lista invocadora
		int fuerza = this.lStats.get("Fuerza")-pLStats.getValorStat("Fuerza");
		int defensa = this.lStats.get("Defensa")-pLStats.getValorStat("Defensa");
		int inteligencia = this.lStats.get("Inteligencia")-pLStats.getValorStat("Inteligencia");
		int destreza = this.lStats.get("Destreza")-pLStats.getValorStat("Destreza");

		if(fuerza<0)			{fuerza			= 0;}
		if(defensa<0)			{defensa		= 0;}
		if(inteligencia<0)		{inteligencia	= 0;}
		if(destreza<0)			{destreza		= 0;}

		this.lStats.put("Fuerza",fuerza);
		this.lStats.put("Defensa",defensa);
		this.lStats.put("Inteligencia",inteligencia);
		this.lStats.put("Destreza",destreza);
	}

	public int getValorStat(String pStat) {
		return this.lStats.get(pStat);
	}

	public void imprimirStats(){
		System.out.print("Stats: ");
		System.out.print("-Fuerza:"+this.lStats.get("Fuerza")+" ");
		System.out.print("-Defensa:"+this.lStats.get("Defensa")+" ");
		System.out.print("-Inteligencia:"+this.lStats.get("Inteligencia")+" ");
		System.out.println("-Destreza:"+this.lStats.get("Destreza")+" ");
	}
}
