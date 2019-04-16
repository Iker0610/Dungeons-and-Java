package juego.componentes.jugador;

import java.util.ArrayList;
import java.util.Iterator;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;
import juego.Partida;
import juego.herramientas.LectorConsola;

public class ListaJugadores {

    //Atributos
    private static ListaJugadores listaJugadores;
    private ArrayList<Jugador> lista;
    private int posJugadorAct;
    private int numJugadoresVivos;

    //Constructora
    private ListaJugadores(){
        lista = new ArrayList<>();
    }

    //Patrón singleton
    public static ListaJugadores getListaJugadores (){
        if (listaJugadores == null){
            listaJugadores = new ListaJugadores();
        }
        return listaJugadores;
    }

    //Metodo para añadir jugadores
    public void generarJugador(){
    	//Hay que editarlo
    	LectorConsola lector= LectorConsola.getLectorConsola();
        lector.leerString();
        String nombre=null;
        String sexo=null;
        String raza=null;
        String clase=null;
        
        boolean nombreOk=false;
        boolean sexoOk=false;
        boolean claseOk=false;
        boolean razaOk=false;
        boolean todoOk=false;
        do{
        	if(!nombreOk){
        		try{
        			System.out.println("Introduzca su nombre");
        			nombre=lector.leerString();
        			nombreOk=true;
        		}
        		catch(ExcepcionFormatoIncorrecto excepcionNombre){
        			System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
        			this.generarJugador();
        		}
        	}
        	if(!sexoOk){
        		try{
        		System.out.println("Introduzca su sexo");
        		sexo=lector.leerString();
        		sexoOk=true;
        		}
        		catch(ExcepcionFormatoIncorrecto excepcionSexo){
        			System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
        			this.generarJugador();
        		}
        	}
        	if(!razaOk){
        		try{
            		System.out.println("Introduzca su raza");
            		raza=lector.leerString();
            		razaOk=true;
            	}
            	catch(ExcepcionFormatoIncorrecto excepcionSexo){
            		System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
            		this.generarJugador();
            	}
        		
        	}
        	if(!claseOk){
        		try{
            		System.out.println("Introduzca su clase");
            		clase=lector.leerString();
            		claseOk=true;
            	}
            	catch(ExcepcionFormatoIncorrecto excepcionSexo){
            		System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
            		this.generarJugador();
            	}
        	}
        	if(nombreOk && sexoOk && razaOk && claseOk){
        		todoOk=true;
        	}
        
        }while(!todoOk);
		Jugador jugador=new Jugador(nombre, sexo, raza, clase);
		this.numJugadoresVivos=this.numJugadoresVivos+1;
    }

    //Metodos datos del arraylist
    private Iterator<Jugador> getIterator(){
        return this.lista.iterator();
    }

    private int numJugadoresTotal(){
        return this.lista.size();
    }

    private int numJugadoresVivos(){
        Iterator<Jugador> itr=this.getIterator();
        Jugador jugadorAct=null;
        int cont=0;
        while(itr.hasNext()){
        	jugadorAct=itr.next();
        	if(jugadorAct.estaVivo()){
        		cont=cont+1;
        	}
        }
        return cont;
    }

    //Metodos de control
    public Jugador getSiguienteJugador(){
        int posAct = this.posJugadorAct;
        if (this.numJugadoresVivos != 1){
            boolean encVivo = false;
            while (!encVivo){
                if (posAct==(this.numJugadoresTotal()-1)){
                    posAct=0;
                }
                else { posAct++; }

                encVivo=this.lista.get(posAct).estaVivo();
            }
        }
        this.posJugadorAct = posAct;
        return this.lista.get(posAct);
    }

    public void eliminarJugador (Jugador pJugador){
    	pJugador.morirse();
    	this.numJugadoresVivos=this.numJugadoresVivos-1;
    	if(this.numJugadoresVivos()==0){
    		this.gameOver();
    	}
    }

    private void gameOver(){
        Partida partida=Partida.getPartida();
        partida.finalizarPartida(false);
    }
}
