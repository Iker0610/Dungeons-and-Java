package juego.componentes.herramientas;

public class LectorConsola {

    //Atributos
    private static LectorConsola lectorConsola;

    //Constructora
    private LectorConsola() {
        //TODO
    }

    //Patron singleton
    public static LectorConsola getDado(){
        if (lectorConsola == null){
            lectorConsola = new LectorConsola();
        }
        return dado;
    }
    //Otros metodos
    public int leerInt(){
        //TODO
    }

    public int leerString(){
        //TODO
    }
}
