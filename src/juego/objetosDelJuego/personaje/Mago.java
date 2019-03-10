package juego.objetosDelJuego.personaje;

import juego.objetosDelJuego.objetos.armadura.Armadura;
import juego.objetosDelJuego.stats.ListaStat;
import juego.objetosDelJuego.objetos.armadura.equipamiento.*;

public class Mago extends Personaje {

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
        Pechera pecheraBasica = new Pechera("Túnica andrajosa",50,0,5,15,0);
        Pantalones pantalonesBasicos = new Pantalones("Pantalones andrajosos",30,0,5,15,0);
        Arma armaBasica = new Arma("Baston viejo",0,0,0,30,0);

        //Añadimos el equipamiento básico a la armadura
        armaduraBasica.cambiarPechera(pecheraBasica);
        armaduraBasica.cambiarPantalones(pantalonesBasicos);
        armaduraBasica.cambiarArma(armaBasica);

        //Devolvemos la armadura básica con las piezas correspondiente
        return armaduraBasica;
    }
    @Override
    protected void cargarStatsClase () {
        //Se crean los stats base por ser de x clase
        ListaStat lstatsClase = new ListaStat(100,10,20,50,2);
        //Se suman los stats de la armadura a los del personaje
        lstatsClase.sumarStats(this.armadura.getArmorStats());
        this.lstats.sumarStats(lstatsClase);
    }
}
