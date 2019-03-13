package juego.componentes.estancias;

import juego.componentes.estancias.objetos.JefeFinal;

public class Estancia {

    //Atributos
    private String idEstancia;

    //Listado de objetos interactivos
    private ListaPuertas listaPuertas;
    private ListaCofres listaCofres;
    private ListaNPCs listaNpc;
    //Solo será diferente de null en la estancia final
    private JefeFinal jefeFinal;

    //Constructora
    protected Estancia (String pIdEstancia){
        this.idEstancia = pIdEstancia;
    }

    //Metodo de carga de datos
    private void cargarDatos (String pDireccionFichero){
        //TODO
    }

}
