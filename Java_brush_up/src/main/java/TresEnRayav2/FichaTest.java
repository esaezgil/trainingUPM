package TresEnRayav2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import TresEnRayav2.Ficha.Color;

public class FichaTest {

	Ficha fichaTest;
	Posicion posicion;

	@Before
	public void before() {

		posicion = new Posicion(2, 3);
		fichaTest = new Ficha(posicion, Color.NEGRO);
	}

	@Test
	public void getX() {
		assertEquals(1, fichaTest.getFila());
	}

	@Test
	public void getY() {
		assertEquals(2, fichaTest.getColumna());
	}

	@Test
	public void testFicha() {
		Ficha fichaTest = new Ficha();
		assertEquals(0, fichaTest.getFila());
		assertEquals(0, fichaTest.getColumna());
		assertEquals(Color.ROJO, fichaTest.getColor());
	}

	@Test
	public void testFichaPosicionFichas() {
		assertEquals(1, fichaTest.getFila());
		assertEquals(2, fichaTest.getColumna());
		assertEquals(Color.NEGRO, fichaTest.getColor());
	}
}
