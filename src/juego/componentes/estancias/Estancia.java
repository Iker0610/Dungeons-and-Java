package juego.componentes.estancias;

import juego.componentes.estancias.objetos.interactivos.JefeFinal;
import juego.componentes.herramientas.LectorConsola;
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
        this.listaCofres=new ListaCofres();
        this.listaNpc=new ListaNPCs();
        this.listaPuertas=new ListaPuertas();
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDir){
        //TODO
    }

    //Metodos menú
    public boolean administrarMenuPrincipal(Jugador pJugadorActual){
    	//Imprimir opciones para acceso a la lista
    	//Imprimir opciones del jugador
    	boolean finTurno;
    	System.out.println("1- Mostrar informacion del jugador");
    	System.out.println("2- Interactuar con NPC's");
    	System.out.println("3- Interactuar con cofres");
    	System.out.println("4- Interactuar con puertas");
    	int opcion;
    	if (this.jefeFinal!=null){
    		System.out.println("5- Interactuar con el Jefe Final");
    		opcion=LectorConsola.getLectorConsola().leerOpcion(1, 5);
    	}
    	else{
    		opcion=LectorConsola.getLectorConsola().leerOpcion(1, 4);
    	}
    	finTurno=false;
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
    	else if (this.jefeFinal!=null){
    		finTurno=this.jefeFinal.acercarse(pJugadorActual);
    	}
    	return finTurno;
    }

    public boolean tieneEsteId(String pId){
        return (this.idEstancia==pId);
    }
}
