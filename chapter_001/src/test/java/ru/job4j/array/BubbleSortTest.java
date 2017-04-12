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
public class BubbleSortTest {

	/**.
	 * Class BubbleSortTest testing bubble sort
	 */
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort bubbleSort = new BubbleSort();
		int[] resultArray = bubbleSort.sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
		int[] expectedArray = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
		assertThat(resultArray, is(expectedArray));
	}
}