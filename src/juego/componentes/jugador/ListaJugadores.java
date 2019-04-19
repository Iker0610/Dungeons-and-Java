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

    //Patr�n singleton
    public static ListaJugadores getListaJugadores (){
        if (listaJugadores == null){
            listaJugadores = new ListaJugadores();
        }
        return listaJugadores;
    }

    //Metodo para anadir jugadores
    public void generarJugador(){
    	//Hay que editarlo
    	LectorConsola lector= LectorConsola.getLectorConsola();
        lector.leerString();
        String nombre;
        String sexo=null;
        String raza=null;
        String clase=null;

        boolean sexoOk=false;
        boolean claseOk=false;
        boolean razaOk=false;
        boolean todoOk=false;

        System.out.println("Introduzca su nombre");
        nombre=lector.leerString();
        do{
        	if(!sexoOk){
        		try{
        		System.out.println("Introduzca su sexo");
        		sexo=lector.leerOpcionString();
        		sexoOk=true;
        		}
        		catch(ExcepcionFormatoIncorrecto excepcionSexo){
        			System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
        			this.generarJugador();
        		}
        	}
        	if(!razaOk){
        		try{
                    //TODO
            		System.out.println("Elija su raza");
            		raza=lector.leerOpcionString();
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
            		clase=lector.leerOpcionString();
            		claseOk=true;
            	}
            	catch(ExcepcionFormatoIncorrecto excepcionSexo){
            		System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
            		this.generarJugador();
            	}
        	}
        	if(sexoOk && razaOk && claseOk){
        		todoOk=true;
        	}
        
        }while(!todoOk);

		lista.add(new Jugador(nombre, sexo, raza, clase));
		this.numJugadoresVivos++;
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
        Jugador jugadorAct;
        int cont=0;
        while(itr.hasNext()){
        	jugadorAct=itr.next();
        	if(jugadorAct.estaVivo()){
        		cont++;
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
    	this.numJugadoresVivos--;
    	if(this.numJugadoresVivos()==0){
    		this.gameOver();
    	}
    }

    private void gameOver(){
        Partida.getPartida().finalizarPartida(false);
    }
}
