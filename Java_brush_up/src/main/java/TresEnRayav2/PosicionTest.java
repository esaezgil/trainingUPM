package TresEnRayav2;

import org.junit.Before;
import org.junit.Test;

import TresEnRayav2.Posicion.Direccion;
import static org.junit.Assert.assertEquals;

public class PosicionTest {

	Posicion posicion;

	@Before
	public void before() {
		posicion = new Posicion(1, 1);
	}

	@Test
	public void testPosicionIntInt() {
		assertEquals(1, posicion.getFila());
		assertEquals(1, posicion.getColumna());
	}

	@Test
	public void testPosicion() {
		Posicion posicion = new Posicion();
		assertEquals(0, posicion.getFila());
		assertEquals(0, posicion.getColumna());
	}

	@Test
	public void testGetFila() {
		assertEquals(1, posicion.getFila());
	}

	@Test
	public void testGetColumna() {
		assertEquals(1, posicion.getColumna());
	}

	@Test
	public void testDireccion() {
		Posicion posicion2 = new Posicion(2, 2);
		assertEquals(Direccion.DIAGONAL_PRINCIPAL, posicion.direccion(posicion2));
		posicion2 = new Posicion(1, 2);
		assertEquals(Direccion.HORIZONTAL, posicion.direccion(posicion2));
		posicion2 = new Posicion(2, 1);
		assertEquals(Direccion.VERTICAL, posicion.direccion(posicion2));
		posicion = new Posicion(3, 1);
		posicion2 = new Posicion(2, 2);
		assertEquals(Direccion.DIAGONAL_SECUNDARIA, posicion.direccion(posicion2));
	}
}
