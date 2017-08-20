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

        //1 > 2 > 3
        n1.setNext(n2);
        n2.setNext(n3);

        //3 > 2 > 1
        n2.convert(n3);
        n1.convert(n2);

        assertThat(n3.getNext().getNext(), is(n1));
    }
}
