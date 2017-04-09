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
public class FactorialTest {

	/**.
	 * class CounterTest factorial testing for numbers bigger than 1
	 */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(5);
		int expected = 120;
		assertThat(result, is(expected));
    }

	/**.
	 * class CounterTest factorial testing for 1
	 */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(0);
		int expected = 1;
		assertThat(result, is(expected));
    }
}