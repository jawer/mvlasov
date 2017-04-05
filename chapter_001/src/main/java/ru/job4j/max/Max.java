package ru.job4j.max;

/**.
 * Class Max решение задачи части 3 урока 3.1
 * @author Mikhail Vlasov
 * @since 4.4.2017
 * @version 1
 */
public class Max {

	/**
	 * Определяет максимальное из двух чисел.
	 * @param first первое число
	 * @param second второе число
	 * @return int большее из двух чисел
	 */
	public int max(int first, int second) {
		int maximum;
		maximum = first >= second ? first : second;
		return maximum;
	}
}