package juego.componentes.jugador;

import juego.componentes.estancias.objetos.recolectables.ObjetoClave;
import juego.componentes.estancias.objetos.recolectables.ObjetoRecolectable;
import juego.componentes.jugador.inventarios.Armadura;
import juego.componentes.estancias.objetos.recolectables.PiezaArmadura;
import juego.componentes.jugador.inventarios.ListaObjetosClaves;
import juego.herramientas.ListaStat;
import juego.herramientas.excepciones.ExcepcionClaseInexistente;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;
import juego.herramientas.excepciones.ExcepcionRazaInexistente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

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
	public Jugador(String pNombre, String pSexo, String pRaza, String pClase){
		this.vivo = true;
		this.nombre = pNombre;
		this.sexo = pSexo;
		this.raza = pRaza;
		this.clase = pClase;
		this.lStats = new ListaStat(0,0,0,0);
		this.armadura = new Armadura();
		this.cargarStatsBase();
		this.crearArmaduraBasica();
		lObjClave = new ListaObjetosClaves();

	}

	//Metodos abstractos que cada clase ha de implementar
	private void cargarStatsBase (){
		String dirRoot = System.getProperty("user.dir")+ File.separator+"recursos"+ File.separator+"ficheros"+ File.separator+"dungeons"+File.separator;
		String dirRazas = dirRoot+"razas_stats.txt";
		String dirClases = dirRoot+"clases_stats.txt";

		//Carga de los stats de Raza
		try{
			InputStream fichDataRazas = new FileInputStream(dirRazas);
			Scanner sc = new Scanner(fichDataRazas);

			String lineaAct;
			String lineaRaza=null;

			while (lineaRaza == null && sc.hasNext()){
				lineaAct = sc.nextLine();
				if (lineaAct.contains(this.raza+"&")){
					lineaRaza = lineaAct;
				}
			}
			if (lineaRaza != null && lineaRaza.matches("(.*)&\\d\\d,\\d\\d,\\d\\d,\\d\\d")){
				String[] dataStatRaza = lineaRaza.split("&")[1].split(",");
				int fuerza = Integer.parseInt(dataStatRaza[0]);
				int defensa = Integer.parseInt(dataStatRaza[1]);
				int inteligencia = Integer.parseInt(dataStatRaza[2]);
				int destreza = Integer.parseInt(dataStatRaza[3]);
				this.lStats.sumarStats(new ListaStat(fuerza,defensa,inteligencia,destreza));
			}
			else {throw new ExcepcionRazaInexistente();}
			//Se cierra el escaner
			sc.close();


			//Carga de los stats de Clase
			InputStream fichDataClases = new FileInputStream(dirClases);
			sc = new Scanner(fichDataClases);

			String lineaClase = null;
			while (lineaClase == null && sc.hasNext()){
				lineaAct = sc.nextLine();
				if (lineaAct.contains(this.clase+"&")){
					lineaClase = lineaAct;
				}
			}
			if (lineaClase != null && lineaClase.matches("(.*)&\\d\\d,\\d\\d,\\d\\d,\\d\\d")){
				String[] dataStatClase = lineaClase.split("&")[1].split(",");
				int fuerza = Integer.parseInt(dataStatClase[0]);
				int defensa = Integer.parseInt(dataStatClase[1]);
				int inteligencia = Integer.parseInt(dataStatClase[2]);
				int destreza = Integer.parseInt(dataStatClase[3]);
				this.lStats.sumarStats(new ListaStat(fuerza,defensa,inteligencia,destreza));
			}
			else {throw new ExcepcionClaseInexistente();}
			//Se cierra el escaner
			sc.close();
		}

		catch(FileNotFoundException e){
			System.out.println("No se encuentran los ficheros de datos de los stats de razas y/o clases, por lo que el juego se cerrará.");
			System.exit(0);
		}
		catch (ExcepcionRazaInexistente e){
			System.out.println("El fichero "+dirRazas+" no contiene datos sobre la raza seleccionada o tiene un formato inadecuado, por lo que el juego se cerrará.");
			System.exit(0);
		}
		catch (ExcepcionClaseInexistente e){
			System.out.println("El fichero "+dirClases+" no contiene datos sobre la clase seleccionada o tiene un formato inadecuado, por lo que el juego se cerrará.");
			System.exit(0);
		}
		catch (Exception e){
			System.out.println("Ha ocurrido un error inesperado: el juego se cerrará");
			System.exit(0);
		}
	}

	private  void crearArmaduraBasica (){
		String dirRoot = System.getProperty("user.dir")+ File.separator+"recursos"+ File.separator+"ficheros"+ File.separator+"dungeons"+File.separator;
		String dirClases = dirRoot+"clases_armadura.txt";


		//Carga de los stats de Raza
		try{
			InputStream fichDataRazas = new FileInputStream(dirClases);
			Scanner sc = new Scanner(fichDataRazas);

			String lineaAct;
			String lineaClase=null;

			while (lineaClase == null && sc.hasNext()){
				lineaAct = sc.nextLine();
				if (lineaAct.contains(this.clase+"#")){
					lineaClase = lineaAct;
				}
			}
			if (lineaClase != null){
				if( lineaClase.matches("(.*)#(.*)&(.*)&\\d\\d&\\d\\d&\\d\\d&\\d\\d#(.*)&(.*)&\\d\\d&\\d\\d&\\d\\d&\\d\\d#(.*)&(.*)&\\d\\d&\\d\\d&\\d\\d&\\d\\d")) {
					String[] dataClase = lineaClase.split("#");
					String[] pecheraData = dataClase[1].split("&");
					String[] pantalonesData = dataClase[2].split("&");
					String[] armaData = dataClase[3].split("&");

					PiezaArmadura pechera = new PiezaArmadura(pecheraData[0], pecheraData[1], Integer.parseInt(pecheraData[2]), Integer.parseInt(pecheraData[3]), Integer.parseInt(pecheraData[4]), Integer.parseInt(pecheraData[5]));
					PiezaArmadura pantalones = new PiezaArmadura(pantalonesData[0], pantalonesData[1], Integer.parseInt(pantalonesData[2]), Integer.parseInt(pantalonesData[3]), Integer.parseInt(pantalonesData[4]), Integer.parseInt(pantalonesData[5]));
					PiezaArmadura arma = new PiezaArmadura(armaData[0], armaData[1], Integer.parseInt(armaData[2]), Integer.parseInt(armaData[3]), Integer.parseInt(armaData[4]), Integer.parseInt(armaData[5]));

					this.actualizarArmadura(pechera);
					this.actualizarArmadura(pantalones);
					this.actualizarArmadura(arma);
				}
				else{throw new ExcepcionFormatoIncorrecto();}
			}
			else {throw new ExcepcionClaseInexistente();}
			//Se cierra el escaner
			sc.close();
		}
		catch (ExcepcionClaseInexistente e){
			System.out.println("El fichero "+dirClases+" no contiene datos sobre la clase seleccionada o tiene un formato inadecuado, por lo que el juego se cerrará.");
			System.exit(0);
		}
		catch (ExcepcionFormatoIncorrecto e){
			System.out.println("El fichero "+dirClases+" tiene un formato inadecuado y no se ha podido cargar, por lo que el juego se cerrará.");
			System.exit(0);
		}
		catch(FileNotFoundException e){
			System.out.println("El fichero "+dirClases+" no existe por lo que el juego no ha podido ejecutarse.");
			System.exit(0);
		}
		catch (Exception e){
			System.out.println("Ha ocurrido un error inesperado: el juego se cerrará");
			System.exit(0);
		}
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
		return (pRaza.equalsIgnoreCase(this.raza));
	}

	public boolean esDeClase(String pClase){
		return (pClase.equalsIgnoreCase(this.clase));
	}

	public boolean esDeSexo(String pSexo){
		return (pSexo.equalsIgnoreCase(this.sexo));
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
		//TODO
		System.out.println(this.nombre);
		this.lStats.imprimirStats();
	}
}
