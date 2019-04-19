package juego.componentes.estancias;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import juego.Partida;
import juego.herramientas.excepciones.ExcepcionEstanciaInexistente;

public class Dungeon {

    //Atributos
    private static Dungeon dungeon;
    private ArrayList<Estancia> lEstancias;

    //Constructora
    private Dungeon(){
        lEstancias = new ArrayList<>();
        String dirRoot = System.getProperty("user.dir")+ File.separator+"dungeons"+File.separator;
        String dirDataDungeon = dirRoot+"dungeon_info.txt";
        try {
            InputStream fichDataDungeon = new FileInputStream(dirDataDungeon);
            Scanner sc = new Scanner(fichDataDungeon);

            String lineaAct = sc.nextLine();
            if (lineaAct.matches("titulo&(.*)")){
                String[] titulo = lineaAct.split("&");
                System.out.println(titulo[1]);
            }
            else{throw new Exception();}

            lineaAct = sc.nextLine();
            if (lineaAct.matches("descripcion&(.*)")){
                String[] descripcion = lineaAct.split("&");
                System.out.println(descripcion[1]);
            }
            else{throw new Exception();}

            boolean estanciaFinal = false;
            while(sc.hasNext()){
                lineaAct = sc.nextLine();
                if (lineaAct.matches("estanciaFinal&(.*)")){
                    String[] estanciaFinalData = lineaAct.split("&");
                    lEstancias.add(new EstanciaFinal(estanciaFinalData[1]));
                    estanciaFinal=true;
                }
                else{lEstancias.add(new EstanciaStandar(lineaAct));}
            }
            if (!estanciaFinal){
                throw new ExcepcionEstanciaInexistente();
            }
        }
        catch(ExcepcionEstanciaInexistente e){
            System.out.println("El fichero "+dirDataDungeon+" no contiene una estanciaFinal por lo que el juego no puede ejecutarse");
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("El fichero "+dirDataDungeon+" no exite o no contiene el formato adecuado por lo que el juego no puede ejecutarse");
            System.exit(0);
        }
    }

    //Patron singleton
    public static Dungeon getDungeon() {
        if (dungeon==null){
            dungeon=new Dungeon();
        }
        return dungeon;
    }

    //Metodos arraylist
    private Iterator<Estancia> getIterator(){
        return this.lEstancias.iterator();
    }

    private Estancia buscarEstancia(String pIdEstancia){
        Iterator<Estancia> itr=getIterator();
        Estancia estanciaPos=null;
        boolean chivato=false;
        while (itr.hasNext()&&!chivato){
        	estanciaPos=itr.next();
        	chivato=estanciaPos.tieneEsteId(pIdEstancia);
        }
        return estanciaPos;
    }

    //Otros metodos
    public void cambiarEstancia(String pIdEstancia) throws ExcepcionEstanciaInexistente{
        //TODO hace falta añadir la excepción por si la estancia es NULL !!!!
    	Partida.getPartida().cambiarEstancia(this.buscarEstancia(pIdEstancia));
    }
}
