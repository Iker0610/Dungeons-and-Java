package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.jugador.Jugador;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class NPC extends ObjetoInteractivo {
    //Atributos
    private String pista;
    private String primeraBienvenida;
    private String bienvenidaPosterior;
    private String primerRechazo;
    private String rechazoPosterior;
    private boolean primerEncuentro;

    //Constructora
    public NPC(String pDir){
    	super(pDir);
    	this.primerEncuentro=true;
        String dirData = pDir+"data_npc.txt";
		try {
			InputStream fichData = new FileInputStream(dirData);
			Scanner sc = new Scanner(fichData);
			String lineaAct;

			//Dato de pista
			lineaAct = sc.nextLine();
			if(lineaAct.matches("pista&(.*)")){
				this.pista = lineaAct.split("&")[1];
			}
			else{throw new ExcepcionFormatoIncorrecto();}

			//Dato de primeraBienvenida
			lineaAct = sc.nextLine();
			if(lineaAct.matches("primeraBienvenida&(.*)")){
				this.primeraBienvenida = lineaAct.split("&")[1];
			}
			else{throw new ExcepcionFormatoIncorrecto();}

			//Dato de bienvenidaPosterior
			lineaAct = sc.nextLine();
			if(lineaAct.matches("bienvenidaPosterior&(.*)")){
				this.bienvenidaPosterior = lineaAct.split("&")[1];
			}
			else{throw new ExcepcionFormatoIncorrecto();}

			//Dato de primerRechazo
			lineaAct = sc.nextLine();
			if(lineaAct.matches("primerRechazo&(.*)")){
				this.primerRechazo = lineaAct.split("&")[1];
			}
			else{throw new ExcepcionFormatoIncorrecto();}

			//Dato de rechazoPosterior
			lineaAct = sc.nextLine();
			if(lineaAct.matches("rechazoPosterior&(.*)")){
				this.rechazoPosterior = lineaAct.split("&")[1];
			}
			else{throw new ExcepcionFormatoIncorrecto();}

			//Se cierra el escanner
			sc.close();
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

    //Otros metodos
    
    @Override
    protected void interactuar(Jugador pJugador) {
    	this.darBienvenida();
    	if (this.comprobarCondiciones(pJugador)){
    		this.mostrarPista();
    	}
    	else{
    		this.mostrarRechazo();
    	}
		this.primerEncuentro=false;
    }

    private void darBienvenida(){
    	if (this.primerEncuentro){
    		System.out.println(primeraBienvenida);
    	}
    	else{
    		System.out.println(bienvenidaPosterior);
    	}
    }
    private void mostrarPista(){
    	System.out.println(pista);
    }

    private void mostrarRechazo(){
    	if (this.primerEncuentro){
    		System.out.println(this.primerRechazo);
    	}
    	else{
    		System.out.println(this.rechazoPosterior);
    	}
    }
}
