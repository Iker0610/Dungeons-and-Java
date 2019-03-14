package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.Dungeon;
import juego.componentes.jugador.Jugador;

public class Puerta extends ObjetoInteractivo {
    //Atributos
    private String idEstancia;
    private boolean desbloqueada;

    //Constructora
    public Puerta (String pNombre, String pIdEstancia){
        super();
        this.idEstancia = pIdEstancia;
        this.desbloqueada = false;
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Otros metodos
    public void interactuar(Jugador pJugador) {

    }

    private void cambiarEstancia(){
        Dungeon.getDungeon().cambiarEstancia(this.idEstancia);
    }

    private void debloquear(){
        this.desbloqueada = true;
    }
    
    private void mostrarInfo(){
    	super();
    }
    
}
