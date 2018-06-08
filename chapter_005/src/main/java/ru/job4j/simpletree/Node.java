package ru.job4j.simpletree;

import java.util.ArrayList;
import java.util.List;

/**.
 * Class Node implements each node of the tree.
 * @author Mikhail Vlasov
 * @since 04.06.2018
 * @version 1
 */
public class Node<E extends Comparable<E>> {
    /**.
     * List of the tree's leaves.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**.
     * Value.
     */
    private final E value;

    /**.
     * Constructor.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**.
     * Gets the value.
     * @return E value.
     */
    public E getValue() {
        return value;
    }

    /**.
     * Adds a child.
     * @param child to be added.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**.
     * Gets leaves.
     * @return List<Node<E>> of leaves.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**.
     * Compares the values.
     * @return boolean result of comparison.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
}
