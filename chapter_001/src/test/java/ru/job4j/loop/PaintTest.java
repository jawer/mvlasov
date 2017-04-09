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
public class PaintTest {

	/**.
	 * class PaintTest 2 storey piramid testing function
	 */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
		Paint paint = new Paint();
		String result = paint.piramid(2);
		String expected = String.format(" ^ %s^^^", System.getProperty("line.separator"));
		assertThat(result, is(expected));
    }

	/**.
	 * class PaintTest 3 storey piramid testing function
	 */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
		Paint paint = new Paint();
		String result = paint.piramid(3);
		String expected = String.format("  ^  %s ^^^ %s^^^^^", System.getProperty("line.separator"), System.getProperty("line.separator"));
		assertThat(result, is(expected));
    }
}