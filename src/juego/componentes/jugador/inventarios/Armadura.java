package juego.componentes.jugador.inventarios;

import juego.componentes.estancias.objetos.recogibles.PiezaArmadura;
import juego.componentes.herramientas.ListaStat;

public class Armadura {

	//Atributos
	private PiezaArmadura casco;
	private PiezaArmadura pechera;
	private PiezaArmadura pantalones;
	private PiezaArmadura arma;

	//Constructora
	public Armadura(){
		this.casco=null;
		this.pechera = null;
		this.pantalones = null;
		this.arma = null;
	}

	//Otros Metodos

	public void cambiarEquipamiento (PiezaArmadura pPiezaArmadura){
		if (pPiezaArmadura.esDeEsteTipo("casco")){
			this.cambiarCasco(pPiezaArmadura);
		}

		else if (pPiezaArmadura.esDeEsteTipo("pechera")){
			this.cambiarPechera(pPiezaArmadura);
		}

		else if (pPiezaArmadura.esDeEsteTipo("pantalones")){
			this.cambiarPantalones(pPiezaArmadura);
		}

		else if (pPiezaArmadura.esDeEsteTipo("arma")){
			this.cambiarArma(pPiezaArmadura);
		}
	}

	private void cambiarCasco(PiezaArmadura pCasco) {
		this.casco = pCasco;
	}

	private void cambiarPechera(PiezaArmadura pPechera) {
		this.pechera = pPechera;
	}

	private void cambiarPantalones(PiezaArmadura pPantalones) {
		this.pantalones = pPantalones;
	}

	private void cambiarArma(PiezaArmadura pArma) {
		this.arma = pArma;
	}

	//Metodos de información
	public void imprimirDatosArmadura(){
		//TODO
	}
	public ListaStat getArmorStats(){
		ListaStat armorStats = new ListaStat(0,0,0,0,0);
		if (this.casco!= null){
			armorStats.sumarStats(this.casco.getStats());
		}
		if (this.pechera!= null){
			armorStats.sumarStats(this.pechera.getStats());
		}
		if (this.pantalones!= null){
			armorStats.sumarStats(this.pantalones.getStats());
		}
		if (this.arma!= null){
			armorStats.sumarStats(this.arma.getStats());
		}
		return armorStats;
	}
}
