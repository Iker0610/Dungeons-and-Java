package juego.componentes.estancias;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import juego.Partida;
import juego.herramientas.excepciones.ExcepcionEstanciaFinallnexistente;
import juego.herramientas.excepciones.ExcepcionEstanciaInexistente;
import juego.herramientas.excepciones.ExcepcionEstanciaIniciallnexistente;


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

            boolean estanciaInicial = false;
            boolean estanciaFinal = false;
            while(sc.hasNext()){
                lineaAct = sc.nextLine();
                if (lineaAct.matches("estanciaInicial&(.*)")){
                    if(!estanciaInicial) {
                        estanciaInicial = true;
                        String[] estanciaInicialData = lineaAct.split("&");
                        String lineaData = estanciaInicialData[1];
                        Estancia estanciaInicio;
                        if (lineaData.matches("estanciaFinal&(.*)")){
                            estanciaFinal=true;
                            String[] estanciaFinalData = lineaData.split("&");
                            estanciaInicio = new EstanciaFinal(estanciaFinalData[1]);
                        }
                        else{
                            estanciaInicio = new EstanciaStandar(lineaData);
                        }
                        lEstancias.add(estanciaInicio);
                        Partida.getPartida().cambiarEstancia(estanciaInicio);
                    }
                    else{throw new Exception();}
                }
                else{
                    if (lineaAct.matches("estanciaFinal&(.*)")){
                        estanciaFinal=true;
                        String[] estanciaFinalData = lineaAct.split("&");
                        lEstancias.add(new EstanciaFinal(estanciaFinalData[1]));

                    }
                    else{lEstancias.add(new EstanciaStandar(lineaAct));}
                }
            }
            if (!estanciaInicial){
                throw new ExcepcionEstanciaIniciallnexistente();
            }
            if (!estanciaFinal){
                throw new ExcepcionEstanciaFinallnexistente();
            }
        }
        catch(ExcepcionEstanciaIniciallnexistente e){
            System.out.println("El fichero "+dirDataDungeon+" no contiene una Estancia Inicial por lo que el juego no puede ejecutarse");
            System.exit(0);
        }
        catch(ExcepcionEstanciaFinallnexistente e){
            System.out.println("El fichero "+dirDataDungeon+" no contiene una Estancia Final por lo que el juego no puede ejecutarse");
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
        Estancia estanciaAct=null;
        boolean chivato=false;
        while (itr.hasNext()&&!chivato){
            estanciaAct = itr.next();
        	chivato = estanciaAct.tieneEsteId(pIdEstancia);
        }
        if (!chivato){
            estanciaAct = null;
        }
        return estanciaAct;
    }

    //Otros metodos
    public void cambiarEstancia(String pIdEstancia) throws ExcepcionEstanciaInexistente {
        Estancia estancia = this.buscarEstancia(pIdEstancia);
        if (estancia != null){
    	    Partida.getPartida().cambiarEstancia(estancia);
        }
        else {throw new ExcepcionEstanciaInexistente();}
    }
}
