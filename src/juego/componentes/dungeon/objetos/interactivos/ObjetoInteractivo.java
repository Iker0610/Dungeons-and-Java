package juego.componentes.dungeon.objetos.interactivos;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoInteractivo {

    //Atributos
    private String nombre;
    private String descripcion;
    //Condicion que ha de cumplir el Jugador para desbloquer la interaccion
    private String tipoCondicion;
    private String valorCondicion;
    //En caso de puertas y demás booleano que sierve para

    //Constructora
    protected ObjetoInteractivo(){}

    //Otros metodos
    public void acercarse (){
        System.out.println(this.descripcion);
    }

    public abstract void interactuar (Jugador pJugador);

    private boolean comprobarCondicion(Jugador pJugador){
        boolean seCumple = false;
        return seCumple;
    }


}
