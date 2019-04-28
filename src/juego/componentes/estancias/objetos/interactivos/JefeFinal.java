package juego.componentes.estancias.objetos.interactivos;

import juego.Partida;
import juego.componentes.estancias.objetos.interactivos.condiciones.numericas.CondicionDado;
import juego.componentes.jugador.Jugador;
import juego.componentes.jugador.ListaJugadores;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class JefeFinal extends ObjetoInteractivo{
    //Atributos
    private CondicionDado pruebaFinal;
    
    //Frases de interaccion
    private String fraseBienvenida;
    private String fraseRechazo;
    private String fraseAceptacion;
    private String fraseDerrota;
    private String fraseVictoria;
    private boolean desbloqueado;

    //Constructora
    public JefeFinal (String pDir){
        super(pDir);
        this.desbloqueado=false;
        String dirData = pDir+"data_jefeFinal.txt";

        try {
            InputStream fichData = new FileInputStream(dirData);
            Scanner sc = new Scanner(fichData);
            String lineaAct;

            //Dato de fraseBienvenida
            lineaAct = sc.nextLine();
            if(lineaAct.matches("fraseBienvenida&(.*)")){
                this.fraseBienvenida = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Dato de fraseRechazo
            lineaAct = sc.nextLine();
            if(lineaAct.matches("fraseRechazo&(.*)")){
                this.fraseRechazo = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Dato de fraseAceptacion
            lineaAct = sc.nextLine();
            if(lineaAct.matches("fraseAceptacion&(.*)")){
                this.fraseAceptacion = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Dato de fraseDerrota
            lineaAct = sc.nextLine();
            if(lineaAct.matches("fraseDerrota&(.*)")){
                this.fraseDerrota = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Dato de fraseVictoria
            lineaAct = sc.nextLine();
            if(lineaAct.matches("fraseVictoria&(.*)")){
                this.fraseVictoria = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Dato de pruebaFinal
            lineaAct = sc.nextLine();
            if(lineaAct.matches("pruebaFinal#\\d\\d")){
                this.pruebaFinal=new CondicionDado(Integer.parseInt(lineaAct.split("#")[1]));
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

    //Metodos de interaccion
    @Override
    protected void interactuar(Jugador pJugador) {
        System.out.println(this.fraseBienvenida);
        if (!this.desbloqueado){
            this.desbloqueado = this.comprobarCondiciones(pJugador);
            if(desbloqueado) {
                System.out.println(this.fraseAceptacion);
            }
            else{System.out.println(this.fraseRechazo);}
        }
        if (desbloqueado){
        	if (this.pruebaFinal.cumpleLaCondicion(pJugador)){
                this.derrotarJefe();
        	}
        	else{this.derrotarJugador(pJugador);}
        }
    }

    private void derrotarJefe(){
        System.out.println(this.fraseDerrota);
        Partida.getPartida().finalizarPartida(true);
    }
    
    private void derrotarJugador(Jugador pJugador) {
    	ListaJugadores.getListaJugadores().eliminarJugador(pJugador);
        System.out.println(this.fraseVictoria);
    }
}
