package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.16.2017
 */
public class ArrayDuplicateTest {

	/**.
	 * Class ArrayDuplicateTest testing array duplicate removal
	 */
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
		String[] resultArray = arrayDuplicate.remove(new String[] {"one", "two", "three", "one", "two", "one"});
		String[] expectedArray = new String[] {"one", "two", "three"};
		assertThat(resultArray, is(expectedArray));
	}
}