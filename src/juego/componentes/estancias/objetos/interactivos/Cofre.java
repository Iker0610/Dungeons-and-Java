package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.recogibles.ObjetoRecolectable;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class Cofre extends ObjetoInteractivo {
    //Esta clase englobarÃ¡ todos los objetos de los que se puedan sacar objetos recogibles.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private ArrayList<ObjetoRecolectable> lista;
    private boolean desbloqueado;

    //Constructora
    public Cofre (String pDir){
        super();
        this.lista = new ArrayList<>();
    }

    //Metodos de interaccion
    public void anadirObjeto (ObjetoRecolectable pObjeto){
        this.lista.add(pObjeto);
    }

    private Iterator<ObjetoRecolectable> getIterator(){
        return this.lista.iterator();
    }

    private int numObj(){
        return this.lista.size();
    }

    protected void interactuar(Jugador pJugador) {

    }
    
    private void desbloquear(){
    	this.desbloqueado=true;
    }

    
    //Annade el objeto en la posición especificada si existe, y sino no (no peto)
    private void darObjetoAPersonaje(Jugador pJugador, int pPosObjeto){
    	Iterator<ObjetoRecolectable> itr=this.getIterator();
    	boolean found=false;
    	int i=0;
    	ObjetoRecolectable objetoActual=null;
    	while (itr.hasNext() && !found){
    		objetoActual=itr.next();
    		i=i+1;
    		found=(pPosObjeto==i);
    	}
    	if (objetoActual!=null){
    		pJugador.anadirObjetoRecolectable(objetoActual);
    	}
    }

    //Metodos relacionados con al arraylist
    private void eliminarObjeto(ObjetoRecolectable pObjeto){

    }

    private void imprimirContenido(){
    	//TODO
    }
}
