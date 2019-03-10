package juego.objetosDelJuego.objetos.equipamiento;

import juego.objetosDelJuego.objetos.ListaStat;

public abstract class PiezaArmadura {
	//atributos
	protected String nombre;
	protected ListaStat lista;
	//constructora
	protected PiezaArmadura(String pNombre, int pVida, int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		this.nombre = pNombre;
		this.lista = new ListaStat(pVida, pFuerza,pDefensa,pInteligencia,pDestreza);
	}

	public ListaStat getStats(){
		return this.lista;
	}
	//otros metodos
	
}
