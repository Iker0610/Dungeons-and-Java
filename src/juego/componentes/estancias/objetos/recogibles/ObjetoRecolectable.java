package juego.componentes.estancias.objetos.recogibles;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoRecolectable {
    //Atributos
    protected String nombre;
    protected String descripccion;

    //Constructora
    protected ObjetoRecolectable(String pNombre, String pDescripcion){
        this.nombre = pNombre;
        this.descripcion = pDescripcion;
    }

    //Otros metodos
    public void recoger (Jugador pJugador){
        pJugador.anadirObjetoRecojible(this);
    }

    public void mostrarInfo(){
        System.out.println(this.nombre);
    }
}
