package jugador.personaje;

import jugador.Armadura;
import jugador.equipamiento.*;

public class Mago extends Personaje {

    //Constructora
    public Mago (String pNombre, String pSexo,String pRaza){
        super(pNombre, pSexo, pRaza);
        this.armadura = this.crearArmaduraBasica();
        this.cargarStatsBase();
    }

    //Otros metodos
    protected Armadura crearArmaduraBasica (){
        Armadura armaduraBasica = new Armadura();
        Pechera pecheraBasica = new Pechera("Túnica andrajosa",50,0,5,15,0);
        Pantalones pantalonesBasicos = new Pantalones("Pamtalones andrajosos",30,0,5,15,0);
        Arma armaBasica = new Arma("Baston viejo",0,0,0,30,0);
        return armaduraBasica;
    }
    protected void cargarStatsBase () {

    }
}
