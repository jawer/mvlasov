package ru.job4j.simplelinkedlist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**.
 * Class SimpleLinkedListTest test SimpleLinkedList class.
 * @author Mikhail Vlasov
 * @since 03.24.2018
 * @version 1
 */
public class SimpleLinkedListTest {
    /**.
     * Tests add().
     */
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();

        simpleLinkedList.add("test1");

        assertThat(simpleLinkedList.get(0), is("test1"));
    }

    /**.
     * Tests get().
     */
    @Test
    public void whenGetObjectShouldReturnCorrectValue() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();

        for (int i = 0; i < 12; i++) {
            simpleLinkedList.add(String.format("test%d", i));
        }

        assertThat(simpleLinkedList.get(7), is("test7"));
        assertThat(simpleLinkedList.get(8), is("test8"));
        assertThat(simpleLinkedList.get(3), is("test3"));
        assertThat(simpleLinkedList.get(0), is("test0"));
        assertThat(simpleLinkedList.get(11), is("test11"));
        assertThat(simpleLinkedList.get(7), is("test7"));
    }

    /**.
     * Tests that hasNext() and next() don't affect each other.
     */
    @Test
    public void whenTestHasNextAndNextShouldReturnExpectedValue() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();

        for (int i = 0; i < 5; i++) {
            simpleLinkedList.add(String.format("test%d", i));
        }
        Iterator<String> iterator = simpleLinkedList.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test0"));
        assertThat(iterator.next(), is("test1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test3"));
        assertThat(iterator.next(), is("test4"));
        assertThat(iterator.hasNext(), is(false));
    }

    /**.
     * Tests NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenEndOfListAndGetNextShouldThrowException() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();

        for (int i = 0; i < 5; i++) {
            simpleLinkedList.add(String.format("test%d", i));
        }
        Iterator<String> iterator = simpleLinkedList.iterator();

        assertThat(iterator.next(), is("test0"));
        assertThat(iterator.next(), is("test1"));
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.next(), is("test3"));
        assertThat(iterator.next(), is("test4"));
        iterator.next();
    }

    /**.
     * Tests ConcurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenListChangedWhileWorkingIteratorShouldThrowException() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();

        for (int i = 0; i < 5; i++) {
            simpleLinkedList.add(String.format("test%d", i));
        }
        Iterator<String> iterator = simpleLinkedList.iterator();

        assertThat(iterator.next(), is("test0"));
        assertThat(iterator.next(), is("test1"));
        simpleLinkedList.add("error");
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.next(), is("test3"));
        assertThat(iterator.next(), is("test4"));
    }
}
