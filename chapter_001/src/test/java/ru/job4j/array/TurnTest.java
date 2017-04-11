package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.10.2017
 */
public class TurnTest {

	/**.
	 * Class TurnTest turning even array backward testing
	 */
	@Test
	public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
		Turn turn = new Turn();
		int[] resultArray = turn.back(new int[]{2, 6, 1, 4});
		int[] expectedArray = new int[] {4, 1, 6, 2};
		assertThat(resultArray, is(expectedArray));
	}

	/**.
	 * Class TurnTest turning odd array backward testing
	 */
	@Test
	public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
	Turn turn = new Turn();
		int[] resultArray = turn.back(new int[]{1, 2, 3, 4, 5});
		int[] expectedArray = new int[] {5, 4, 3, 2, 1};
		assertThat(resultArray, is(expectedArray));
	}
}