package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Cofre;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCofres {
	//atributos
	private ArrayList<Cofre> lista;
	
	//constructora
	public ListaCofres(){
		this.lista=new ArrayList<>();
	}

	//Metodo de carga de datos
	private void cargarDatos (String pDireccionFichero){
		//TODO
	}

	//Metodos de administracion de listas
	private Iterator<Cofre> getIterator(){
		return this.lista.iterator();
	}

	private void anadirCofre(Cofre pCofre){
		Iterator<Cofre> itr=this.getIterator();
		Cofre cofre=null;
		boolean enc=false;
		while(itr.hasNext()&&!enc){
			cofre=itr.next();
			if(cofre.equals(pCofre)){
				enc=true;
			}
		}
		if(!enc){
			this.lista.add(pCofre);
		}
	}

	//Metodos para mostrar informacion
	public boolean administrarMenuSecundario(Jugador pJugador){
		this.mostrarCofres();
		boolean resultado=false;
		int input;
		boolean todoOk=false;
		LectorConsola lector=LectorConsola.getLectorConsola();
			do{
	        	try{
	        		input=lector.leerOpcionNum(0, this.lista.size());
	        		todoOk=true;
	        	}
	        	catch(ExcepcionFormatoIncorrecto excepcionFormato){
	        		System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
	    			this.administrarMenuSecundario(pJugador);
	        	}
	        	catch(ExcepcionValorFueradDeRango excepcionRango){
	        		System.out.println("El valor introducido no se encuentra entre las opciones, intentelo otra vez");
	    			this.administrarMenuSecundario(pJugador);
	        	}
	        
	        }while(!todoOk);
			if(input!=0){
				resultado=this.acercarseACofre(input,pJugador);
			}
		return resultado;
	}

	private void mostrarCofres(){
		Iterator<Cofre> itr=this.getIterator();
		Cofre cofre=null;
		while(itr.hasNext()){
			cofre=itr.next();
			cofre.imprimirNombre();
		}
	}

	private boolean acercarseACofre(int posCofre, Jugador pJugador){
		Iterator<Cofre> itr=this.getIterator();
		Cofre cofre=null;
		int cont=0;
		boolean enc=false;
		boolean resultado=false;
		while(itr.hasNext()&&!enc){
			cofre=itr.next();
			cont=cont+1;
			if(cont==posCofre){
				enc=true;
			}
		}
		resultado=cofre.acercarse(pJugador);
		return resultado;
	}
}
