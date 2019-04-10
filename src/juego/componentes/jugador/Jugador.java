package juego.componentes.jugador;

import juego.componentes.estancias.objetos.recogibles.ObjetoClave;
import juego.componentes.estancias.objetos.recogibles.ObjetoRecolectable;
import juego.componentes.jugador.inventarios.Armadura;
import juego.componentes.estancias.objetos.recogibles.PiezaArmadura;
import juego.componentes.jugador.inventarios.ListaObjetosClaves;
import juego.herramientas.ListaStat;

public class Jugador {

	//atributos
	private String nombre;
	private String sexo;
	private String raza;
	private String clase;
	private ListaStat lStats;
	private Armadura armadura;
	private ListaObjetosClaves lObjClave;
	private boolean vivo;

	//constructora
	public Jugador(String pNombre, String pSexo, String pRaza){
		this.nombre = pNombre;
		this.sexo = pSexo;
		this.raza = pRaza;
		this.cargarStatsBase();
		this.crearArmaduraBasica();
		lObjClave = new ListaObjetosClaves();

	}

	//Metodos abstractos que cada clase ha de implementar
	private  void crearArmaduraBasica (){
		//TODO
	}
	
	private void cargarStatsBase (){
		//TODO
	}

	//Metodos relacionados con adquirir objetos recolectables
	public void anadirObjetoRecolectable (ObjetoRecolectable pObjeto){
		if (pObjeto instanceof ObjetoClave){
			this.anadirObjetoClave((ObjetoClave)pObjeto);
		}
		else if (pObjeto instanceof PiezaArmadura){
			this.actualizarArmadura((PiezaArmadura)pObjeto);
		}
	}

	private void actualizarArmadura (PiezaArmadura pPieza){
		this.lStats.restarStats(armadura.getArmorStats());
		this.armadura.cambiarEquipamiento(pPieza);
		this.lStats.sumarStats(armadura.getArmorStats());
	}

	private void anadirObjetoClave (ObjetoClave pObjClave){
		this.lObjClave.anadirObjClave(pObjClave);
	}


	//Metodos de inventario
	public boolean tieneObjClave (String pNombreObjClave){
		return this.lObjClave.estaObjClave(pNombreObjClave);
	}


	//Metodos de informacion
	public boolean esDeRaza(String pRaza){
		return (pRaza==this.raza);
	}

	public boolean esDeClase(String pClase){
		return (pClase==this.clase);
	}

	public boolean esDeSexo(String pSexo){
		return (pSexo==this.sexo);
	}

	public int getStat(String pStat){
		return this.lStats.getValorStat(pStat);
	}

	public boolean estaVivo(){
		return this.vivo;
	}
	public void morirse(){
		this.vivo=false;
	}

	//Metodos para imprimir la información de los inventarios
	public void imprimirInformacionJugador(){
		System.out.println(this.nombre);
		this.lStats.imprimirStats();
	}
}
