package juego.componentes.dungeon.objetos.interactivos;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoInteractivo {

    //Atributos
    private String nombre;
    private String descripcion;
    private String tipoCondicion;
    private String valorCondicion;
    private boolean desbloqueado;

    //Constructora
    protected ObjetoInteractivo(){
        this.desbloqueado = false;
    }

    //Otros metodos
    public void acercarse (){
        System.out.println(this.descripcion);
    }

    public abstract void interactuar (Jugador pJugador);

    private boolean comprobarCondicion(Jugador pJugador){
        boolean seCumple = false;
        return seCumple;
    }

    private void debloquear(){
        this.desbloqueado = true;
    }
}
