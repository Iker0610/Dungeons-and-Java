package juego.componentes.dungeon.objetos.recojibles;

import juego.componentes.dungeon.objetos.recojibles.ObjetoRecojible;
import juego.componentes.stats.ListaStat;

public class PiezaArmadura extends ObjetoRecojible {

	//atributos
	private String tipo;
	private ListaStat lista;

	//constructora
	public PiezaArmadura(String pTipo, String pNombre, int pVida, int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		super(pNombre);
		this.tipo = pTipo;
		this.lista = new ListaStat(pVida, pFuerza,pDefensa,pInteligencia,pDestreza);
	}

	//otros metodos

	public String getTipo() {
		return tipo;
	}

	public ListaStat getStats(){
		return this.lista;
	}

}
