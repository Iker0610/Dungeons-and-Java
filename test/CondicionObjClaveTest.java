import static org.junit.Assert.*;

import juego.componentes.estancias.objetos.interactivos.condiciones.string.*;
import juego.componentes.jugador.*;
import juego.componentes.estancias.objetos.recolectables.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CondicionObjClaveTest {
	CondicionObjClave c1;
	CondicionObjClave c2;
	ObjetoClave obj; 
	Jugador  j1;
	@Before
	public void setUp() throws Exception {
		c1=new CondicionObjClave("Llave");
		c2=new CondicionObjClave("Espada");
		j1=new Jugador("Laura","m","Elfo","Mago");
		obj=new ObjetoClave("Llave","Abre puertas");
	}

	@After
	public void tearDown() throws Exception {
		c1=null;
		c2=null;
		j1=null;
		obj=null;
	}

	@Test
	public void testCumpleLaCondicion() {
		j1.anadirObjetoRecolectable(obj);
		assertTrue(c1.cumpleLaCondicion(j1));
		assertFalse(c2.cumpleLaCondicion(j1));
	}

}
