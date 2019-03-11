package juego.componentes.jugador;

import juego.componentes.dungeon.objetos.recojibles.ObjetoClave;
import juego.componentes.dungeon.objetos.recojibles.ObjetoRecojible;
import juego.componentes.jugador.inventarios.Armadura;
import juego.componentes.dungeon.objetos.recojibles.PiezaArmadura;
import juego.componentes.dungeon.objetos.recojibles.Consumible;
import juego.componentes.jugador.inventarios.ListaConsumibles;
import juego.componentes.jugador.inventarios.ListaObjetosClaves;
import juego.componentes.stats.ListaStat;

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

	//Metodos abstractos que cada clase ha de implementar

	protected abstract Armadura crearArmaduraBasica ();
	protected abstract void cargarStatsClase ();

	//Metodos comunes a todas las clases

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

	//Metodos relacionados con adquirir objetos recojibles

	public void anadirObjetoRecojible (ObjetoRecojible pObjeto){
		if (pObjeto instanceof Consumible){
			this.anadirConsumible((Consumible)pObjeto);
		}
		else if (pObjeto instanceof ObjetoClave){
			this.anadirObjetoClave((ObjetoClave)pObjeto);
		}
		else if (pObjeto instanceof PiezaArmadura){
			this.actualizarArmadura((PiezaArmadura)pObjeto);
		}
	}
	private void actualizarArmadura (PiezaArmadura pPieza){
		this.lstats.restarStats(armadura.getArmorStats());
		this.armadura.cambiarEquipamiento(pPieza);
		this.lstats.sumarStats(armadura.getArmorStats());
	}

	private void anadirConsumible (Consumible pConsumible){
		this.lConsumibles.anadirConsumible(pConsumible);
	}

	private void anadirObjetoClave (ObjetoClave pObjClave){
		this.lObjClave.anadirObjeto(pObjClave);
	}
}
