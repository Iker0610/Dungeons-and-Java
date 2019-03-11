package juego.componentes.herramientas;

public class ListaStat {

	//atributos
	private int vida;
	private int fuerza;
	private int defensa;
	private int inteligencia;
	private int destreza;

	//constructora
	public ListaStat(int pVida, int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		this.vida=pVida;
		this.fuerza=pFuerza;
		this.defensa=pDefensa;
		this.inteligencia=pInteligencia;
		this.destreza=pDestreza;
	}
	
	//otros metodos
	public void sumarStats(ListaStat pLStats){
		this.vida += pLStats.vida;
		this.fuerza += pLStats.fuerza;
		this.defensa += pLStats.defensa;
		this.inteligencia += pLStats.inteligencia;
		this.destreza += pLStats.destreza;
	}

	public void restarStats(ListaStat pLStats){
		this.vida -= pLStats.vida;
		this.fuerza -= pLStats.fuerza;
		this.defensa -= pLStats.defensa;
		this.inteligencia -= pLStats.inteligencia;
		this.destreza -= pLStats.destreza;
	}

	public int getVida() {
		return vida;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getDestreza() {
		return destreza;
	}
}
