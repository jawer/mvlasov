package ru.job4j.array;

/**.
 * Class Counter solving part 5 task 5.0
 * @author Mikhail Vlasov
 * @since 4.10.2017
 * @version 1
 */
public class Turn {

	/**.
	 * Turning array backward
	 * @param array of int
	 * @return int[] array
	 */
	public int[] back(int[] array) {
		for (int i = 0; i < array.length / 2; i++)	{
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
		return array;
	}
}