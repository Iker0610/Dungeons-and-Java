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
        //TODO
    }

    //Otros metodos
    
    @Override
    protected void interactuar(Jugador pJugador) {
    	this.darBienvenida();
    	if (this.comprobarCondiciones(pJugador)){
    		this.mostrarPista();
    	}
    	else{
    		this.mostrarRechazo();
    	}
    }

    private void darBienvenida(){
    	if (this.primerEncuentro){
    		System.out.println(primeraBienvenida);
    		this.primerEncuentro=false;
    	}
    	else{
    		System.out.println(bienvenidaPosterior);
    	}
    }
    private void mostrarPista(){
    	System.out.println(pista);
    }

    private void mostrarRechazo(){
    	if (this.primerEncuentro){
    		System.out.println(this.primerRechazo);
    		this.primerEncuentro=false;
    	}
    	else{
    		System.out.println(this.rechazoPosterior);
    	}
    }
}
