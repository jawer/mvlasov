package ru.job4j.array;

/**.
 * Class ArrayMerger solving part 6 additional task 2
 * @author Mikhail Vlasov
 * @since 4.22.2017
 * @version 1
 */
public class ArrayMerger {

	/**.
	 * Two arrays merger with sorting
	 * @param arrayOne first array
	 * @param arrayTwo second array
	 * @return int[] array of two sorted arrays
	 */
	int[] merge(int[] arrayOne, int[] arrayTwo) {
		int[] arrayOfTwo = new int[arrayOne.length + arrayTwo.length];
		int indexOne = 0, indexTwo = 0;
			for (int i = 0; i < arrayOfTwo.length; i++) {
				if (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
					if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
						arrayOfTwo[i] = arrayOne[indexOne];
						indexOne++;
					} else {
						arrayOfTwo[i] = arrayTwo[indexTwo];
						indexTwo++;
					}
				} else if (indexOne < arrayOne.length) {
					arrayOfTwo[i] = arrayOne[indexOne];
					indexOne++;
				} else  if (indexTwo < arrayTwo.length) {
					arrayOfTwo[i] = arrayTwo[indexTwo];
					indexTwo++;
				}
			}
		return arrayOfTwo;
	}
}