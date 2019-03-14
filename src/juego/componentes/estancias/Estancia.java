package juego.componentes.estancias;

import juego.componentes.estancias.objetos.JefeFinal;

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

    //Metodos menú
    private void imprimirOpcionesMenuPrincipal(){
    	//Imprimir opciones para acceso a la lista
    	//Imprimir opciones del jugador
    	//TODO
    }

    private void imprimirOpcionesMenuSecundario(){
    	//Imprimir opciones del submenu consecuente
    	//Mostrar opcion para volver al menu anterior
        //TODO
    }
    
    public void ejecutarTurno(Jugador pJugadorActual){
    	//TODO
    }
    
}
