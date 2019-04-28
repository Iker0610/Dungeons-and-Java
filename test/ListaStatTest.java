import static org.junit.Assert.*;

import juego.herramientas.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaStatTest {
	ListaStat lista1;
	ListaStat lista2;

	@Before
	public void setUp() throws Exception {
		//int pFuerza, int pDefensa, int pInteligencia, int pDestreza
		lista1=new ListaStat(20,50,30,10);
		lista2=new ListaStat(70,90,10,20);
		
	}

	@After
	public void tearDown() throws Exception {
		lista1=null;
		lista2=null;
	}
	@Test
	public void testListaStat() {
		ListaStat lista3=new ListaStat(150,-8,50,20);
		System.out.println("Los valores deberian ser:");
		System.out.println("-Fuerza:100 -Defensa:0 -Inteligencia:50 -Destreza:20");
		System.out.println("Y son:");
		System.out.println("");
		lista3.imprimirStats();
		System.out.println("************************************************");
		
		
	}

	@Test
	public void testSumarStats() {
		ListaStat lista6=new ListaStat(0,0,0,0);
		ListaStat lista7=new ListaStat(20,50,30,10);
		
		lista7.sumarStats(lista2);
		System.out.println("Los valores deberian ser:");
		System.out.println("-Fuerza:90 -Defensa:100 -Inteligencia:40 -Destreza:30");
		System.out.println("Y son:");
		System.out.println("");
		lista7.imprimirStats();
		System.out.println("************************************************");
		
		lista2.sumarStats(lista6);
		System.out.println("Los valores deberian ser:");
		System.out.println("-Fuerza:70 -Defensa:90 -Inteligencia:10 -Destreza:20");
		System.out.println("Y son:");
		System.out.println("");
		lista2.imprimirStats();
		System.out.println("************************************************");
		
	}

	@Test
	public void testRestarStats() {
		ListaStat lista9=new ListaStat(0,0,0,0);
		lista2.restarStats(lista1);
		System.out.println("Los valores deberian ser:");
		System.out.println("-Fuerza:50 -Defensa:40 -Inteligencia:0 -Destreza:10");
		System.out.println("Y son:");
		System.out.println("");
		lista2.imprimirStats();
		System.out.println("************************************************");
		lista1.restarStats(lista9);
		System.out.println("Los valores deberian ser:");
		System.out.println("-Fuerza:20 -Defensa:50 -Inteligencia:30 -Destreza:10");
		System.out.println("Y son:");
		System.out.println("");
		lista1.imprimirStats();
		System.out.println("************************************************");
	}

	@Test
	public void testGetValorStat() {
		assertSame(lista1.getValorStat("Fuerza"),20);
		assertSame(lista1.getValorStat("Defensa"),50);
		assertSame(lista1.getValorStat("Inteligencia"),30);
		assertSame(lista1.getValorStat("Destreza"),10);
		
		assertNotSame(lista1.getValorStat("Fuerza"),21);
		assertNotSame(lista1.getValorStat("Defensa"),51);
		assertNotSame(lista1.getValorStat("Inteligencia"),31);
		assertNotSame(lista1.getValorStat("Destreza"),11);
	}

	@Test
	public void testImprimirStats() {
		System.out.println("Debería mostrar:");
		System.out.println("-Fuerza:20 -Defensa:50 -Inteligencia:30 -Destreza:10");
		System.out.println("Y muestra:");
		System.out.println("");
		lista1.imprimirStats();
		System.out.println("************************************************");
	}

}
