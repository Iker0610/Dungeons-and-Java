package juego.herramientas;

import juego.herramientas.excepciones.ExcepcionFormatoIncorrecto;
import juego.herramientas.excepciones.ExcepcionValorFueradDeRango;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class LectorConsola {

    //Atributos
    private static LectorConsola lectorConsola;
    private Scanner sc;

    //Constructora
    private LectorConsola() {
        sc = new Scanner (System.in);
    }

    //Patron singleton
    public static LectorConsola getLectorConsola(){
        if (lectorConsola == null){
            lectorConsola = new LectorConsola();
        }
        return lectorConsola;
    }
    //Otros metodos
    public int leerOpcionNum(int pValorMin, int pValorMax) throws ExcepcionFormatoIncorrecto, ExcepcionValorFueradDeRango {
        int input;
        try{
            input= sc.nextInt();
        }
        catch(InputMismatchException e){
            throw new ExcepcionFormatoIncorrecto();
        }
        if(input<pValorMin||pValorMax<input){
            throw new ExcepcionValorFueradDeRango();
        }
        return input;
    }

    public String leerOpcionString(ArrayList<String> pOpciones) throws ExcepcionValorFueradDeRango{
        String input = sc.nextLine();
        Iterator<String> itr = pOpciones.iterator();
        boolean enc = false;

        while(itr.hasNext() && !enc){
            enc = itr.next().equalsIgnoreCase(input);
        }

        if (!enc){
            throw new ExcepcionValorFueradDeRango();
        }

        return input;
    }

    public String leerString(){
        return sc.nextLine();
    }

    public boolean leerBoolean()throws ExcepcionFormatoIncorrecto{
        String input = sc.nextLine();
        boolean eleccion;
        if(input.equalsIgnoreCase("si") || input.equalsIgnoreCase("s")){
            eleccion = true;
        }
        else if(input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")){
            eleccion = false;
        }
        else{
            throw new ExcepcionFormatoIncorrecto();
        }

        return eleccion;
    }
}
