package ru.job4j.node;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 8.20.2017
 */
public class NodeTest {

    /**.
     * Class NodeTest testing reference change.
     */
    @Test
    public void whenConvertObjectsThenBackwardReferences() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        //1 > 2 > 3 > 4
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        //4 > 3 > 2 > 1
        Node.convert(n1);

        assertThat(n4.getNext().getNext().getNext(), is(n1));
    }
}
