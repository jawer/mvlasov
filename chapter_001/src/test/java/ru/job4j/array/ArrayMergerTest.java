package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.22.2017
 */
public class ArrayMergerTest {

	/**.
	 * Class ArrayDuplicateTest testing array duplicate removal
	 */
	@Test
	public void whenAddTwoSortedArraysThenOneMergeredSortedArray() {
		ArrayMerger arrayMerger = new ArrayMerger();
		int[] resultArray = arrayMerger.merge(new int[]{1, 3, 5, 7, 7}, new int[]{2, 4, 5, 7});
		int[] expectedArray = {1, 2, 3, 4, 5, 5, 7, 7, 7};
		assertThat(resultArray, is(expectedArray));
	}
}