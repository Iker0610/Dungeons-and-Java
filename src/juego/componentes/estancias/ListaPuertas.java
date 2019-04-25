package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.Puerta;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPuertas {
    //Atributos
    private ArrayList<Puerta> lista;

    //Constructora
    public ListaPuertas(String pDir, int pNumPuertas){
        this.lista=new ArrayList<>();

        for (int i = 1; i <= pNumPuertas; i++){
            this.lista.add(new Puerta(pDir+"puerta"+i+ File.separator));
        }
    }

    //Metodos de administracion de listas
    private Iterator<Puerta> getIterator(){
        return this.lista.iterator();
    }

    public boolean administrarMenuSecundario(Jugador pJugador){
        boolean finTurno=false;
        this.mostrarPuertas();
        System.out.print("->");
        int input=LectorConsola.getLectorConsola().leerOpcionNum(0, this.lista.size());
        System.out.println();

        if (input!=0){
            finTurno=this.acercarseAPuerta(input, pJugador);
        }
        return finTurno;
    }

    //Metodos de imprimir informacion
    private void mostrarPuertas(){
        Iterator<Puerta> itr=this.getIterator();
        System.out.println("Puertas disponibles:");
        int cont = 1;
        while(itr.hasNext()){
            System.out.print(cont+"- ");
            itr.next().imprimirNombre();
            cont++;
        }
    }

    private boolean acercarseAPuerta(int posPuerta, Jugador pJugador){
    	Puerta puertaSelec=this.lista.get(posPuerta--);
    	return puertaSelec.acercarse(pJugador);
    }

}