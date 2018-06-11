package ru.job4j.simpletree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**.
 * Class TreeTest tests Tree class.
 * @author Mikhail Vlasov
 * @since 04.06.2018
 * @version 1
 */
public class TreeTest {
    /**.
     * Tests if bottom node exists.
     */
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**.
     * Checks not existing node.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**.
     * Tests iterator().
     */
    @Test
    public void whenAddElThenIteratorWorksOk() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        tree.add(5, 7);

        Iterator<Node<Integer>> iter = tree.iterator();

        assertThat(iter.next().getValue(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(3));
        assertThat(iter.next().getValue(), is(4));
        assertThat(iter.next().getValue(), is(5));
        assertThat(iter.next().getValue(), is(6));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(7));
        assertThat(iter.hasNext(), is(false));
    }

    /**.
     * Tests if binary.
     */
    @Test
    public void whenCheckBinaryThenWorksOk() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        tree.add(5, 7);

        Tree<Integer> binTree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        tree.add(5, 7);

        assertThat(tree.isBinary(), is(false));
        assertThat(binTree.isBinary(), is(true));
    }

    /**.
     * Tests binary tree.
     */
    @Test
    public void whenAddElThenHaveIt() {
        BinaryTree<Integer> bTree = new BinaryTree<>(5);
        bTree.add(4);
        bTree.add(6);
        bTree.add(3);
        bTree.add(5);
        bTree.add(7);
        bTree.add(6);

        Iterator<BinaryTree.NodeB<Integer>> iter = bTree.iterator();

        assertThat(iter.next().getValue(), is(5));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(4));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(6));
        assertThat(iter.next().getValue(), is(3));
        assertThat(iter.next().getValue(), is(5));
        assertThat(iter.next().getValue(), is(6));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(7));
        assertThat(iter.hasNext(), is(false));
    }
}