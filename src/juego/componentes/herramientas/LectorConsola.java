package juego.componentes.herramientas;

public class LectorConsola {

    //Atributos
    private static LectorConsola lectorConsola;

    //Constructora
    private LectorConsola() {
        //TODO
    }

    //Patron singleton
    public static LectorConsola getLectorConsola(){
        if (lectorConsola == null){
            lectorConsola = new LectorConsola();
        }
        return lectorConsola;
    }
    //Otros metodos
    public int leerOpcion(int pValorMin, int pValorMax){
        //TODO
    }

    public String leerString(){
        //TODO
    }
}
