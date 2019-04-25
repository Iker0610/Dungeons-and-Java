package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.Dungeon;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;
import juego.herramientas.excepciones.ExcepcionEstanciaInexistente;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Puerta extends ObjetoInteractivo {
    //Atributos
    private String idEstancia;
    private boolean desbloqueada;

    //Constructora
    public Puerta (String pDir){
        super(pDir);
        this.desbloqueada=false;
        String dirData = pDir+"data_puerta.txt";

        try {
            InputStream fichData = new FileInputStream(dirData);
            Scanner sc = new Scanner(fichData);
            String lineaAct;

            //Dato de idEstancia
            lineaAct = sc.nextLine();
            if(lineaAct.matches("idEstancia&(.*)")){
                this.idEstancia = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Se cierra el escanner
            sc.close();
        }
        catch(ExcepcionFormatoIncorrecto e){
            System.out.println("El fichero "+dirData+" no contiene el formato adecuado por lo que el juego no puede ejecutarse");
            System.exit(0);
        }
        catch(FileNotFoundException e){
            System.out.println("El fichero "+dirData+" no existe por lo que el juego no puede ejecutarse");
            System.exit(0);
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: el juego se cerrará");
            System.exit(0);
        }
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
