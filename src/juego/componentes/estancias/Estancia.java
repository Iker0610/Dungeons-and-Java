package juego.componentes.estancias;

import juego.componentes.jugador.Jugador;

public abstract class Estancia {

    //Atributos
    private String idEstancia;

    //Constructora
    protected Estancia (String pIdEstancia){
        this.idEstancia = pIdEstancia;
    }

    //Metodo de carga de datos
    protected abstract void cargarDatos (String pDir);

    //Metodos menú
    public abstract boolean administrarMenuPrincipal(Jugador pJugadorActual);

    public boolean tieneEsteId(String pId){
        return (this.idEstancia.equals(pId));
    }
}
