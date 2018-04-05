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
    private SimpleLinkedList<E> lnkLst = new SimpleLinkedList<E>();

    /**.
     * Adds value to the set.
     * @param e value.
     */
    public void add(E e) {
        if (!contains(e)) {
            lnkLst.add(e);
        }
    }

    /**.
     * Checks if list contains specific value.
     * @param e value.
     */
    public boolean contains(E e) {
        for (Object value : lnkLst) {
            if (e.equals((E) value)) {
                return true;
            }
        }
        return false;
    }

    /**.
     * Overrides iterator()
     * @return Iterator object.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Iterator it = lnkLst.iterator();
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
