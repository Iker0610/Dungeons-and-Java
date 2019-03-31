package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.interactivos.condiciones.numericas.CondicionDado;
import juego.componentes.herramientas.ListaStat;
import juego.componentes.jugador.Jugador;

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
    }

    private void darBienvenida(){
        //TODO
    }

    private void imprimirFraseVictoria(){
        //TODO
    }

    private void imprimirFraseDerrota(){
        //TODO
    }
    
    private void imprimirRechazo(){
        //TODO
    }

    private void pruebaFinal(){
        //TODO
    }

    private void derrotarJefe(){
        //TODO
    }
    
    private void derrotarJugador() {
    	//TODO
    }
}
