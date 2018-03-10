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
        //Метка, если простое число найдено.
        boolean isPrimeNumFound = false;

        for (int i = x; !isPrimeNumFound && i < numbers.length; i++) {
            //Проверяем, если есть числа 2 или 3 - простые числа.
            if (numbers[i] == 2 || numbers[i] == 3) {
                isPrimeNumFound = true;
                break;
            }

            //Ищем делители от 2 до квадратного корня из искомого числа.
            isPrimeNumFound = primeNumFinder(2, i);
        }
        return isPrimeNumFound;
    }

    /**.
     * Overriden next returns next prime number if available. Otherwise throws NoSuchElementException.
     * @return Object next element.
     */
    @Override
    public Object next() {
        //Результат.
        int resultNum = -1;
        //Если нет больше простых чисел, то генерируем исключение.
        if (!hasNext()) {
            throw new NoSuchElementException("Out of array bound.");
        }

        //Поиск.
        do {
            if (primeNumFinder(2, x) || numbers[x] == 2 || numbers[x] == 3) {
                resultNum = numbers[x++];
                break;
            } else {
                x++;
            }
        } while (hasNext());

        return resultNum;
    }

    /**.
     * Looks for first available divisor of the square root of the number. If divisor found then returns false.
     * Otherwise returns true.
     * @param start int first divisor.
     * @param end int the number we looking a divisor for.
     * @return boolean true if we got prime number.
     */
    private boolean primeNumFinder(int start, int end) {
        //Метка, если простое число найдено.
        boolean primeNumFound = false;
        for (int j = start; j <= sqrt(numbers[end]); j++) {
            if (numbers[end] % j == 0) {
                return false;
            }
            primeNumFound = true;
        }
        return primeNumFound;
    }
}
