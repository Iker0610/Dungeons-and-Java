package juego.componentes.estancias.objetos.interactivos;

import juego.Partida;
import juego.componentes.estancias.Dungeon;
import juego.componentes.estancias.objetos.interactivos.condiciones.numericas.CondicionDado;
import juego.componentes.herramientas.ListaStat;
import juego.componentes.jugador.Jugador;
import juego.componentes.jugador.ListaJugadores;

public class JefeFinal extends ObjetoInteractivo{
    //Atributos

    private String nombre;
    private CondicionDado pruebaFinal;
    
    //Frases de interaccion
    private String fraseBienvenida;
    private String fraseRechazo;
    private String fraseDerrota;
    private String fraseVictoria;

    //Constructora
    public JefeFinal (String pDir){
        //TODO
    }

    //Metodos de interaccion
    @Override
    protected void interactuar(Jugador pJugador) {
    	//TODO
        this.darBienvenida();
        if (this.comprobarCondiciones(pJugador)){
        	if (this.pruebaFinal.cumpleLaCondicion(pJugador)){
        		
        	}
        }
    }

    private void darBienvenida(){
    	System.out.println(this.fraseBienvenida);
    }

    private void imprimirFraseVictoria(){
        System.out.println(this.fraseVictoria);
    }

    private void imprimirFraseDerrota(){
        System.out.println(this.fraseDerrota);
    }
    
    private void imprimirRechazo(){
    	System.out.println(this.fraseRechazo);
    }

    private void pruebaFinal(){
        //TODO
    }

    private void derrotarJefe(){
        this.imprimirFraseDerrota();
        Partida.getPartida().finalizarPartida(true);
    }
    
    private void derrotarJugador(Jugador pJugador) {
    	ListaJugadores.getListaJugadores().eliminarJugador(pJugador);
    }
}
