package ru.job4j.calculator;

/**.
 * Class Calculator решение задачи части 2 урока 2.3
 * @author Mikhail Vlasov
 * @since 4.2.2017
 * @version 1
 */
public class Calculator {

	/**.
	 * Результат операции
	 */
	private double result;

	/**
	 * Сложение двух чисел.
	 * @param first первое число
	 * @param second второе число
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 * Вычитание двух чисел.
	 * @param first первое число
	 * @param second второе число
	 */
	public void substruct(double first, double second) {
		this.result = first - second;
	}

	/**
	 * Деление двух чисел.
	 * @param first первое число
	 * @param second второе число
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	 * Умножение двух чисел.
	 * @param first первое число
	 * @param second второе число
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 * Вычитание двух чисел.
	 * @return this.result результат операции над числами
	 */
	public double getResult() {
		return this.result;
	}
}