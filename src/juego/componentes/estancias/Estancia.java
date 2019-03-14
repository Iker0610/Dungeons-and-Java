package juego.componentes.estancias;

import juego.componentes.estancias.objetos.JefeFinal;
import juego.componentes.jugador.Jugador;

public class Estancia {

    //Atributos
    private String idEstancia;

    //Listado de objetos interactivos
    private ListaPuertas listaPuertas;
    private ListaCofres listaCofres;
    private ListaNPCs listaNpc;
    //Solo seria diferente de null en la estancia final
    private JefeFinal jefeFinal;

    //Constructora
    public Estancia (String pIdEstancia){
        this.idEstancia = pIdEstancia;
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

    //Metodo del turno
    public void ejecutarTurno(Jugador pJugadorActual){
    	//TODO
    }

    //Metodos menú
    private void imprimirOpcionesMenuPrincipal(){
    	//Imprimir opciones para acceso a la lista
    	//Imprimir opciones del jugador
    	//TODO
    }

    private void imprimirOpcionesMenuSecundarioEstancia(int pOpcionMenu){
    	//Imprimir opciones del submenu consecuente
    	//Mostrar opcion para volver al menu anterior
        //TODO
    }

    private void imprimirOpcionesMenuSecundarioJugador(Jugador pJugador){
        //TODO
    }

    private int getSeleccionDelJugador(){
        //TODO
    }
}
