package ru.job4j.stackandqueuecontainers;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**.
 * Class SimpleQueueTest test SimpleQueue class.
 * @author Mikhail Vlasov
 * @since 03.25.2018
 * @version 1
 */
public class SimpleQueueTest {
    /**.
     * Tests add().
     */
    @Test
    public void whenCreateQueueShouldReturnTheSameType() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();

        simpleQueue.push("test1");

        assertThat(simpleQueue.poll(), is("test1"));
    }

    /**.
     * Tests get().
     */
    @Test
    public void whenGetObjectShouldReturnCorrectValue() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();

        for (int i = 0; i < 5; i++) {
            simpleQueue.push(String.format("test%d", i));
        }

        assertThat(simpleQueue.poll(), is("test0"));
        assertThat(simpleQueue.poll(), is("test1"));
        assertThat(simpleQueue.poll(), is("test2"));
        assertThat(simpleQueue.poll(), is("test3"));
        assertThat(simpleQueue.poll(), is("test4"));
    }

    /**.
     * Tests NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenEndOfQueueAndGetNextShouldThrowException() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();

        for (int i = 0; i < 5; i++) {
            simpleQueue.push(String.format("test%d", i));
        }

        assertThat(simpleQueue.poll(), is("test0"));
        assertThat(simpleQueue.poll(), is("test1"));
        assertThat(simpleQueue.poll(), is("test2"));
        assertThat(simpleQueue.poll(), is("test3"));
        assertThat(simpleQueue.poll(), is("test4"));
        simpleQueue.poll();
    }
}
