package juego.componentes.jugador;

import juego.componentes.estancias.objetos.recogibles.ObjetoClave;
import juego.componentes.estancias.objetos.recogibles.ObjetoRecolectable;
import juego.componentes.jugador.inventarios.Armadura;
import juego.componentes.estancias.objetos.recogibles.PiezaArmadura;
import juego.componentes.jugador.inventarios.ListaObjetosClaves;
import juego.componentes.herramientas.ListaStat;

public class Jugador {

	//atributos
	private String nombre;
	private String sexo;
	private String raza;
	private String clase;
	private ListaStat lstats;
	private Armadura armadura;
	private ListaObjetosClaves lObjClave;

	//constructora
	public Jugador(String pNombre, String pSexo, String pRaza){
		this.nombre = pNombre;
		this.sexo = pSexo;
		this.raza = pRaza;
		this.cargarStatsBase();
		this.armadura = new Armadura();
		lObjClave = new ListaObjetosClaves();

	}

	//Metodos abstractos que cada clase ha de implementar
	private  void crearArmaduraBasica (){
		//TODO
	}
	private  void cargarStatsClase (){
		//TODO
	}

	//Metodos comunes a todas las clases
	private void cargarStatsBase (){
		//TODO
	}

	//Metodos relacionados con adquirir objetos recolectables
	public void anadirObjetoRecojible (ObjetoRecolectable pObjeto){
		if (pObjeto instanceof ObjetoClave){
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

	private void anadirObjetoClave (ObjetoClave pObjClave){
		this.lObjClave.anadirObjeto(pObjClave);
	}


	//Metodos de inventario
	public boolean tieneObjClave (String pNombreObjClave){
		//TODO
	}


	//Metodos de informacion
	public boolean esDeRaza(String pRaza){
		//TODO
	}

	public boolean esDeClase(String pClase){
		//TODO
	}

	public boolean esDeSexo(String pSexo){
		//TODO
	}

	public int getStat(String pStat){
		//TODO
	}

	//Metodos para imprimir la información de los inventarios
	public void imprimirInformacionJugador(){
		//TODO
	}

	private void imprimirDatosArmadura(){
		//TODO
	}

	private void imprimirObjClave(){
		//TODO
	}
}
