package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 4.2.2017
 */
public class CalculatorTest {

	/**.
	 * Тестирование класса Calculator метод сложения.
	 * @param none
	 */
	@Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

	/**.
	 * Тестирование класса Calculator метод вычитания.
	 * @param none
	 */
	@Test
    public void whenAddOnePlusOneThenSubtructed() {
        Calculator calc = new Calculator();
        calc.substruct(1D, 1D);
        double result = calc.getResult();
        double expected = 1D - 1D;
        assertThat(result, is(expected));
    }

	/**.
	 * Тестирование класса Calculator метод деления.
	 * @param none
	 */
	@Test
    public void whenAddOnePlusOneThenDiveded() {
        Calculator calc = new Calculator();
        calc.div(1D, 1D);
        double result = calc.getResult();
        double expected = 1D / 1D;
        assertThat(result, is(expected));
    }

	/**.
	 * Тестирование класса Calculator метод умножения.
	 * @param none
	 */
	@Test
    public void whenAddOnePlusOneThenMultiplied() {
        Calculator calc = new Calculator();
        calc.multiple(1D, 1D);
        double result = calc.getResult();
        double expected = 1D * 1D;
        assertThat(result, is(expected));
    }
}