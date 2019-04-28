package juego.componentes.estancias.objetos.interactivos;

import juego.componentes.estancias.objetos.interactivos.condiciones.*;
import juego.componentes.estancias.objetos.interactivos.condiciones.numericas.*;
import juego.componentes.estancias.objetos.interactivos.condiciones.string.*;

import juego.herramientas.LectorConsola;
import juego.componentes.jugador.Jugador;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public abstract class ObjetoInteractivo {

    //Atributos
    private String nombre;
    private String descripcion;
    private ListaCondiciones lCondiciones;

    //Constructora
    protected ObjetoInteractivo(String pDir){
        this.lCondiciones = new ListaCondiciones();
        String dirData = pDir+"info_y_condiciones.txt";
        try {
            InputStream fichData = new FileInputStream(dirData);
            Scanner sc = new Scanner(fichData);
            String lineaAct;

            //Dato de nombre
            lineaAct = sc.nextLine();
            if(lineaAct.matches("nombre&(.*)")){
                this.nombre = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Dato de descripcion
            lineaAct = sc.nextLine();
            if(lineaAct.matches("descripcion&(.*)")){
                this.descripcion = lineaAct.split("&")[1];
            }
            else{throw new ExcepcionFormatoIncorrecto();}

            //Generacion de las condiciones
            while(sc.hasNext()){
                lineaAct=sc.nextLine();
                if(
                        lineaAct.matches("condicionDado#\\d\\d")||
                        lineaAct.matches("condicionStat#Fuerza&\\d\\d")||
                        lineaAct.matches("condicionStat#Defensa&\\d\\d")||
                        lineaAct.matches("condicionStat#Inteligencia&\\d\\d")||
                        lineaAct.matches("condicionStat#Destreza&\\d\\d")||
                        lineaAct.matches("condicionClase#(.*)")||
                        lineaAct.matches("condicionObjClave#(.*)")||
                        lineaAct.matches("condicionRaza#(.*)")||
                        lineaAct.matches("condicionSexo#H")||
                        lineaAct.matches("condicionSexo#h")||
                        lineaAct.matches("condicionSexo#M")||
                        lineaAct.matches("condicionSexo#m"))
                {
                    String tipoCondicion = lineaAct.split("#")[0];
                    String data = lineaAct.split("#")[1];
                    this.generarCondicion(tipoCondicion,data);
                }
                else{throw new ExcepcionFormatoIncorrecto();}
            }

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

    //Metodo de carga de datos
    private void generarCondicion (String pTipoCondicion, String pData){
        Condicion nuevaCondicion;
        switch (pTipoCondicion){
            case "condicionDado":
                nuevaCondicion=new CondicionDado(Integer.parseInt(pData));
                this.lCondiciones.anadirCondicion(nuevaCondicion);
                break;

            case "condicionStat":
                nuevaCondicion=new CondicionStat(Integer.parseInt(pData.split("&")[1]),pData.split("&")[0]);
                this.lCondiciones.anadirCondicion(nuevaCondicion);
                break;

            case "condicionClase":
                nuevaCondicion=new CondicionClase(pData);
                this.lCondiciones.anadirCondicion(nuevaCondicion);
                break;

            case "condicionObjClave":
                nuevaCondicion=new CondicionObjClave(pData);
                this.lCondiciones.anadirCondicion(nuevaCondicion);
                break;

            case "condicionRaza":
                nuevaCondicion=new CondicionRaza(pData);
                this.lCondiciones.anadirCondicion(nuevaCondicion);
                break;

            case "condicionSexo":
                nuevaCondicion=new CondicionSexo(pData);
                this.lCondiciones.anadirCondicion(nuevaCondicion);
                break;
        }
    }

    //Otros metodos
    public boolean acercarse (Jugador pJugadorActual){
        this.mostrarInfo();
        System.out.println();
        System.out.println("¿Quieres interactuar?:");
        boolean interactuar = LectorConsola.getLectorConsola().leerBoolean();
        System.out.println();
        if (interactuar){
            this.interactuar(pJugadorActual);
        }
        return interactuar;
    }

    protected abstract void interactuar (Jugador pJugador);

    protected boolean comprobarCondiciones(Jugador pJugador){
        return this.lCondiciones.cumpleLasCondiciones(pJugador);
    }
    
    private void mostrarInfo(){
        System.out.println(this.nombre);
    	System.out.println(this.descripcion);
    }

    public void imprimirNombre(){
        System.out.println(this.nombre);
    }
    
}
