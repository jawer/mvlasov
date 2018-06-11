package ru.job4j.simpletree;

import java.util.*;

/**.
 * Class Tree implements simple binary search tree structure.
 * @author Mikhail Vlasov
 * @since 10.06.2018
 * @version 1
 */
public class BinaryTree<E extends Comparable<E>> implements Iterable<BinaryTree.NodeB<E>> {
    /**.
     * Root of the tree.
     */
    private NodeB<E> root;
    /**.
     * Left tree.
     */
    private BinaryTree<E> left;
    /**.
     * Right tree.
     */
    private BinaryTree<E> right;
    /**.
     * Constructor.
     */
    public BinaryTree(E key) {
        root = new NodeB<>(key);
        this.left = null;
        this.right = null;
    }

    /**.
     * Gets left tree.
     * @return BinaryTree<E> tree.
     */
    public BinaryTree<E> getLeft() {
        return left;
    }

    /**.
     * Gets right tree.
     * @return BinaryTree<E> tree.
     */
    public BinaryTree<E> getRight() {
        return right;
    }

    /**.
     * Gets root of tree.
     * @return NodeB<E> node.
     */
    public NodeB<E> getRoot() {
        return root;
    }

    /**.
     * Overrides add to add new child to existing parent.
     * @param e value.
     */
    public void add(E e) {
        if (e.compareTo(this.root.getValue()) <= 0) {
            if (left != null) {
                left.add(e);
            } else {
                left = new BinaryTree<>(e);
            }
        } else if (e.compareTo(this.root.getValue()) > 0) {
            if (right != null) {
                right.add(e);
            } else {
                right = new BinaryTree<>(e);
            }
        }
    }

    /**.
     * Overrides iterator().
     * @return Iterator new object.
     */
    @Override
    public Iterator<NodeB<E>> iterator() {
        BinaryTree<E> top = this;
        Queue<BinaryTree<E>> queue = new LinkedList<>();
        List<NodeB<E>> list = new ArrayList<>();
        list.add(top.getRoot());
        do {
            if (top.getLeft() != null) {
                queue.add(top.getLeft());
            }
            if (top.getRight() != null) {
                queue.add(top.getRight());
            }
            if (!queue.isEmpty()) {
                top = queue.poll();
            }
            list.add(top.getRoot());
        } while (!queue.isEmpty());


        return new Iterator<NodeB<E>>() {
            Iterator<NodeB<E>> it = list.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public NodeB<E> next() {
                return it.next();
            }
        };
    }

    /**.
     * Inner class describes a node of the tree.
     */
    public static class NodeB<E> {
        /**.
         * Value.
         */
        private E value;

        /**.
         * Constructor.
         */
        public NodeB(E value) {
            this.value = value;
        }

        /**.
         * Gets value.
         * @return E value.
         */
        public E getValue() {
            return value;
        }
    }
}
