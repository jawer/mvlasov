package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.11.2017
 */
public class RotateArrayTest {

	/**.
	 * Class RotateArrayTest testing array 2x2 clockwise rotation
	 */
	@Test
	public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] resultArray = rotateArray.rotate(new int[][] {{1, 2}, {3, 4}});
		int[][] expectedArray = new int[][] {{3, 1}, {4, 2}};
		assertThat(resultArray, is(expectedArray));
	}

	/**.
	 * Class RotateArrayTest testing array 3x3 clockwise rotation
	 */
	@Test
	public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] resultArray = rotateArray.rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		int[][] expectedArray = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(resultArray, is(expectedArray));
	}
}