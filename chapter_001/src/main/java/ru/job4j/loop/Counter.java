package ru.job4j.loop;

/**.
 * Class Counter solving part 4 task 4.1
 * @author Mikhail Vlasov
 * @since 4.8.2017
 * @version 1
 */
public class Counter {

	/**.
	 * Counting the sum of even numbers between two
	 * @param start first number
	 * @param finish last number
	 * @return int summ
	 */
	public int add(int start, int finish) {
		int sumOfEvenNumbers = 0;
		for (; start <= finish; start++) {
			if (start % 2 == 0) {
				sumOfEvenNumbers += start;
			}
		}
		return sumOfEvenNumbers;
	}
}