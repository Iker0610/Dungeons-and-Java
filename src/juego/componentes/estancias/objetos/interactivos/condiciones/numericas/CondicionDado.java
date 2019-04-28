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
        System.out.println("Parece que se necesita que lances los dados para continuar. (Valor mínimo requerido "+super.getValorMinimo());
    	int valorDado = Dado.getDado().lanzarDados();
    	int valorDefinitivo= this.calcularValorFinal(valorDado, pJugador);
    	System.out.println("Gracias a tu destreza el valor obtenido pasa a ser: "+valorDefinitivo);
    	return (super.getValorMinimo() <= valorDefinitivo);
    	
    }
    private int calcularValorFinal(int pValorNum, Jugador pJugador) {
    	double destreza = pJugador.getStat("Destreza");
    	return (int)(pValorNum*(1+destreza/100));
    }

}
