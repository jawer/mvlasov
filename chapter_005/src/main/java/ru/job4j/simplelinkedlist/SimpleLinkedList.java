package ru.job4j.simplelinkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class SimpleLinkedList implements dynamic container based on linked list Node<E> node.
 * @author Mikhail Vlasov
 * @since 03.24.2018
 * @version 1
 */
public class SimpleLinkedList<E> implements Iterable {
    /**.
     * First node
     */
    private Node<E> first;
    /**.
     * Last node
     */
    private Node<E> last;
    /**.
     * Size.
     */
    private int size = 0;
    /**.
     * Modification counter to implement fail-fast iterator.
     */
    private int modCount = 0;

    /**.
     * Adds value to the container.
     * @param value of new object.
     */
    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(last, value, null);
        last = newNode;
        if (first == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /**.
     * Gets value by index.
     * @return E value.
     */
    public E get(int index) {
        Node<E> check;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        if (index < size / 2) {
            check = first;
            for (int i = 0; i < index; i++) {
                check = check.next;
            }
            return check.item;
        } else {
            check = last;
            for (int i = size - 1; i > index; i--) {
                check = check.prev;
            }
            return check.item;
        }
    }

    /**.
     * Private static class Node implements linked list.
     */
    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E item;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    /**.
     * Overrides iterator()
     * @return Iterator object.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int expectedModCount = modCount;
            private int i = 0;
            Node<E> f = first;
            Node<E> l;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Container was modified.");
                }
                return i < size;
            }

            @Override
            public E next() {
                while (hasNext()) {
                    if (expectedModCount != modCount) {
                        throw new ConcurrentModificationException("Container was modified.");
                    }
                    l = f;
                    f = f.next;
                    i++;
                    return (E) l.item;
                }
                throw new NoSuchElementException("No element available");
            }
        };
    }
}
