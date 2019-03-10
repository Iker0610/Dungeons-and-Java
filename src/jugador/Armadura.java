package jugador;

import jugador.equipamiento.*;

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

	public Armadura(Casco pCasco, Pechera pPechera, Pantalones pPantalones, Arma pArma){
		this.casco=pCasco;
		this.pechera = pPechera;
		this.pantalones = pPantalones;
		this.arma = pArma;
	}

	//Otros Metodos

	public void anadirEquipamiento (Equipamiento pEquipamiento){
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
}
