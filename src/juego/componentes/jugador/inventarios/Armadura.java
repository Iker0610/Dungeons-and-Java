package juego.componentes.jugador.inventarios;

import juego.componentes.dungeon.objetos.recojibles.PiezaArmadura;
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
		if (pPiezaArmadura.getTipo().equals("casco")){
			this.cambiarCasco(pPiezaArmadura);
		}

		else if (pPiezaArmadura.getTipo().equals("pechera")){
			this.cambiarPechera(pPiezaArmadura);
		}

		else if (pPiezaArmadura.getTipo().equals("pantalones")){
			this.cambiarPantalones(pPiezaArmadura);
		}

		else if (pPiezaArmadura.getTipo().equals("arma")){
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
