package ru.job4j.simpleset;
import ru.job4j.simplearraylist.SimpleArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class SimpleArraySet implements simple set based on array.
 * @author Mikhail Vlasov
 * @since 03.29.2018
 * @version 1
 */
public class SimpleArraySet<E> implements Iterable {
    /**.
     * Container.
     */
    private SimpleArrayList<E> simpleArrayList = new SimpleArrayList<E>();

    public void add(E e) {
        boolean hasEqual = false;
        for (Object value : simpleArrayList) {
            if (e.equals((E) value)) {
                hasEqual = true;
                break;
            }
        }
        if (!hasEqual) {
            simpleArrayList.add(e);
        }
    }

    /**.
     * Overrides iterator()
     * @return Iterator object.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Iterator it = simpleArrayList.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Object next() {
                try {
                    return it.next();
                } catch (Exception ex) {
                    throw new NoSuchElementException("No more elements available in Set");
                }
            }
        };
    }
}
