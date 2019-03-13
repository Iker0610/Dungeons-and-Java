package juego.componentes.estancias.objetos;

import juego.componentes.herramientas.ListaStat;

public class JefeFinal {
    //Atributos
    private static JefeFinal jefeFinal;
    private String nombre;
    private ListaStat lStats;
    private int vidaActual;
    //Frases de interaccion
    private String fraseBienvenida;
    private String fraseDerrota;
    private String fraseVictoria;

    //Constructora
    private JefeFinal (){
        //TODO
    }

    //Patron Singleton
    public static JefeFinal getJefeFinal(){
        if (jefeFinal == null){
            jefeFinal = new JefeFinal();
        }
        return jefeFinal;
    }

    //Metodos de comunicacion
    public void darVienvenida(){
        //TODO
    }

    public void imprimirFraseDerrota(){
        //TODO
    }

    public void imprimirFraseVictoria(){
        //TODO
    }

    //Metodos de lucha contra el jefe
    private void derrotarJefe(){
        //TODO
    }

    public void atacarJefe(int pDano){
        //TODO
    }

}
