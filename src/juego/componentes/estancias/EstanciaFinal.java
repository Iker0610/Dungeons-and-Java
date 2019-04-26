package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.JefeFinal;
import juego.componentes.jugador.Jugador;
import juego.herramientas.LectorConsola;

import java.io.File;

public  class EstanciaFinal extends Estancia {

    //Atributos
    private JefeFinal jefeFinal;

    //Constructora
    protected EstanciaFinal(String pIdEstancia){
        super(pIdEstancia);
        String dirData = super.getDir()+"jefeFinal"+File.separator;
        this.jefeFinal = new JefeFinal(dirData);
    }

    //Metodos menú
    public  boolean administrarMenuPrincipal(Jugador pJugadorActual){
        boolean finTurno = false;

        System.out.println("Elige una acción a realizar:");
        System.out.println("1- Mostrar informacion del jugador");
        System.out.println("2- Enfrentarse al jefe final");
        int opcion = LectorConsola.getLectorConsola().leerOpcionNum(1,2);
        if (opcion==1){
            pJugadorActual.imprimirInformacionJugador();
        }
        else if (opcion==2){
            finTurno = this.jefeFinal.acercarse(pJugadorActual);
        }
        System.out.println();
        return finTurno;
    }
}
