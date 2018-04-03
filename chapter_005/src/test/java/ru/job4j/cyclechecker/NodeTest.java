package ru.job4j.cyclechecker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Class NodeTest test Node class.
 * @author Mikhail Vlasov
 * @since 03.25.2018
 * @version 1
 */
public class NodeTest {
    /**.
     * Tests not cycled nodes 1 > 2 > 3 > 4.
     */
    @Test
    public void whenCreateNodesThenCorrectOrder() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);

        n1.next(n2);
        n2.next(n3);
        n3.next(n4);

        assertThat(n1.getNext().getNext().getNext(), is(n4));
        assertThat(n1.hasCycle(n1), is(false));
    }

    /**.
     * Tests cycled nodes 1 > 2 > 3 > 4 > 1....
     */
    @Test
    public void whenCycledNodesThenGetTrue() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);

        n1.next(n2);
        n2.next(n3);
        n3.next(n4);
        n4.next(n1);

        assertThat(n1.hasCycle(n1), is(true));
    }

    /**.
     * Tests when nodes cycled in the middle 1 > 2 > 3 > 2 > 3....
     */
    @Test
    public void whenNodesCycledInTheMiddleThenGetTrue() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);

        n1.next(n2);
        n2.next(n3);
        n3.next(n2);

        assertThat(n1.hasCycle(n1), is(true));
    }
}
