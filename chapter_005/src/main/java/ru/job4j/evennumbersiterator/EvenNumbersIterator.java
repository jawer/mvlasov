package ru.job4j.evennumbersiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class EvenNumbersIterator implements Iterator for even numbers.
 * @author Mikhail Vlasov
 * @since 03.06.2018
 * @version 1
 */
public class EvenNumbersIterator implements Iterator {
    /**.
     * Our array.
     */
    private final int[] values;
    /**.
     * An index in the array.
     */
    private int x = 0;

    /**.
     * Constructor.
     * @param values array.
     */
    public EvenNumbersIterator(int[] values) {
        this.values = values;
    }

    /**.
     * Overriden hasNext checks if the next even number exists.
     * @return boolean true if the even number exists.
     */
    @Override
    public boolean hasNext() {
        boolean isEvenNumAvailable = false;

        for (int i = x; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                isEvenNumAvailable = true;
                break;
            }
        }
        return isEvenNumAvailable;
    }

    /**.
     * Overriden next returns next even number if available. Otherwise throws NoSuchElementException.
     * @return Object next element.
     */
    @Override
    public Object next() {
        boolean evenNumFound = false;
        int tempValues = -1;

        if (!hasNext()) {
            throw new NoSuchElementException("Out of array bound.");
        }
        do {
            if (values[x] % 2 == 0) {
                tempValues = values[x++];
                evenNumFound = true;
                break;
            }
            x++;
        } while (hasNext());

        return tempValues;
    }
}
