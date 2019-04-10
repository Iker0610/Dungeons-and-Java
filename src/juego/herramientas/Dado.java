package juego.herramientas;

public class Dado {

    //Atributos
    private static Dado dado;

    //Constructora
    private Dado() {
        //TODO
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
        int valorDado = 0;
        //TODO
        return valorDado;
    }
}
