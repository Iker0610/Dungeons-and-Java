package juego.objetosDelJuego.objetos.armadura.equipamiento;

import juego.objetosDelJuego.stats.ListaStat;

public class PiezaArmadura {

	//atributos
	private String tipo;
	private String nombre;
	private ListaStat lista;

	//constructora
	public PiezaArmadura(String pTipo, String pNombre, int pVida, int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		this.tipo = pTipo;
		this.nombre = pNombre;
		this.lista = new ListaStat(pVida, pFuerza,pDefensa,pInteligencia,pDestreza);
	}

	//otros metodos

	public ListaStat getStats(){
		return this.lista;
	}

	public String getTipo() {
		return tipo;
	}
}
