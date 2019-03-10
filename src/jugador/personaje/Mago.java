package jugador.personaje;

import jugador.Armadura;
import jugador.ListaStat;
import jugador.equipamiento.*;

public class Mago extends Personaje {

    //Constructora
    public Mago (String pNombre, String pSexo,String pRaza){
        super(pNombre, pSexo, pRaza);
        this.armadura = this.crearArmaduraBasica();
        this.cargarStatsBase();
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
    protected void cargarStatsBase () {
        this.lstats = new ListaStat(100,10,20,50,2);
        lstats.sumarStats(this.armadura.getArmorStats());
    }
}
