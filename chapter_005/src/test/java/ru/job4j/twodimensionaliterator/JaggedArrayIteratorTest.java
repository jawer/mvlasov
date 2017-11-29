package ru.job4j.twodimensionaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**.
 * Class JaggedArrayIteratorTest tests jagged array iterator.
 * @author Mikhail Vlasov
 * @since 11.28.2017
 * @version 1
 */
public class JaggedArrayIteratorTest {

    /**.
     * Iterator variable.
     */
    private Iterator<Integer> it;

    /**.
     * Variable setup.
     */
    @Before
    public void setUp() {
        it = new MatrixIterator(new int[][]{{1}, {3, 4}});
    }

    /**.
     * Tests that next() method doesn't depends on prior invocation.
     */
    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }

    /**.
     * Tests that sequential hasNext() invocation doesn't affect on retrieval order.
     */
    @Test(expected = NoSuchElementException.class)
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }

    /**.
     * Tests sequential hasNext() and next() invocation.
     */
    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
