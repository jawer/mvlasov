package ru.job4j.max;

/**.
 * Class Max solving part 3 task 3.4
 * @author Mikhail Vlasov
 * @since 4.8.2017
 * @version 1
 */
public class Max {

	/**.
	 * Determine maximum of three numbers
	 * @param first number
	 * @param second number
	 * @param third number
	 * @return int maximum
	 */
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}

	/**
	 * Определяет максимальное из двух чисел.
	 * @param first первое число
	 * @param second второе число
	 * @return int большее из двух чисел
	 */
	public int max(int first, int second) {
		return first >= second ? first : second;
	}
}