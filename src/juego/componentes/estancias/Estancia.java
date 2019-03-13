package juego.componentes.estancias;

public class Estancia {

    //Atributos
    private String idEstancia;

    //Listado de objetos interactivos
    private ListaPuertas listaPuertas;
    private ListaCofres listaCofres;
    private ListaNPCs listaNpc;

    //Constructora
    public Estancia (String pIdEstancia){
        this.idEstancia = pIdEstancia;
    }


}
