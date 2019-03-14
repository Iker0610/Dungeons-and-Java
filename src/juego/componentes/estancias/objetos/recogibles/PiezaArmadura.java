package juego.componentes.estancias.objetos.recogibles;

import juego.componentes.herramientas.ListaStat;

public class PiezaArmadura extends ObjetoRecolectable {

	//atributos
	private String tipo;
	private ListaStat lista;

	//constructora
	public PiezaArmadura(){
		super();
		//TODO
	}
	public PiezaArmadura(String pTipo, String pNombre, int pVida, int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		super();
		this.tipo = pTipo;
		this.lista = new ListaStat(pVida, pFuerza,pDefensa,pInteligencia,pDestreza);
	}

	//Metodo cargar datos
	private void cargarDatos(){
		//TODO
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
