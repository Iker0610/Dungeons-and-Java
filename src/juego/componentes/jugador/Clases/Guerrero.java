package juego.componentes.jugador.Clases;

import juego.componentes.estancias.objetos.recogibles.PiezaArmadura;
import juego.componentes.herramientas.ListaStat;
import juego.componentes.jugador.Jugador;
import juego.componentes.jugador.inventarios.Armadura;

public class Guerrero extends Jugador {

    //Constructora
    public Guerrero(String pNombre, String pSexo, String pRaza){
        super(pNombre, pSexo, pRaza);
        this.cargarStatsClase();
    }

    //Otros metodos
    protected void crearArmaduraBasica(){
        //Creamos una armadura vacía pues no se le van a añadir todos los componentes
        Armadura armaduraBasica = new Armadura();

        //Creamos las piezas de armadura básicas
        PiezaArmadura pecheraBasica = new PiezaArmadura("pechera","Túnica andrajosa",50,0,5,15,0);
        PiezaArmadura pantalonesBasicos = new PiezaArmadura("pantalones","Pantalones andrajosos",30,0,5,15,0);
        PiezaArmadura armaBasica = new PiezaArmadura("arma","Baston viejo",0,0,0,30,0);

        //Añadimos el equipamiento básico a la armadura
        this.anadirObjetoRecojible(pecheraBasica);
        this.anadirObjetoRecojible(pantalonesBasicos);
        this.anadirObjetoRecojible(armaBasica);
    }

    protected void cargarStatsClase () {
        //Se crean los herramientas base por ser de x clase
        ListaStat lstatsClase = new ListaStat(100,10,20,50,2);
        this.getListaStats().sumarStats(lstatsClase);
        //TODO
        //Falta actualizar la vida actual del personaje

    }
}
