package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.recogibles.ObjetoRecolectable;
import juego.herramientas.LectorConsola;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class Cofre extends ObjetoInteractivo {
    //Esta clase englobará todos los objetos de los que se puedan sacar objetos recogibles.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private ArrayList<ObjetoRecolectable> lista;
    private boolean desbloqueado;

    //Constructora
    public Cofre (String pDir){
        //TODO
        this.lista = new ArrayList<>();
    }

    //Metodos de interaccion
    public void anadirObjeto (ObjetoRecolectable pObjeto){
        this.lista.add(pObjeto);
    }

    private Iterator<ObjetoRecolectable> getIterador(){
        return this.lista.iterator();
    }

    private int numObj(){
        return this.lista.size();
    }

    protected void interactuar(Jugador pJugador) {
    	this.imprimirContenido();
    	int pos=LectorConsola.getLectorConsola().leerOpcion(1, this.numObj());
    	this.darObjetoAPersonaje(pJugador, pos);
    }
    
    protected void desbloquear(){
    	this.desbloqueado=true;
    }

    
    //Annade el objeto en la posici�n especificada si existe, y sino no (no peta)
    private void darObjetoAPersonaje(Jugador pJugador, int pPosObjeto){
    	Iterator<ObjetoRecolectable> itr=this.getIterador();
    	boolean found=false;
    	int i=0;
    	ObjetoRecolectable objetoActual=null;
    	while (itr.hasNext() && !found){
    		objetoActual=itr.next();
    		i=i+1;
    		found=(pPosObjeto==i);
    	}
    	if (found){
    		pJugador.anadirObjetoRecolectable(objetoActual);
    		this.eliminarObjeto(objetoActual);
    	}
    }

    //Metodos relacionados con al arraylist
    private void eliminarObjeto(ObjetoRecolectable pObjeto){
    	this.lista.remove(pObjeto);
    }

    private void imprimirContenido(){
    	System.out.println("Contenido del cofre:");
    	Iterator<ObjetoRecolectable> itr=this.getIterador();
    	ObjetoRecolectable objetoActual=null;
    	int i=0;
    	while (itr.hasNext()){
    		i++;
    		objetoActual=itr.next();
    		System.out.print(i);
    		System.out.print("- ");
    		System.out.println(objetoActual);
    	}
    	System.out.println("");
    }
}
