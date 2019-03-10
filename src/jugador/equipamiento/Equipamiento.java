package jugador.equipamiento;

import jugador.ListaStat;

public class Equipamiento {
	//atributos
	protected String nombre;
	protected ListaStat lista;
	//constructora
	protected Equipamiento(String pNombre, int pVida, int pFuerza, int pDefensa, int pInteligencia, int pDestreza){
		this.nombre = pNombre;
		this.lista = new ListaStat(pVida, pFuerza,pDefensa,pInteligencia,pDestreza);
	}
	
	//otros metodos
	
}
