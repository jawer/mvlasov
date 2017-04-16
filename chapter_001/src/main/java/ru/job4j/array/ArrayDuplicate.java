package ru.job4j.array;

import static java.util.Arrays.copyOf;

/**.
 * Class ArrayDuplicate solving part 5 task 5.3
 * @author Mikhail Vlasov
 * @since 4.16.2017
 * @version 1
 */
public class ArrayDuplicate {

	/**.
	 * Duplicate removal
	 * @param array of String
	 * @return String[] array
	 */
	public String[] remove(String[] array) {
		int duplicates = 0;
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			while (j < array.length - duplicates) {
				if (array[i].equals(array[j])) {
					String temp = array[array.length - 1 - duplicates];
					array[array.length - 1 - duplicates] = array[j];
					array[j] = temp;
					duplicates++;
					j--;
				}
				j++;
			}
		}
		return copyOf(array, array.length - duplicates);
	}
}