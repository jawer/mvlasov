package ru.job4j.simplearray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class SimpleArray implements simple array list and interface Iterable.
 * @author Mikhail Vlasov
 * @since 03.19.2018
 * @version 1
 */
public class SimpleArray<T> implements Iterable<T> {
    Object[] objects;
    int index = 0;

    /**.
     * Constructor.
     * @param size of the new container.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**.
     * Adds new element.
     * @param model new element.
     */
    public void add(T model) {
        this.objects[index++] = model;
    }

    /**.
     * Sets new value for specific index.
     * @param index of element.
     * @param model value of new element.
     */
    public void set(int index, T model) {
        this.objects[index] = model;
    }

    /**.
     * Deletes element by index.
     * @param index of the element.
     */
    public void delete(int index) {
        System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - index - 1);
        objects[--this.index] = null;
    }

    /**.
     * Gets an element by index.
     * @param index of the element.
     * @return T element.
     */
    public T get(int index) {
        return (T) this.objects[index];
    }

    /**.
     * Overrides iterator.
     * @return Iterator<T> iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < index;
            }

            @Override
            public T next() {
                while (hasNext()) {
                    return (T) objects[i++];
                }
                throw new NoSuchElementException("No element available");
            }
        };
    }
}
