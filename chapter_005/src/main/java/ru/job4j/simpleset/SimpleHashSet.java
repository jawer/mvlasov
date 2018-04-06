package ru.job4j.simpleset;

import java.util.Arrays;

import static java.lang.Math.abs;

/**.
 * Class SimpleHashSet implements simple HashSet by using hash table without java.util.*.
 * @author Mikhail Vlasov
 * @since 04.05.2018
 * @version 1
 */
public class SimpleHashSet<E> {
    /**.
     * CONTAINER.
     */
    private Object[] container;
    /**.
     * Size of the CONTAINER.
     */
    private int size;
    /**.
     * Counter for expansion purpose.
     */
    private int index = 0;

    /**.
     * Constructor.
     */
    public SimpleHashSet() {
        this.size = 10;
        this.container = new Object[size];
    }

    /**.
     * Gets CONTAINER for testing purpose.
     * @return Obgect[] array.
     */
    public Object[] getContainer() {
        return container;
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
        //multiplier *= 2;
        container = Arrays.copyOf(container, size);
    }

    /**.
     * Adds value to the CONTAINER.
     * @param e value.
     */
    public boolean add(E e) {
        checkCapacity(index);

        if (!contains(e)) {
            container[hashFunction(e)] = e;
            index++;
            return true;
        }

        return false;
    }

    private int hashFunction(E e) {
        return abs(e.hashCode()) % size;
    }

    /**.
     * Checks if array contains specific value.
     * @param e value.
     */
    public boolean contains(E e) {
        //Hash index changes each time when capacity of the CONTAINER grows,
        //Because hash index is based on current size of the CONTAINER.
        //So we need to get hash index for each previous capacity.
        //Then compare value at each hash index.
        //Алгоритмическая сложность O(k), k - количество расширений первоначального размера контейнера.
        //k много меньше n, n - размер контейнера.
        int temSize = size;

        do {
            int hashIndex = hashFunction(e);
            if (e.equals((E) container[hashIndex])) {
                size = temSize;
                return true;
            }
            size /= 2;
        } while (size != 1);

        size = temSize;

        return false;
    }

    /**.
     * Removes a value.
     * @param e value.
     */
    public boolean remove(E e) {
        //Gets value by index to be removed in case of growing capacity of the CONTAINER.
        if (contains(e)) {
            int temSize = size;

            do {
                int hashIndex = hashFunction(e);
                //If index found.
                if (e.equals((E) container[hashIndex])) {
                    size = temSize;
                    container[hashIndex] = null;
                    return true;
                }
                size /= 2;
            } while (size != 1);
        }
        return false;
    }
}