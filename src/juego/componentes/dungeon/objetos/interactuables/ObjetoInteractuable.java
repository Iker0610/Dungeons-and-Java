package juego.componentes.dungeon.objetos.interactuables;

import juego.componentes.jugador.Jugador;

public abstract class ObjetoInteractuable {

    //Atributos
    private String nombre;
    private String descripcion;
    private String tipoCondicion;
    private String valorCondicion;
    private boolean desbloqueado;

    //Constructora
    protected ObjetoInteractuable(){
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
