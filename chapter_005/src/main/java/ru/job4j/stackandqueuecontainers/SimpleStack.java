package ru.job4j.stackandqueuecontainers;

import ru.job4j.simplelinkedlist.SimpleLinkedList;

import java.util.NoSuchElementException;

/**.
 * Class SimpleStack uses container based on linked list creates simple stack container.
 * @author Mikhail Vlasov
 * @since 03.25.2018
 * @version 1
 */
public class SimpleStack<T> {
    /**.
     * SimpleLinkedList container.
     */
    private SimpleLinkedList<T> lnkList  = new SimpleLinkedList<>();
    /**.
     * Size.
     */
    private int index = 0;

    /**.
     * Constructor.
     */
    public SimpleStack() {
    }

    /**.
     * Gets SimpleLinkedList container for testing purpose.
     */
    public SimpleLinkedList<T> getSimpleLinkedList() {
        return lnkList;
    }

    /**.
     * Pushes new value into stack.
     * @param value object.
     */
    public void push(T value) {
        lnkList.add(value);
        index++;
    }

    /**.
     * Polls first value based on LIFO - last input, first output.
     * @return T value.
     */
    public T poll() {
        if (index == 0) {
            throw new NoSuchElementException("The stack is empty.");
        }
        return remove(index--);
    }

    /**.
     * Removes polled value from the stack.
     * @param index value.
     * @return T value.
     */
    private T remove(int index) {
        SimpleLinkedList<T> temp = new SimpleLinkedList<>();
        for (int i = 0; i < index - 1; i++) {
            temp.add(lnkList.get(i));
        }
        T removedValue = lnkList.get(index - 1);
        lnkList = temp;
        return removedValue;
    }
}
