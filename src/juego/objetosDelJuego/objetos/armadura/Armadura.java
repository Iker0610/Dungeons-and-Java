package juego.objetosDelJuego.objetos.armadura;

import juego.objetosDelJuego.stats.ListaStat;
import juego.objetosDelJuego.objetos.armadura.equipamiento.*;

public class Armadura {

	//Atributos
	private Casco casco;
	private Pechera pechera;
	private Pantalones pantalones;
	private Arma arma;

	//Constructora
	public Armadura(){
		this.casco=null;
		this.pechera = null;
		this.pantalones = null;
		this.arma = null;
	}

	//Otros Metodos

	public void cambiarEquipamiento (PiezaArmadura pPiezaArmadura){
		if (pPiezaArmadura instanceof Casco){
			this.cambiarCasco((Casco)pPiezaArmadura);
		}

		else if (pPiezaArmadura instanceof Pechera){
			this.cambiarPechera((Pechera)pPiezaArmadura);
		}

		else if (pPiezaArmadura instanceof Pantalones){
			this.cambiarPantalones((Pantalones)pPiezaArmadura);
		}

		else if (pPiezaArmadura instanceof Arma){
			this.cambiarArma((Arma)pPiezaArmadura);
		}
	}

	private void cambiarCasco(Casco pCasco) {
		this.casco = pCasco;
	}
	private void cambiarPechera(Pechera pPechera) {
		this.pechera = pPechera;
	}
	private void cambiarPantalones(Pantalones pPantalones) {
		this.pantalones = pPantalones;
	}
	private void cambiarArma(Arma pArma) {
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
