package ru.job4j.simpletree;

import java.util.*;

/**.
 * Class Tree implements simple tree structure.
 * @author Mikhail Vlasov
 * @since 04.06.2018
 * @version 1
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Iterable<Node<E>> {
    /**.
     * Root of the tree.
     */
    private Node<E> root;

    public Tree(E key) {
        root = new Node<E>(key);
    }

    /**.
     * Constructor.
     */
    public Node<E> getRoot() {
        return root;
    }

    /**.
     * Overrides add to add new child to existing parent.
     * @param parent value.
     * @param child value.
     * @return boolean when added or not.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> opt = findBy(child);
        if (opt.isPresent()) {
            return false;
        }
        opt = findBy(parent);
        opt.get().add(new Node<E>(child));
        return true;
    }

    /**.
     * Overrides findBy searches by E value.
     * @param value been looked for.
     * @return Optional<Node<E>> container.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**.
     * Overrides iterator().
     * @return Iterator new object.
     */
    @Override
    public Iterator<Node<E>> iterator() {
        return new Iterator<Node<E>>() {
            Iterator<Node<E>> it = root.leaves().iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Node<E> next() {
                return it.next();
            }
        };
    }
}
