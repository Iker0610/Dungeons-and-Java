package juego.componentes.estancias.objetos.interactivos.condiciones.numericas;

import juego.componentes.jugador.Jugador;
import juego.herramientas.Dado;


public class CondicionDado extends CondicionNumerica {
    //Constructora
    public CondicionDado(int pValorMinimo){
        super(pValorMinimo);
    }

    //Metodos
    public boolean cumpleLaCondicion(Jugador pJugador){
    	int valorDado = Dado.getDado().lanzarDado();
    	int valorDefinitivo= this.calcularValorFinal(valorDado, pJugador);
    	return (super.getValorMinimo() <= valorDefinitivo);
    	
    }
    private int calcularValorFinal(int pValorNum, Jugador pJugador) {
    	double destreza = pJugador.getStat("Destreza");
    	return (int)(pValorNum*(1+destreza/200));
    }

}
