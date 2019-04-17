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
        do{
        	try{
        		lector.leerOpcionNum(1, this.lista.size());
        	}
        	catch(ExcepcionFormatoIncorrecto excepcionFormato){
        		System.out.println("Ha introducido un caracter incorrecto, intentelo otra vez");
    			this.generarJugador();
        	}
        }
        
        
    }

    private boolean acercarseAPuerta(int posPuerta){
        //TODO
    }

}
