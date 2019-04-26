package juego.herramientas;

import java.util.Random;

public class Dado {

    //Atributos
    private static Dado dado;
    private int nCaras;

    //Constructora
    private Dado() {
        nCaras=10;
    }

    //Patron singleton
    public static Dado getDado(){
        if (dado == null){
            dado = new Dado();
        }
        return dado;
    }
    //Otros metodos
    public int lanzarDados(){
    	Random r = new Random();

    	//Lanzar Primer dado
    	System.out.print("Pulsa enter para lanzar el primer dado.");
    	LectorConsola.getLectorConsola().leerString();
    	int valorDado1 = r.nextInt(nCaras) + 1;
    	System.out.println("Has sacado un: " + valorDado1);

    	//Lanzar segundo dado
        System.out.print("Pulsa enter para lanzar el segundo dado.");
        LectorConsola.getLectorConsola().leerString();
        int valorDado2 = r.nextInt(nCaras) + 1;
        System.out.println("Has sacado un: " + valorDado2);

        return (valorDado1+valorDado2);
    }
}
