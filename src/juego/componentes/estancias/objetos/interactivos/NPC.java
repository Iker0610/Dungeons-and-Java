package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.jugador.Jugador;

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
        super();
    }

    //Otros metodos
    
    @Override
    protected void interactuar(Jugador pJugador) {}

    private void darBienvenida(){
    	
    }
    private void mostrarPista(){
    	
    }
    private void mostrarRechazo(){
    	
    }

}
