import static org.junit.Assert.*;

import juego.componentes.estancias.objetos.recolectables.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObjClaveTest {
	ObjetoClave obj1;
	ObjetoClave obj2;
	

	@Before
	public void setUp() throws Exception {
		obj1=new ObjetoClave("Llave","Abre puertas");
		obj2=new ObjetoClave("Libro","Parece antiguo");
	}

	@After
	public void tearDown() throws Exception {
		obj1=null;
		obj2=null;
	}

	@Test
	public void testMostrarInfo() {
		System.out.println("Deberia mostrar:");
		System.out.println("Nombre: Llave");
		System.out.println("Descripcion: Abre puertas");
		System.out.println("y muestra:");
		obj1.mostrarInfo();
		
		System.out.println("Deberia mostrar:");
		System.out.println("Nombre: Libro");
		System.out.println("Descripcion: Parece antiguo");
		System.out.println("y muestra:");
		obj2.mostrarInfo();
		
	}

	@Test
	public void testTieneEsteNombre() {
		assertTrue(obj1.tieneEsteNombre("Llave"));
		assertTrue(obj2.tieneEsteNombre("Libro"));
		
		assertFalse(obj1.tieneEsteNombre("Libro"));
		assertFalse(obj2.tieneEsteNombre("Llave"));
	}

}
