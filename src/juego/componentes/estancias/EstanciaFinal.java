package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.JefeFinal;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;

public  class EstanciaFinal extends Estancia {

    //Atributos
    private JefeFinal jefeFinal;

    //Constructora
    protected EstanciaFinal(String pIdEstancia){
        super(pIdEstancia);
    }

    //Metodo de carga de datos
    protected  void cargarDatos (String pDir){
        //TODO
    }

    //Metodos menú
    public  boolean administrarMenuPrincipal(Jugador pJugadorActual){
        boolean finTurno = false;
        //TODO Falta las excepciones
        int opcion = LectorConsola.getLectorConsola().leerOpcionNum(1,2);
        System.out.println("1- Mostrar informacion del jugador");
        System.out.println("2- Enfrentarse al jefe final");
        if (opcion==1){
            pJugadorActual.imprimirInformacionJugador();
        }
        else if (opcion==2){
            finTurno = this.jefeFinal.acercarse(pJugadorActual);
        }
        return finTurno;
    }
}
