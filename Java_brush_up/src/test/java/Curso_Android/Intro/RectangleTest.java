package Curso_Android.Intro;

//import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RectangleTest {
	
	Rectangle rectangle;

	@Test
	public void testRectangle() {
		assertEquals(null,rectangle);
	}

	@Test
	public void testArea() {
		assertEquals(null,rectangle.area());
	}

	@Test
	public void testPerimeter() {
		assertEquals(null,rectangle.perimeter());
	}

}
