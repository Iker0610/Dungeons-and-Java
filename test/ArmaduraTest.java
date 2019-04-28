import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import juego.componentes.estancias.objetos.interactivos.condiciones.string.CondicionClase;
import juego.componentes.estancias.objetos.recolectables.PiezaArmadura;
import juego.componentes.jugador.inventarios.Armadura;
import juego.herramientas.ListaStat;

public class ArmaduraTest {
	Armadura a1;
	Armadura a2;
	PiezaArmadura p1;
	ListaStat l1;
	ListaStat l2;
	@Before
	public void setUp() throws Exception {
		p1=new PiezaArmadura("Casco generico","Casco",1,1,1,1);
		a1=new Armadura();
		a2=new Armadura();
		a2.cambiarEquipamiento(p1);
		l1=new ListaStat(0,0,0,0);
		l2=new ListaStat(1,1,1,1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getArmorStatsTest() {
		assertEquals(a1.getArmorStats().getValorStat("Fuerza"),l1.getValorStat("Fuerza"));
		assertEquals(a1.getArmorStats().getValorStat("Inteligencia"),l1.getValorStat("Inteligencia"));
		assertEquals(a1.getArmorStats().getValorStat("Destreza"),l1.getValorStat("Destreza"));
		assertEquals(a1.getArmorStats().getValorStat("Defensa"),l1.getValorStat("Defensa"));
		
		assertEquals(a2.getArmorStats().getValorStat("Fuerza"),l2.getValorStat("Fuerza"));
		assertEquals(a2.getArmorStats().getValorStat("Inteligencia"),l2.getValorStat("Inteligencia"));
		assertEquals(a2.getArmorStats().getValorStat("Destreza"),l2.getValorStat("Destreza"));
		assertEquals(a2.getArmorStats().getValorStat("Defensa"),l2.getValorStat("Defensa"));
	}

}
