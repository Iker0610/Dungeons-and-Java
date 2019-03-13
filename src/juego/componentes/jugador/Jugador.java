package juego.componentes.jugador;

import juego.componentes.dungeon.objetos.recogibles.ObjetoClave;
import juego.componentes.dungeon.objetos.recogibles.ObjetoRecolectable;
import juego.componentes.jugador.inventarios.Armadura;
import juego.componentes.dungeon.objetos.recogibles.PiezaArmadura;
import juego.componentes.dungeon.objetos.recogibles.Consumible;
import juego.componentes.jugador.inventarios.ListaConsumibles;
import juego.componentes.jugador.inventarios.ListaObjetosClaves;
import juego.componentes.herramientas.ListaStat;

public abstract class Jugador {

	//atributos
	protected int vidaActual;
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
		this.vidaActual=this.lstats.getVida();
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

	//Metodos relacionados con adquirir objetos recolectables
	public void anadirObjetoRecojible (ObjetoRecolectable pObjeto){
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

	public void usarConsumible (String pNombre){

	}

	//Metodos de inventario
	public boolean tieneObjClave (String pNombreObjClave){
		boolean esta = false;
		return esta;
	}

	//Metodos para imprimir la información de los inventarios
	public void imprimirDatosArmadura(){}

	public void imprimirConsumibles(){}

	public void imprimirObjClave(){}
}
