package juego.componentes.estancias;

import juego.componentes.jugador.Jugador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public abstract class Estancia {

    //Atributos
    private String idEstancia;
    private String descripcion;


    //Constructora
    protected Estancia (String pIdEstancia){
        this.idEstancia = pIdEstancia;
        String fichData = this.getDir()+"info.txt";
        try {
            InputStream fichDataDungeon = new FileInputStream(fichData);
            Scanner sc = new Scanner(fichDataDungeon);
            this.descripcion=sc.nextLine();

            //Se cierra el scanner
            sc.close();
        }
        catch (FileNotFoundException e){
            this.descripcion="";
        }
    }

    protected String getDir(){
        String dirRoot = System.getProperty("user.dir")+ File.separator+"recursos"+ File.separator+"ficheros"+ File.separator+"dungeons"+File.separator;
        return (dirRoot+idEstancia+File.separator);
    }

    //Metodos menú
    public abstract boolean administrarMenuPrincipal(Jugador pJugadorActual);

    public boolean tieneEsteId(String pId){
        return (this.idEstancia.equals(pId));
    }

    public void imprimirInfoEstancia(){
        System.out.println(this.idEstancia);
        System.out.println(this.descripcion);
        System.out.println();
    }
}
