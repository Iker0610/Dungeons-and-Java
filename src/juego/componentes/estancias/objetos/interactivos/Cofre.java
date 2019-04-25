package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.recolectables.ObjetoRecolectable;
import juego.herramientas.LectorConsola;
import juego.componentes.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class Cofre extends ObjetoInteractivo {
    //Esta clase englobará todos los objetos de los que se puedan sacar objetos recolectables.
    //Aunque se llama cofre sucede como la clase puerta, puede ser cualquier cosa: una mesa, un cofre, una caja, un agujero...

    //Atributos
    private ArrayList<ObjetoRecolectable> lista;
    private boolean desbloqueado;

    //Constructora
    public Cofre (String pDir){
        this.lista = new ArrayList<>();
        this.desbloqueado=false;
        //TODO
    }

    //Metodos de interaccion
    public void anadirObjeto (ObjetoRecolectable pObjeto){
        if(!this.lista.contains(pObjeto)) {
			this.lista.add(pObjeto);
		}
    }

    private Iterator<ObjetoRecolectable> getIterador(){
        return this.lista.iterator();
    }

    private int numObj(){
        return this.lista.size();
    }

    protected void interactuar(Jugador pJugador) {
		if (!this.desbloqueado){
			this.desbloqueado = this.comprobarCondiciones(pJugador);
			System.out.println("Se ha desbloqueado!");
		}
		if(desbloqueado){
			boolean finTurno = false;
			while (this.numObj()!=0 && !finTurno) {
				System.out.println("Elige que objeto recoger:");
				this.imprimirContenido();
				System.out.println("0- Salir");
				System.out.println();
				System.out.print("->");
				int pos = LectorConsola.getLectorConsola().leerOpcionNum(0, this.numObj()) - 1;
				System.out.println();
				if(pos !=0) {
					this.darObjetoAPersonaje(pJugador, pos);
					if(this.numObj()!=0){
						System.out.println("¿Deseas seguir cogiendo objetos del cofre?");
						if(!LectorConsola.getLectorConsola().leerBoolean()){
							finTurno=true;
						}
					}
					else{System.out.println("Parece que ya no queda nada que recoger");}
				}
				else{finTurno=true;}
			}
		}
		else {System.out.println("Vaya!! Parece que está bloqueado y no cumples los requisitos para desbloquearlo.");}
	}
    
    //Annade el objeto en la posicion especificada si existe, y sino no (no peta)
    private void darObjetoAPersonaje(Jugador pJugador, int pPosObjeto){
		ObjetoRecolectable objetoBuscado = this.lista.get(pPosObjeto);
		pJugador.anadirObjetoRecolectable(objetoBuscado);
		this.eliminarObjeto(objetoBuscado);
    }

    //Metodos relacionados con al arraylist
    private void eliminarObjeto(ObjetoRecolectable pObjeto){
    	this.lista.remove(pObjeto);
    }

    private void imprimirContenido(){
    	System.out.println("Contenido del cofre:");
    	if(this.numObj()!=0) {
			Iterator<ObjetoRecolectable> itr = this.getIterador();
			int i = 0;
			while (itr.hasNext()) {
				i++;
				System.out.println();
				System.out.print(i);
				System.out.print("- ");
				itr.next().mostrarInfo();
			}
		}
    	else {System.out.println("Vacío");}
    }
}
