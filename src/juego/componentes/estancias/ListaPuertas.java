package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Puerta;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;
import juego.herramientas.LectorConsola;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPuertas {
    //Atributos
    private ArrayList<Puerta> lista;

    //Constructora
    public ListaPuertas(){
        this.lista = new ArrayList<>();
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Metodos de administracion de listas
    private Iterator<Puerta> getIterator(){
        return this.lista.iterator();
    }

    private void anadirPuerta(Puerta pPuerta){
        //TODO
    }

    //Metodos de imprimir informacion
    private void mostrarPuertas(){
        Iterator<Puerta> itr=this.getIterator();
        Puerta puertaActual=null;
        while(itr.hasNext()){
        	puertaActual=itr.next();
        	puertaActual.imprimirNombre();
        }
    }

    public boolean administrarMenuSecundario(Jugador pJugador){
        this.mostrarPuertas();
        LectorConsola lector=LectorConsola.getLectorConsola();
        boolean todoOk=false;
        int input;
        boolean resultado=false;
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
        if (input!=0){
        	this.acercarseAPuerta(input);
        	resultado=true;
        }
        return resultado;
    }

    private boolean acercarseAPuerta(int posPuerta){
        //TODO
    }

}
