package ru.job4j.mapdiscovery;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.abs;

/**.
 * Class SimpleHashMap implements simple HashMap by using hash table without java.util.*.
 * @author Mikhail Vlasov
 * @since 20.05.2018
 * @version 1
 */
public class SimpleHashMap<K, V> implements Iterable {
    /**.
     * TABLE.
     */
    private SimpleHashMap.Node<K, V>[] table;
    /**.
     * Size of the TABLE.
     */
    private int size;
    /**.
     * Counter of values in the TABLE.
     */
    private int index = 0;

    /**.
     * Constructor.
     */
    public SimpleHashMap() {
        this.size = 10;
        this.table = new SimpleHashMap.Node[size];
    }

    /*public SimpleHashMap.Node<K, V>[] getTable() {
        return table;
    }*/

    /**.
     * Проверяем, если таблица почти заполнена.
     * @param nextIndex next element to be checked.
     */
    private void checkCapacity(int nextIndex) {
        if (nextIndex == size) {
            growCapacity();
        }
    }

    /**.
     * Увеличиваем размер в 2 раза.
     */
    private void growCapacity() {
        size *= 2;
        table = Arrays.copyOf(table, size);
    }

    /**.
     * Inserts value into the TABLE.
     * @param key of the value.
     * @param value itself.
     * @return boolean false if the key already exists.
     */
    public boolean insert(K key, V value) {
        checkCapacity(index);
        int hashCode = hashFunction(key, size);

        if (!contains(key)) {
            table[hashCode] = new Node(key, value);
            index++;
            return true;
        }

        return false;
    }

    /**.
     * Checks by key if the TABLE contains specific value.
     * @param key of the value.
     * @return boolean false if not existing.
     */
    public boolean contains(K key) {
        int temSize = size;

        do {
            int hashIndex = hashFunction(key, temSize);
            if (table[hashIndex] != null && key.equals(table[hashIndex].getKey())) {
                return true;
            }
            temSize /= 2;
        } while (temSize != 1);

        return false;
    }

    /**.
     * Creates hash code by key and current TABLE size.
     * @param key of the value.
     * @param tabSize TABLE size.
     * @return int hash code.
     */
    private int hashFunction(K key, int tabSize) {
        return abs(key.hashCode()) % tabSize;
    }

    /**.
     * Gets value by key.
     * @param key of the value.
     * @return V value.
     */
    public V get(K key) {
        if (contains(key)) {
            int temSize = size;

            do {
                int hashIndex = hashFunction(key, temSize);
                if (table[hashIndex] != null && key.equals(table[hashIndex].getKey())) {
                    return table[hashIndex].getValue();
                }
                temSize /= 2;
            } while (temSize != 1);
        }
        throw new NoSuchElementException(String.format("No element exists by this key: %s", key));
    }

    /**.
     * Deletes a pair by key.
     * @param key of the value.
     * @return boolean false if no value exists.
     */
    public boolean delete(K key) {
            //Gets value by index to be removed in case of growing capacity of the SimpleMap.
            if (contains(key)) {
                int temSize = size;

                do {
                    int hashIndex = hashFunction(key, temSize);
                    //If index found.
                    if (table[hashIndex] != null && key.equals(table[hashIndex].getKey())) {
                        table[hashIndex] = null;
                        return true;
                    }
                    temSize /= 2;
                } while (temSize != 1);
            }
            return false;
    }

    /**.
     * Class Node describes sequence of a pair of key and value.
     */
    static class Node<K, V> {
        /**.
         * Key.
         */
        final K key;
        /**.
         * Value.
         */
        V value;

        /**.
         * Constructor.
         * @param key of the value.
         * @param value itself.
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**.
         * Gets a key.
         * @return K key.
         */
        public K getKey() {
            return key;
        }

        /**.
         * Gets a value.
         * @return V value.
         */
        public V getValue() {
            return value;
        }
    }

    /**.
     * Overrides iterator().
     * @return Iterator new object.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            int indx = 0;
            @Override
            public boolean hasNext() {
                int i = indx;
                for (int j = i; j < size; j++) {
                    if (table[j] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    for (int j = indx; j < size; j++) {
                        if (table[j] != null) {
                            indx++;
                            return table[indx - 1];
                        }
                    }
                }
                throw new NoSuchElementException("No more elements available.");
            }
        };
    }
}
