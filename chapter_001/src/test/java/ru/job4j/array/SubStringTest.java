package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.20.2017
 */
public class SubStringTest {

	/**.
	 * Class SubStringTest testing if string contains sub string
	 */
	@Test
	public void whenAddStringAndSubStringThenContains() {
		SubString subString = new SubString();
		boolean result = subString.contains("123456", "345");
		boolean expected = true;
		assertThat(result, is(expected));
	}

	/**.
	 * Class SubStringTest testing if string not contain sub string
	 */
	@Test
	public void whenAddStringAndSubStringThenNotContain() {
		SubString subString = new SubString();
		boolean result = subString.contains("123456", "4567");
		boolean expected = false;
		assertThat(result, is(expected));
	}

	/**.
	 * Class SubStringTest testing if string contain sub string
	 */
	@Test
	public void whenAddStringAndSubStringOfOneThenContains() {
		SubString subString = new SubString();
		boolean result = subString.contains("123456", "6");
		boolean expected = true;
		assertThat(result, is(expected));
	}

	/**.
	 * Class SubStringTest testing if string not contain sub string
	 */
	@Test
	public void whenAddStringAndSubStringOfOneThenNotContain() {
		SubString subString = new SubString();
		boolean result = subString.contains("123456", "8");
		boolean expected = false;
		assertThat(result, is(expected));
	}

	/**.
	 * Class SubStringTest testing if substring bigger than string
	 */
	@Test
	public void whenAddStringAndBiggerSubStringThenNotContain() {
		SubString subString = new SubString();
		boolean result = subString.contains("123456", "1234567");
		boolean expected = false;
		assertThat(result, is(expected));
	}

	/**.
	 * Class SubStringTest testing if string has same size as substring
	 */
	@Test
	public void whenAddStringAndStringThenContain() {
		SubString subString = new SubString();
		boolean result = subString.contains("123456", "123456");
		boolean expected = true;
		assertThat(result, is(expected));
	}
}