package juego.componentes.dungeon.objetos.recogibles;

import juego.componentes.herramientas.ListaStat;

public class PiezaArmadura extends ObjetoRecogible {

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
