package ru.job4j.array;

/**.
 * Class RotateArray solving part 5 task 5.2
 * @author Mikhail Vlasov
 * @since 4.13.2017
 * @version 1
 */
public class RotateArray {

	/**.
	 * Clockwise array rotation
	 * @param array of int
	 * @return int[][] array
	 */
	public int[][] rotate(int[][] array) {
		int temp;
		for (int i = 0; i < array.length / 2; i++) {
			for (int j = i; j < array.length - 1 - i; j++) {
				temp = array[i][j];
				array[i][j] = array[array.length - j - 1][i];
				array[array.length - j - 1][i] = array[array.length - i - 1][array.length - j - 1];
				array[array.length - i - 1][array.length - j - 1] = array[j][array.length - i - 1];
				array[j][array.length - i - 1] = temp;
			}
		}
		return array;
	}
}