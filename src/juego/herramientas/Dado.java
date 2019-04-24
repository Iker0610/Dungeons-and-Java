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
    public int lanzarDado(){
    	Random r = new Random();
    	System.out.println("Pulsa enter para lanzar los dados.");
    	LectorConsola.getLectorConsola().leerString();
    	int valorDado1 = r.nextInt(nCaras) + 1;
        int valorDado2 = r.nextInt(nCaras) + 1;
    	System.out.println("Primer dado: " + valorDado1);
        System.out.println("Primer dado: " + valorDado2);
        return (valorDado1+valorDado2);
    }
}
