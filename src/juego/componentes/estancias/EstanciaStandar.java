package juego.componentes.estancias;

import juego.herramientas.LectorConsola;
import juego.componentes.jugador.Jugador;

public class EstanciaStandar extends Estancia {

    //Atributos

    //Listado de objetos interactivos
    private ListaPuertas listaPuertas;
    private ListaCofres listaCofres;
    private ListaNPCs listaNpc;

    //Constructora
    public EstanciaStandar(String pIdEstancia){
        super(pIdEstancia);
        this.listaCofres=new ListaCofres();
        this.listaNpc=new ListaNPCs();
        this.listaPuertas=new ListaPuertas();
    }

    //Metodo de carga de datos
    protected void cargarDatos (String pDir){
        //TODO
    }

    //Metodos menú
    public boolean administrarMenuPrincipal(Jugador pJugadorActual){
    	//Imprimir opciones para acceso a la lista
    	//Imprimir opciones del jugador
    	boolean finTurno = false;
    	System.out.println("1- Mostrar informacion del jugador");
    	System.out.println("2- Interactuar con NPC's");
    	System.out.println("3- Interactuar con cofres");
    	System.out.println("4- Interactuar con puertas");
    	//TODO Falta las excepciones
    	int opcion = LectorConsola.getLectorConsola().leerOpcionNum(1,4);

    	if (opcion==1){
    		pJugadorActual.imprimirInformacionJugador();
    	}
    	else if (opcion==2){
    		finTurno=this.listaNpc.administrarMenuSecundario(pJugadorActual);
    	}
    	else if (opcion==3){
    		finTurno=this.listaCofres.administrarMenuSecundario(pJugadorActual);
    	}
    	else if (opcion==4){
    		finTurno=this.listaPuertas.administrarMenuSecundario(pJugadorActual);
    	}
    	return finTurno;
    }
}
