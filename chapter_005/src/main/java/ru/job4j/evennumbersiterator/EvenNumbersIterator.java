package ru.job4j.evennumbersiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class EvenNumbersIterator implements Iterator for even numbers.
 * @author Mikhail Vlasov
 * @since 03.06.2018
 * @version 3
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
        int tempIndex = x;

        while (tempIndex < values.length && values[tempIndex] % 2 != 0) {
            tempIndex++;
        }
        return tempIndex < values.length;
    }

    /**.
     * Overriden next returns next even number if available. Otherwise throws NoSuchElementException.
     * @return Object next element.
     */
    @Override
    public Object next() {
       while (hasNext()) {
           if (values[x] % 2 == 0) {
               return values[x++];
           }
           x++;
       }
       throw new NoSuchElementException("Out of array bound.");
    }
}
