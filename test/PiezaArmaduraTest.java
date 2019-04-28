import static org.junit.Assert.*;

import juego.componentes.estancias.objetos.recolectables.*;
import juego.herramientas.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PiezaArmaduraTest {
	PiezaArmadura p1;
	PiezaArmadura p2;
	ListaStat lista;
	

	@Before
	public void setUp() throws Exception {
		//String pNombre, String pTipo, int pFuerza, int pDefensa, int pInteligencia, int pDestreza
		p1=new PiezaArmadura("Casco nuevo","Casco",10,15,5,5);
		p2=new PiezaArmadura("Pantalones rotos","Pantalones",15,15,5,10);
		lista=new ListaStat(10,15,20,5);
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		lista=null;
	}

	@Test
	public void testMostrarInfo() {
		System.out.println("Deberia mostrar:");
		System.out.println("Nombre: Casco nuevo");
		System.out.println("Tipo: Casco");
		System.out.println("Fuerza: 10");
		System.out.println("Defensa: 15");
		System.out.println("Inteligencia: 5");
		System.out.println("Destreza: 5");
		System.out.println("y muestra:");
		System.out.println("");
		p1.mostrarInfo();
		System.out.println("*************************************************************************");
		
		System.out.println("Deberia mostrar:");
		System.out.println("Nombre: Pantalones rotos");
		System.out.println("Tipo: Pantalones");
		System.out.println("Fuerza: 15");
		System.out.println("Defensa: 15");
		System.out.println("Inteligencia: 5");
		System.out.println("Destreza: 10");
		System.out.println("y muestra:");
		System.out.println("");
		p2.mostrarInfo();
		System.out.println("*************************************************************************");
	}

	@Test
	public void testGetTipo() {
		assertEquals(p1.getTipo(),"Casco");
		assertEquals(p2.getTipo(),"Pantalones");
		
		assertNotEquals(p1.getTipo(),"Pantalones");
		assertNotEquals(p2.getTipo(),"Casco");
	}

	@Test
	public void testAnadirStatsPieza() {
		p1.anadirStatsPieza(lista);
		System.out.println("Deberia mostrar:");
		System.out.println("Nombre: Casco nuevo");
		System.out.println("Tipo: Casco");
		System.out.println("Fuerza: 20");
		System.out.println("Defensa: 30");
		System.out.println("Inteligencia: 25");
		System.out.println("Destreza: 10");
		System.out.println("y muestra:");
		System.out.println("");
		p1.mostrarInfo();
		
		System.out.println("*************************************************************************");
		
		System.out.println("Deberia mostrar:");
		System.out.println("Nombre: Pantalones rotos");
		System.out.println("Tipo: Pantalones");
		System.out.println("Fuerza: 25");
		System.out.println("Defensa: 30");
		System.out.println("Inteligencia: 25");
		System.out.println("Destreza: 15");
		System.out.println("y muestra:");
		System.out.println("");
		p2.mostrarInfo();
		System.out.println("*************************************************************************");
		
	}
	
	@Test
	public void testTieneEsteNombre() {
		assertTrue(p1.tieneEsteNombre("Casco nuevo"));
		assertTrue(p2.tieneEsteNombre("Pantalones rotos"));
		
		assertFalse(p2.tieneEsteNombre("Casco nuevo"));
		assertFalse(p1.tieneEsteNombre("Pantalones rotos"));
	}

}
