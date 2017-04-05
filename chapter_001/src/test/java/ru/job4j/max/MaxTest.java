package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.4.2017
 */
public class MaxTest {

	/**.
	 * Тестирование класса Max метод метод наибольшего из двух.
	 * @param none
	 */
	@Test
	public void whenAddTwoThenMaximum() {
		Max obj = new Max();
		int result = obj.max(1, 2);
		int expected = 2;
		assertThat(result, is(expected));
	}
}