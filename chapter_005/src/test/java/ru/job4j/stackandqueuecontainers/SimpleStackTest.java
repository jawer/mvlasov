package ru.job4j.stackandqueuecontainers;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**.
 * Class SimpleStackTest test SimpleStack class.
 * @author Mikhail Vlasov
 * @since 03.25.2018
 * @version 1
 */
public class SimpleStackTest {
    /**.
     * Tests add().
     */
    @Test
    public void whenCreateStackShouldReturnTheSameType() {
        SimpleStack<String> simpleStack = new SimpleStack<>();

        simpleStack.push("test1");

        assertThat(simpleStack.poll(), is("test1"));
    }

    /**.
     * Tests get().
     */
    @Test
    public void whenGetObjectShouldReturnCorrectValue() {
        SimpleStack<String> simpleStack = new SimpleStack<>();

        for (int i = 0; i < 5; i++) {
            simpleStack.push(String.format("test%d", i));
        }

        assertThat(simpleStack.poll(), is("test4"));
        assertThat(simpleStack.poll(), is("test3"));
        assertThat(simpleStack.poll(), is("test2"));
        assertThat(simpleStack.poll(), is("test1"));
        assertThat(simpleStack.poll(), is("test0"));
    }

    /**.
     * Tests NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenEndOfStackAndGetNextShouldThrowException() {
        SimpleStack<String> simpleStack = new SimpleStack<>();

        for (int i = 0; i < 5; i++) {
            simpleStack.push(String.format("test%d", i));
        }

        assertThat(simpleStack.poll(), is("test4"));
        assertThat(simpleStack.poll(), is("test3"));
        assertThat(simpleStack.poll(), is("test2"));
        assertThat(simpleStack.poll(), is("test1"));
        assertThat(simpleStack.poll(), is("test0"));
        simpleStack.poll();
    }
}
