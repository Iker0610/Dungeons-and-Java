package juego.componentes.estancias.objetos.recogibles;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoRecolectable {
    //Atributos
    private String nombre;
    private String descripcion;

    //Constructora
    protected ObjetoRecolectable(){
        //TODO
    }

    //Metodo cargar datos
    private void cargarDatos(){
        //TODO
    }

    //Otros metodos
    public void recoger (Jugador pJugador){
        pJugador.anadirObjetoRecojible(this);
        //TODO
    }

    public void mostrarInfo(){
        System.out.println(this.nombre);
        //TODO
    }
}
