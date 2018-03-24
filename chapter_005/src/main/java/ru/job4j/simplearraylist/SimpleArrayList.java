package ru.job4j.simplearraylist;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class SimpleArrayList implements dynamic list based on array.
 * @author Mikhail Vlasov
 * @since 03.24.2018
 * @version 1
 */
public class SimpleArrayList<E> implements Iterable {
    /**.
     * Container.
     */
    private Object[] container;
    /**.
     * Current size of the container.
     */
    private int size;
    /**.
     * Next available index to add new object.
     */
    private int index = 0;

    /*Счётчик изменений для реализации fail-fast поведения итератора.
    * Если с момента создания итератора коллекция подверглась структурному изменению,
    * итератор должен кидать ConcurrentModificationException.
    * Каждая операция, которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
    * В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount),
    * а затем на каждой итерации сравнивает сохраненное значение, с текущим значением поля modCount,
    * если они отличаются, то генерируется исключение.
    */
    private int modCount = 0;

    /**.
     * Constructor.
     */
    public SimpleArrayList() {
        this.size = 10;
        this.container = new Object[size];
    }

    /**.
     * Проверяем, если контейнер почти заполнен.
     * @param nexIndex next element to be checked.
     */
    private void checkCapacity(int nexIndex) {
        if (nexIndex == size) {
            growCapacity();
        }
    }

    /**.
     * Увеличиваем размер в 2 раза.
     */
    private void growCapacity() {
        size *= 2;
        container = Arrays.copyOf(container, size);
        modCount++;
    }

    /**.
     * Gets size of the container.
     */
    public int getSize() {
        return size;
    }

    /**.
     * Adds value to the container.
     * @param value of new object.
     */
    public void add(E value) {
        checkCapacity(index + 1);
        container[index++] = value;
        modCount++;
    }

    /**.
     * Gets value by index.
     * @return E value.
     */
    public E get(int index) {
        return (E) container[index];
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
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Container was modified.");
                }
                return i < index;
            }

            @Override
            public E next() {
                while (hasNext()) {
                    if (expectedModCount != modCount) {
                        throw new ConcurrentModificationException("Container was modified.");
                    }
                    return (E) container[i++];
                }
                throw new NoSuchElementException("No element available");
            }
        };
    }
}
