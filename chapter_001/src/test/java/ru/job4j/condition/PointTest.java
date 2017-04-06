package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.6.2017
 */
public class PointTest {

	/**.
	 * class Point testing of function is.
	 * @param none
	 */
	@Test
	public void whenAddAandBthenTrueOrFalse() {
		Point point = new Point(1, 2);
		boolean result = point.is(1, 1);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}