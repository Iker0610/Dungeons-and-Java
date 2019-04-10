package juego.componentes.estancias.objetos.recolectables;

import juego.herramientas.ListaStat;

public class PiezaArmadura extends ObjetoRecolectable {

	//atributos
	private String tipo;
	private ListaStat lista;

	//constructora
	public PiezaArmadura(String pNombre, String pDescripcion, String pTipo, int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		super(pNombre, pDescripcion);
		this.tipo = pTipo;
		this.lista = new ListaStat(pFuerza,pDefensa,pInteligencia,pDestreza);
	}

	//otros metodos

	public String getTipo() {
		return (this.tipo);
	}

	public ListaStat anadirStatsPieza(ListaStat pLStats){
		pLStats.sumarStats(this.lista);
		return pLStats;
	}
	
	@Override
	public void mostrarInfo(){
		super.mostrarInfo();
	}
	
}
