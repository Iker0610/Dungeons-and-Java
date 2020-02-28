package juego.componentes.estancias;

import juego.componentes.jugador.Jugador;
import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public abstract class Estancia {

    //Atributos
    private String idEstancia;
    private String nombre;
    private String descripcion;


    //Constructora
    protected Estancia (String pIdEstancia){
        this.idEstancia = pIdEstancia;
        String dirData = this.getDir()+"info.txt";
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

    protected String getDir(){
        String dirRoot = System.getProperty("user.dir")+ File.separator+"recursos"+ File.separator+"ficheros"+ File.separator+"dungeons"+File.separator;
        return (dirRoot+idEstancia+File.separator);
    }

    //Metodos menú
    public abstract boolean administrarMenuPrincipal(Jugador pJugadorActual);

    public void imprimirInfoEstancia(){
        System.out.println(this.nombre);
        System.out.println(this.descripcion);
        System.out.println();
    }
}
