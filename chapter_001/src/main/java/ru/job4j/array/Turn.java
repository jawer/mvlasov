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
		for (int i = 0, j = array.length - 1; i <= j; i++, j--)	{
			if (i != j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		return array;
	}
}