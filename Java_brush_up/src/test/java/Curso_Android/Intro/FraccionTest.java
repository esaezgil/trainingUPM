package Curso_Android.Intro;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Curso_Android.Intro.Fraccion;

public class FraccionTest {

	Fraccion fraccion;
	Fraccion suma;

	@Before
	public void before() {
		this.fraccion = new Fraccion(2, 3);
		}

	@Test
	public void testFraccion() {
		this.fraccion = new Fraccion();
		assertEquals(0, fraccion.getNumerador());
		assertEquals(0, fraccion.getDenominador());
	}

	@Test
	public void testFraccionIntInt() {

		assertEquals(2, fraccion.getNumerador());
		assertEquals(3, fraccion.getDenominador());

	}

	@Test
	public void testProper() {
		assertTrue(fraccion.proper()==true);
	}

	@Test
	public void testImproper() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		suma = new Fraccion(1,3);
		suma.add(fraccion);
		assertEquals(3, suma.getNumerador());
		assertEquals(3, suma.getDenominador());
		
	}

}
