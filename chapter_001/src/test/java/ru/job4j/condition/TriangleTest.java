package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.6.2017
 */
public class TriangleTest {

	/**.
	 * class TriangleTest testing of function area.
	 * @param none
	 */
	@Test
	public void whenAddThreePointsThenArea() {
		Point a = new Point(1, 1);
		Point b = new Point(10, -10);
		Point c = new Point(-5, -5);
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.area();
		double expected = 60D;
		assertThat(result, closeTo(result, 0.01));
	}
}