package ru.job4j.simplearray;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class SimpleArrayTest test SimpleArray class.
 * @author Mikhail Vlasov
 * @since 03.19.2018
 * @version 1
 */
public class SimpleArrayTest {
    /**.
     * Tests add().
     */
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(10);

        simpleArray.add("test1");

        assertThat(simpleArray.get(0), is("test1"));
    }

    /**.
     * Tests set().
     */
    @Test
    public void whenSetValueShouldReturnTheSameValue() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(10);

        simpleArray.add("test1");
        simpleArray.set(0, "test2");

        assertThat(simpleArray.get(0), is("test2"));
    }

    /**.
     * Tests delete().
     */
    @Test
    public void whenDeleteValueShouldReturnNull() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(10);

        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.delete(0);

        assertThat(simpleArray.get(0), is("test2"));
    }

    /**.
     * Tests get().
     */
    @Test
    public void whenGetValueShouldReturnExpectedValue() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(10);

        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");

        assertThat(simpleArray.get(2), is("test3"));
    }

    /**.
     * Tests iterator(). Makes sure that hasNext() and next() don't depend on each other.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTestHasNextAndNextShouldReturnExpectedValue() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(10);

        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        Iterator<String> iterator = simpleArray.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test1"));
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test3"));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
}
