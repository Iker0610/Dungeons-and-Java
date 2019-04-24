package juego.componentes.jugador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import juego.Partida;
import juego.herramientas.LectorConsola;
import juego.herramientas.excepciones.ExcepcionRazaInexistente;

public class ListaJugadores {

    //Atributos
    private static ListaJugadores listaJugadores;
    private ArrayList<Jugador> lista;
    private int posJugadorAct;
    private int numJugadoresVivos;

    //Constructora
    private ListaJugadores(){
        lista = new ArrayList<>();
        this.posJugadorAct = -1;
        this.numJugadoresVivos = 0;
    }

    //Patron singleton
    public static ListaJugadores getListaJugadores (){
        if (listaJugadores == null){
            listaJugadores = new ListaJugadores();
        }
        return listaJugadores;
    }

    //Metodo para anadir jugadores
    public void generarJugador(){
    	LectorConsola lector= LectorConsola.getLectorConsola();
        String nombre;
        String sexo;
        String raza;
        String clase;

        //Seleccion del nombre
        System.out.println("Introduzca su nombre");
        nombre=lector.leerString();

        //Seleccion del genero
        System.out.println("Introduzca su genero: H(hombre)/M(mujer) ");
        ArrayList<String> lSexo = new ArrayList<>();
        lSexo.add("h");
        lSexo.add("m");
        sexo=lector.leerOpcionString(lSexo);


        //Selección de raza y clase
        String dirRoot = System.getProperty("user.dir")+ File.separator+"recursos"+ File.separator+"ficheros"+ File.separator+"dungeons"+File.separator;
        String dirRazas = dirRoot+"razas_clases.txt";

        try{
            InputStream fichDataDungeon = new FileInputStream(dirRazas);
            Scanner sc = new Scanner(fichDataDungeon);

            //Seleccion de raza
            String[] razasData = sc.nextLine().split("&");
            ArrayList<String> lRazas = new ArrayList<>();
            int numRazas = Integer.parseInt(razasData[0]);
            System.out.println("Elija su raza entre las siguientes disponibles:");
            for (int i = 1; i <= numRazas; i++){
                lRazas.add(razasData[i]);
                System.out.println(razasData[i]);
            }
            raza=lector.leerOpcionString(lRazas);

            //Seleccion de Clase
            String lineaAct;
            String lineaRaza=null;

            while (lineaRaza == null && sc.hasNext()){
                lineaAct = sc.nextLine();
                if (lineaAct.contains(raza+"#")){
                    lineaRaza = lineaAct;
                }
            }
            if (lineaRaza != null){
                razasData = lineaRaza.split("#");
                int numClases = Integer.parseInt(razasData[1]);
                ArrayList<String> lClases = new ArrayList<>();
                String[] dataClases = razasData[2].split("&");
                System.out.println("Elija su clase entre las siguientes disponibles:");
                for (int i = 1; i <= numClases; i++){
                    lClases.add(dataClases[i]);
                    System.out.println(dataClases[i]);
                }
                clase=lector.leerOpcionString(lClases);
            }
            else {throw new ExcepcionRazaInexistente();}
            sc.close();

            //Creacion del jugador;
            lista.add(new Jugador(nombre, sexo, raza, clase));
            numJugadoresVivos++;
            System.out.println("El personaje se ha creado correctamente");

        }
        catch (ExcepcionRazaInexistente e){
            System.out.println("El fichero "+dirRazas+" no contiene datos sobre la raza seleccionada o tiene un formato inadecuado, por lo que el juego se cerrará.");
            System.exit(0);
        }
        catch(FileNotFoundException e){
            System.out.println("El fichero "+dirRazas+" no existe por lo que el juego no ha podido ejecutarse.");
            System.exit(0);
        }
        catch (Exception e){
            System.out.println("Ha ocurrido un error inesperado: el juego se cerrará");
            System.exit(0);
        }
    }

    private int numJugadoresTotal(){
        return this.lista.size();
    }

    //Metodos de control
    public Jugador getSiguienteJugador(){
        int posAct = this.posJugadorAct;
        if(posAct==-1){
            posAct=0;
        }
        else if (this.numJugadoresVivos != 1){
            boolean encVivo = false;
            while (!encVivo){
                if (posAct==(this.numJugadoresTotal()-1)){
                    posAct=0;
                }
                else { posAct++; }

                encVivo=this.lista.get(posAct).estaVivo();
            }
        }
        this.posJugadorAct = posAct;
        return this.lista.get(posAct);
    }

    public void eliminarJugador (Jugador pJugador){
    	pJugador.morirse();
    	this.numJugadoresVivos--;
    	if(this.numJugadoresVivos==0){
    		this.gameOver();
    	}
    }

    private void gameOver(){
        Partida.getPartida().finalizarPartida(false);
    }
}
