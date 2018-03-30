package ru.job4j.simpleset;

import ru.job4j.simplelinkedlist.SimpleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class SimpleLinkedSet implements simple set based on linked list.
 * @author Mikhail Vlasov
 * @since 03.29.2018
 * @version 1
 */
public class SimpleLinkedSet<E> implements Iterable {
    /**.
     * Container.
     */
    private SimpleLinkedList<E> simpleLinkedList = new SimpleLinkedList<E>();

    /**.
     * Adds value to the set.
     * @param e value.
     */
    public void add(E e) {
        boolean hasEqual = false;
        for (Object value : simpleLinkedList) {
            if (e.equals((E) value)) {
                hasEqual = true;
                break;
            }
        }
        if (!hasEqual) {
            simpleLinkedList.add(e);
        }
    }

    /**.
     * Overrides iterator()
     * @return Iterator object.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Iterator it = simpleLinkedList.iterator();
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
