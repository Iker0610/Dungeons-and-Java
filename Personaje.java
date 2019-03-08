package principal;

public abstract class Personaje {
	//atributos
	private String nombre;
	private String sexo;
	private String raza;
	private ListaStat lstats;
	private Armadura armadura;
	private ListaConsumibles lConsumibles;
	private Estado estado;
	//constructora
	public Personaje(String pRaza, ListaStat pLStats, Armadura pArmadura){
		this.raza=pRaza;
		this.lstats=pLStats;
		this.armadura=pArmadura;
	}
	
	//otros metodos
}
