package ru.job4j.convertiteratoriterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class Converter implements convert function to perform iteration for inserted iterators.
 * @author Mikhail Vlasov
 * @since 03.14.2018
 * @version 1
 */
public class Converter {
    /**.
     * Internal iterator.
     */
    private Iterator<Integer> internalIt;

    /**.
     * Performs continuous iteration for all inserted iterators.
     * @param it iterator of iterators.
     * @return Iterator<Integer> iterator.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        //Setup internal iterator.
        while (it.hasNext()) {
            internalIt = it.next();
            if (internalIt.hasNext()) {
                break;
            }
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return it.hasNext() || internalIt.hasNext();
            }

            @Override
            public Integer next() {
                while (hasNext()) {
                    if (internalIt.hasNext()) {
                        return internalIt.next();
                    }
                    internalIt = it.next();
                }

                throw new NoSuchElementException("No next element.");
            }
        };
    }
}
