package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.Dungeon;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;
import juego.herramientas.excepciones.ExcepcionEstanciaInexistente;

public class Puerta extends ObjetoInteractivo {
    //Atributos
    private String idEstancia;
    private boolean desbloqueada;

    //Constructora
    public Puerta (String pDir){
        this.desbloqueada=false;
        //TODO
    }

    //Otros metodos
    protected void interactuar(Jugador pJugador) {
        if (!this.desbloqueada){
        	this.desbloqueada = this.comprobarCondiciones(pJugador);
        }
        if(desbloqueada){
            this.cambiarEstancia();
        }
        else {System.out.println("Este paso está bloqueado y no cumples los requisitos para desbloquearla.");}
    }

    private void cambiarEstancia(){
        try {
            Dungeon.getDungeon().cambiarEstancia(this.idEstancia);
        }
        catch (ExcepcionEstanciaInexistente e){
            System.out.println("Vaya!! Parece que el paso ha sido bloqueado repentinamente");
            System.out.println("...");
            System.out.println("Esto podría entorpecer la aventura. ¿Deseas continuar?");
            boolean continuar = LectorConsola.getLectorConsola().leerBoolean();
            if (!continuar){
                System.out.println("Hasta la próxima!!");
                System.exit(0);
            }
        }
    }
}
