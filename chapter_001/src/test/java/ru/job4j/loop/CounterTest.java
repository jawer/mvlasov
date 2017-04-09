package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.8.2017
 */
public class CounterTest {

	/**.
	 * class CounterTest testing of sum between two numbers.
	 * @param none
	 */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
		Counter counter = new Counter();
		int result = counter.add(1, 10);
		int expected = 30;
		assertThat(expected, is(result));
    }
}