package juego.componentes.estancias.objetos.recogibles;

import juego.componentes.herramientas.ListaStat;

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

	public boolean esDeEsteTipo(String pTipo) {
		return (this.tipo==pTipo);
	}

	public ListaStat getStats(){
		return this.lista;
	}
	
	@Override
	public void mostrarInfo(){
		super.mostrarInfo();
	}
	
}
