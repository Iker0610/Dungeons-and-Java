package juego.componentes.estancias;

import juego.herramientas.LectorConsola;
import juego.componentes.jugador.Jugador;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class EstanciaStandar extends Estancia {

    //Atributos

    //Listado de objetos interactivos
    private ListaPuertas listaPuertas;
    private ListaCofres listaCofres;
    private ListaNPCs listaNpc;

    //Constructora
    public EstanciaStandar(String pIdEstancia){
        super(pIdEstancia);
		String dirData = super.getDir()+"info.txt";
		try{
			InputStream fichData = new FileInputStream(dirData);
			Scanner sc = new Scanner(fichData);
			sc.nextLine();
			sc.nextLine();

			int numNPCs;
			int numCofres;
			int numPuertas;

			String dirNPCs = super.getDir()+"npcs"+File.separator;
			String dirCofres = super.getDir()+"cofres"+File.separator;
			String dirPuertas = super.getDir()+"puertas"+File.separator;

			String lineaAct = sc.nextLine();
			if(lineaAct.matches("NPCs&\\d\\d")) {
				numNPCs = Integer.parseInt(lineaAct);
			}
			else {throw new ExcepcionFormatoIncorrecto();}

			lineaAct = sc.nextLine();
			if(lineaAct.matches("Cofres&\\d\\d")) {
				numCofres = Integer.parseInt(lineaAct);
			}
			else {throw new ExcepcionFormatoIncorrecto();}

			lineaAct = sc.nextLine();
			if (lineaAct.matches("Puertas&\\d\\d")) {
				numPuertas = Integer.parseInt(lineaAct);
			}
			else {throw new ExcepcionFormatoIncorrecto();}

			//Se cierra el scanner
			sc.close();

			//Generación de las listas
			this.listaNpc = new ListaNPCs(dirNPCs,numNPCs);
			this.listaCofres = new ListaCofres(dirCofres,numCofres);
			this.listaPuertas = new ListaPuertas(dirPuertas,numPuertas);

		}
		catch(ExcepcionFormatoIncorrecto e){
			System.out.println("El fichero "+dirData+" no contiene el formato adecuado por lo que el juego no puede ejecutarse");
			System.exit(0);
		}
        catch(FileNotFoundException e){
			System.out.println("El fichero "+dirData+" no existe por lo que el juego no puede ejecutarse");
			System.exit(0);
		}
        catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado: el juego se cerrará");
			System.exit(0);
		}
    }

    //Metodos menú
    public boolean administrarMenuPrincipal(Jugador pJugadorActual){
    	//Imprimir opciones del jugador
    	//Imprimir opciones para acceso a las listas
    	boolean finTurno = false;
		System.out.println("Elige una acción a realizar:");
    	System.out.println("1- Mostrar informacion del jugador");
    	System.out.println("2- Seleccionar elementos interactivos");
    	System.out.println("3- Seleccionar cofres");
    	System.out.println("4- Seleccionar puertas");
		System.out.print("->");

    	int opcion = LectorConsola.getLectorConsola().leerOpcionNum(1,4);
    	if (opcion==1){
    		pJugadorActual.imprimirInformacionJugador();
    	}
    	else if (opcion==2){
    		finTurno=this.listaNpc.administrarMenuSecundario(pJugadorActual);
    	}
    	else if (opcion==3){
    		finTurno=this.listaCofres.administrarMenuSecundario(pJugadorActual);
    	}
    	else if (opcion==4){
    		finTurno=this.listaPuertas.administrarMenuSecundario(pJugadorActual);
    	}
		System.out.println();

    	return finTurno;
    }
}
