package jugador.personaje;

import jugador.Armadura;
import jugador.ListaConsumibles;
import jugador.ListaStat;

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
	}

	//otros metodos
	protected abstract Armadura crearArmaduraBasica ();
	protected abstract void cargarStatsBase ();
}
