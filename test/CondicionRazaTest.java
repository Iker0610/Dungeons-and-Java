import static org.junit.Assert.*;

import juego.componentes.estancias.objetos.interactivos.condiciones.string.*;
import juego.componentes.jugador.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CondicionRazaTest {
	CondicionRaza c1;
	CondicionRaza c2;
	Jugador  j1;
	

	@Before
	public void setUp() throws Exception {
		c1=new CondicionRaza("Elfo");
		c2=new CondicionRaza("Enano");
		j1=new Jugador("Laura","m","Elfo","Mago");
	}

	@After
	public void tearDown() throws Exception {
		c1=null;
		c2=null;
		j1=null;
	}

	@Test
	public void testCumpleLaCondicion() {
		assertTrue(c1.cumpleLaCondicion(j1));
		assertFalse(c2.cumpleLaCondicion(j1));
	}

}
