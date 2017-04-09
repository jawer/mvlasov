package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 3.26.2017
 */
public class CalculateTest {

	/**.
	 * Class CalculateTest
	 * @param none
	 */
	@Test
	public void whenAddOneToOneThenTwo() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(
			out.toString(),
			is(
				String.format(
				"Hello World!%s",
				System.getProperty("line.separator")
				)
			)
		);
	}
}