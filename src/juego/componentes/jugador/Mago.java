package juego.componentes.jugador;

import juego.componentes.jugador.inventarios.Armadura;
import juego.componentes.dungeon.objetos.recojibles.PiezaArmadura;
import juego.componentes.stats.ListaStat;

public class Mago extends Jugador {

    //Constructora
    public Mago (String pNombre, String pSexo,String pRaza){
        super(pNombre, pSexo, pRaza);
        this.armadura = this.crearArmaduraBasica();
        this.cargarStatsClase();
    }

    //Otros metodos
    @Override
    protected Armadura crearArmaduraBasica(){
        //Creamos una armadura vacía pues no se le van a añadir todos los componentes
        Armadura armaduraBasica = new Armadura();

        //Creamos las piezas de armadura básicas
        PiezaArmadura pecheraBasica = new PiezaArmadura("pechera","Túnica andrajosa",50,0,5,15,0);
        PiezaArmadura pantalonesBasicos = new PiezaArmadura("pantalones","Pantalones andrajosos",30,0,5,15,0);
        PiezaArmadura armaBasica = new PiezaArmadura("arma","Baston viejo",0,0,0,30,0);

        //Añadimos el equipamiento básico a la armadura
        armaduraBasica.cambiarEquipamiento(pecheraBasica);
        armaduraBasica.cambiarEquipamiento(pantalonesBasicos);
        armaduraBasica.cambiarEquipamiento(armaBasica);

        //Devolvemos la armadura básica con las piezas correspondiente
        return armaduraBasica;
    }
    @Override
    protected void cargarStatsClase () {
        //Se crean los stats base por ser de x clase
        ListaStat lstatsClase = new ListaStat(100,10,20,50,2);
        //Se suman los stats de la armadura a los del personajes
        lstatsClase.sumarStats(this.armadura.getArmorStats());
        this.lstats.sumarStats(lstatsClase);
    }
}
