package juego.objetosDelJuego.personajes.jugador;

import juego.objetosDelJuego.objetos.armadura.Armadura;
import juego.objetosDelJuego.objetos.armadura.equipamiento.PiezaArmadura;
import juego.objetosDelJuego.objetos.consumibles.ListaConsumibles;
import juego.objetosDelJuego.objetos.objetosClave.ListaObjetosClaves;
import juego.objetosDelJuego.stats.ListaStat;

public abstract class Jugador {

	//atributos
	protected String nombre;
	protected String sexo;
	protected String raza;
	protected ListaStat lstats;
	protected Armadura armadura;
	protected ListaConsumibles lConsumibles;
	protected ListaObjetosClaves lObjClave;

	//constructora
	protected Jugador(String pNombre, String pSexo, String pRaza){
		this.nombre = pNombre;
		this.sexo = pSexo;
		this.raza = pRaza;
		lConsumibles = new ListaConsumibles();
		lObjClave = new ListaObjetosClaves();
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

	public void actualizarArmadura (PiezaArmadura pPieza){
		this.lstats.restarStats(armadura.getArmorStats());
		this.armadura.cambiarEquipamiento(pPieza);
		this.lstats.sumarStats(armadura.getArmorStats());
	}
}
