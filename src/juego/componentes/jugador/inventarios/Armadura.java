package juego.componentes.jugador.inventarios;

import juego.componentes.estancias.objetos.recogibles.PiezaArmadura;
import juego.herramientas.ListaStat;

public class Armadura {

	//Atributos
	private PiezaArmadura casco;
	private PiezaArmadura pechera;
	private PiezaArmadura pantalones;
	private PiezaArmadura arma;

	//Constructora
	public Armadura() {
		this.casco = null;
		this.pechera = null;
		this.pantalones = null;
		this.arma = null;
	}

	//Otros Metodos

	public void cambiarEquipamiento (PiezaArmadura pPiezaArmadura){
		String tipo = pPiezaArmadura.getTipo();
		
		switch (tipo){
			case "Casco":
				this.cambiarCasco(pPiezaArmadura);
				break;
			
			case "Pechera":
				this.cambiarPechera(pPiezaArmadura);
				break;
			
			case "Pantalones":
				this.cambiarPantalones(pPiezaArmadura);
				break;
			
			case "Arma":
				this.cambiarArma(pPiezaArmadura);
				break;
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
		ListaStat armorStats = new ListaStat(0,0,0,0);
		if (this.casco!= null){
			armorStats = this.casco.anadirStatsPieza(armorStats);
		}
		if (this.pechera!= null){
			armorStats = this.pechera.anadirStatsPieza(armorStats);
		}
		if (this.pantalones!= null){
			armorStats = this.pantalones.anadirStatsPieza(armorStats);
		}
		if (this.arma!= null){
			armorStats = this.arma.anadirStatsPieza(armorStats);
		}
		return armorStats;
	}
}
