package juego.herramientas;

import java.util.Random;

public class Dado {

    //Atributos
    private static Dado dado;
    private static int nCaras = 20;

    //Constructora
    private Dado() {
    }

    //Patron singleton
    public static Dado getDado(){
        if (dado == null){
            dado = new Dado();
        }
        return dado;
    }
    //Otros metodos
    public static int lanzarDado(){
    	Random r = new Random();
    	int valorDado = r.nextInt(nCaras) + 1;
    	System.out.println("Valor obtenido: " + valorDado + " ");
        return valorDado;
    }
}
