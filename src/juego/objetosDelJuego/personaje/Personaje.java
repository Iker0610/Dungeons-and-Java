package juego.objetosDelJuego.personaje;

import juego.objetosDelJuego.objetos.*;
import juego.objetosDelJuego.objetos.armadura.Armadura;
import juego.objetosDelJuego.stats.ListaStat;

public abstract class Personaje {

	//atributos
	protected String nombre;
	protected String sexo;
	protected String raza;
	protected ListaStat lstats;
	protected Armadura armadura;
	protected ListaConsumibles lConsumibles;

	//constructora
	protected Personaje(String pNombre, String pSexo,String pRaza){
		this.nombre = pNombre;
		this.sexo = pSexo;
		this.raza = pRaza;
		lConsumibles = new ListaConsumibles();
		this.cargarStatsBase();
	}

	//Metodos abstractos
	protected abstract Armadura crearArmaduraBasica ();
	protected abstract void cargarStatsClase ();

	//otros metodos
	private void cargarStatsBase (){
		switch (this.raza){

			case "humano":
				this.lstats = new ListaStat(500,40,40,40,2);
			break;

			case "elfo":
				this.lstats = new ListaStat(500,40,40,40,2);
			break;

			case "orco":
				this.lstats = new ListaStat(500,40,40,40,2);
			break;

			case "enano":
				this.lstats = new ListaStat(500,40,40,40,2);
			break;

			case "hobbit":
				this.lstats = new ListaStat(500,40,40,40,2);
			break;
		}
	}
}
