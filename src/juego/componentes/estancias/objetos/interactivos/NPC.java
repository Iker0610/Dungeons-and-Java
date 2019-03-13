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
    public NPC(String pNombre){
        super();
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Otros metodos
    @Override
    public void interactuar(Jugador pJugador) {}

    private void bienvenida(){}
    private void mostrarPista(){}
    private void mostrarRechazo(){}

}
