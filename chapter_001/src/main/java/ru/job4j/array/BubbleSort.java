package ru.job4j.array;

/**.
 * Class Counter solving part 5 task 5.1
 * @author Mikhail Vlasov
 * @since 4.11.2017
 * @version 1
 */
public class BubbleSort {

	/**.
	 * Bubble sort
	 * @param array of int
	 * @return int[] array
	 */
	public int[] sort(int[] array) {
		boolean arrayIsNotSorted;
		do {
			int temp;
			arrayIsNotSorted = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1] > array[i]) {
					temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
					arrayIsNotSorted = true;
				}
			}
		} while (arrayIsNotSorted);
		return array;
	}
}