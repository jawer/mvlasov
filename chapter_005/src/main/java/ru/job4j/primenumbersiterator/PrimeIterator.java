package ru.job4j.primenumbersiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.sqrt;

/**.
 * Class PrimeIterator implements Iterator for prime numbers.
 * @author Mikhail Vlasov
 * @since 03.07.2018
 * @version 1
 */
public class PrimeIterator implements Iterator {
    /**.
     * Our array.
     */
    private int[] numbers;
    /**.
     * An index in the array.
     */
    private int x;

    /**.
     * Constructor.
     * @param numbers array.
     */
    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**.
     * Overriden hasNext checks if the next prime number exists.
     * @return boolean true if the prime number exists.
     */
    @Override
    public boolean hasNext() {
        int tempIndex = x;

        while (tempIndex < numbers.length && !isPrimeNumAvailable(numbers[tempIndex])) {
            tempIndex++;
        }
        return tempIndex < numbers.length;
    }

    /**.
     * Overriden next returns next prime number if available. Otherwise throws NoSuchElementException.
     * @return Object next element.
     */
    @Override
    public Object next() {
        while (hasNext()) {
            if (isPrimeNumAvailable(numbers[x])) {
                return numbers[x++];
            }
            x++;
        }
        throw new NoSuchElementException("Out of array bound.");
    }

    /**.
     * Looks for first available divisor of the square root of the number. If divisor found then returns false.
     * Otherwise returns true.
     * @param endNum int the number we looking a divisor for.
     * @return boolean true if we got prime number.
     */
    private boolean isPrimeNumAvailable(int endNum) {
        //Метка, если простое число найдено.
        boolean primeNumFound = false;

        //2 и 3 - простые числа.
        if (endNum == 2 || endNum == 3) {
            return true;
        }

        for (int j = 2; j <= sqrt(endNum); j++) {
            if (endNum % j == 0) {
                return false;
            }
            primeNumFound = true;
        }
        return primeNumFound;
    }
}
