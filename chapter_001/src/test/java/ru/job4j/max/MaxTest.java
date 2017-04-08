package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 2
 * @since 4.8.2017
 */
public class MaxTest {

	/**.
	 * Тестирование класса Max метод метод наибольшего из двух.
	 */
	@Test
	public void whenAddTwoThenMaximum() {
		Max obj = new Max();
		int result = obj.max(1, 2);
		int expected = 2;
		assertThat(result, is(expected));
	}

	/**.
	 * Testing class Max function maximum of three.
	 */
	@Test
	public void whenAddThreeThenMaximum() {
		Max obj = new Max();
		int result = obj.max(1, 2, 3);
		int expected = 3;
		assertThat(result, is(expected));
	}
}