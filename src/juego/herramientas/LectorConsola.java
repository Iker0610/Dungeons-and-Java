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
    public int leerOpcionNum(int pValorMin, int pValorMax){
        int input = 0;
        boolean correcto = false;

        do {
            try {
                System.out.print("->");
                input = sc.nextInt();
                System.out.println();
                if (input < pValorMin || pValorMax < input) {
                    throw new ExcepcionValorFueradDeRango();
                }
                correcto = true;
            }
            catch (ExcepcionValorFueradDeRango e) {
                System.out.println("El valor introducido no es válido. Por favor introduce un valor válido.");
            }

            catch (InputMismatchException e) {
                System.out.println("El valor introducido no es un número. Por favor intentalo de nuevo.");
            }

        } while (!correcto);

        return input;
    }

    public String leerOpcionString(ArrayList<String> pOpciones){
        String input;
        String seleccion=null;
        boolean correcto = false;
        do {
            try {
                System.out.print("->");
                input = sc.nextLine();
                System.out.println();
                Iterator<String> itr = pOpciones.iterator();
                boolean enc = false;
                while (itr.hasNext() && !enc) {
                    seleccion=itr.next();
                    enc = input.equalsIgnoreCase(seleccion);
                }
                if (!enc) {
                    throw new ExcepcionValorFueradDeRango();
                }
                correcto = true;
            }
            catch (ExcepcionValorFueradDeRango e){
                System.out.println("El valor introducido no es un valor válido. Introduce otro.");
            }
        }while(!correcto);

        return seleccion;
    }

    public String leerString(){
        return sc.nextLine();
    }

    public boolean leerBoolean(){
        System.out.println("Introduzca Si/S o No/N:");
        String input;
        boolean eleccion=false;
        boolean correcto = false;
        do {
            try{
                System.out.print("->");
                input = sc.nextLine();
                System.out.println();
                if (input.equalsIgnoreCase("si") || input.equalsIgnoreCase("s")) {
                    eleccion = true;
                    correcto=true;
                }
                else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                    eleccion = false;
                    correcto=true;
                }
                else {
                    throw new ExcepcionValorFueradDeRango();
                }
            }
            catch (ExcepcionValorFueradDeRango e){
                System.out.println("El valor introducido no es un valor válido. Introduce otro.");
            }

        }while(!correcto);

        return eleccion;
    }
}
