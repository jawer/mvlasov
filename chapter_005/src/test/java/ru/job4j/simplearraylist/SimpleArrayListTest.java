package ru.job4j.simplearraylist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**.
 * Class SimpleArrayListTest test SimpleArrayList class.
 * @author Mikhail Vlasov
 * @since 03.24.2018
 * @version 1
 */
public class SimpleArrayListTest {
    /**.
     * Tests add().
     */
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<>();

        simpleArrayList.add("test1");

        assertThat(simpleArrayList.get(0), is("test1"));
    }

    /**.
     * Tests growCapacity().
     */
    @Test
    public void whenAddMoreObjectsToTheContainerShouldGrow() {
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<>();

        for (int i = 0; i < 12; i++) {
            simpleArrayList.add(String.format("test%d", i));
        }

        assertThat(simpleArrayList.getSize(), is(20));
        assertThat(simpleArrayList.get(11), is("test11"));
    }

    /**.
     * Tests get().
     */
    @Test
    public void whenGetObjectShouldReturnCorrectValue() {
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<>();

        for (int i = 0; i < 12; i++) {
            simpleArrayList.add(String.format("test%d", i));
        }

        assertThat(simpleArrayList.get(7), is("test7"));
        assertThat(simpleArrayList.get(8), is("test8"));
        assertThat(simpleArrayList.get(3), is("test3"));
        assertThat(simpleArrayList.get(0), is("test0"));
        assertThat(simpleArrayList.get(11), is("test11"));
        assertThat(simpleArrayList.get(7), is("test7"));
    }

    /**.
     * Tests thad hasNext() and next() don't affect each other.
     */
    @Test
    public void whenTestHasNextAndNextShouldReturnExpectedValue() {
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<String>();

        for (int i = 0; i < 5; i++) {
            simpleArrayList.add(String.format("test%d", i));
        }
        Iterator<String> iterator = simpleArrayList.iterator();

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
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<String>();

        for (int i = 0; i < 5; i++) {
            simpleArrayList.add(String.format("test%d", i));
        }
        Iterator<String> iterator = simpleArrayList.iterator();

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
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<String>();

        for (int i = 0; i < 5; i++) {
            simpleArrayList.add(String.format("test%d", i));
        }
        Iterator<String> iterator = simpleArrayList.iterator();

        assertThat(iterator.next(), is("test0"));
        assertThat(iterator.next(), is("test1"));
        simpleArrayList.add("error");
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.next(), is("test3"));
        assertThat(iterator.next(), is("test4"));
    }
}
