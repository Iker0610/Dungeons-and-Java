package juego.componentes.estancias.objetos.recogibles;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoRecolectable {
    //Atributos
    private String nombre;
    private String descripcion;

    //Constructora
    protected ObjetoRecolectable(String pNombre, String pDescripcion){
        //TODO
    }

    //Otros metodos
    public void mostrarInfo(){
        System.out.println(this.nombre);
        //TODO
    }
}
