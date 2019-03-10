package objetosDelJuego.jugador;

import objetosDelJuego.jugador.equipamiento.*;

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

	public void anadirEquipamiento (PiezaArmadura pPiezaArmadura){
		//TODO
		//El objetivo es que pasado un objeto de tipo equipamiento sepa de si fue creado como casco, arma y demás
		// y se llame al metodo cambiarX corrspondiente
	}

	public void cambiarCasco(Casco pCasco) {
		this.casco = pCasco;
	}
	public void cambiarPechera(Pechera pPechera) {
		this.pechera = pPechera;
	}
	public void cambiarPantalones(Pantalones pPantalones) {
		this.pantalones = pPantalones;
	}
	public void cambiarArma(Arma pArma) {
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
