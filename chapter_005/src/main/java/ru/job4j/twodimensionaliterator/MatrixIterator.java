package ru.job4j.twodimensionaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class MatrixIterator implements Iterator for two-dimensional array including jugged array.
 * @author Mikhail Vlasov
 * @since 11.28.2017
 * @version 1
 */
public class MatrixIterator implements Iterator {
    /**.
     * Our array.
     */
    private final int[][] values;
    /**.
     * Coordinates in array.
     */
    private int x = 0, y = 0;

    /**.
     * Constructor.
     * @param values array.
     */
    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    /**.
     * Overriden hasNext checks if the next element exists.
     * @return boolean true if the next element exists.
     */
    @Override
    public boolean hasNext() {
        if (x == values.length || y == values[x].length) {
            throw new NoSuchElementException("Out of array bound.");
        }
        return values.length > x || values[x].length > y;
    }

    /**.
     * Overriden next returns next element if available. Otherwise throws NoSuchElementException.
     * @return Object next element.
     */
    @Override
    public Object next() {
        if (hasNext() == false) {
            throw new NoSuchElementException("Out of array bound.");
        } else if (x + 1 == values.length && y + 1 == values[x].length) {
            return values[x++][y++];
        } else if (y + 1 == values[x].length) {
            int temp = y;
            y = 0;
            return values[x++][temp];
        } else {
            return values[x][y++];
        }
    }
}
