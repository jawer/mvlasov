package ru.job4j.simpletree;

import java.util.Optional;

/**.
 * Interface SimpleTree.
 * @author Mikhail Vlasov
 * @since 04.06.2018
 * @version 1
 */
public interface SimpleTree<E extends Comparable<E>> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);

    /**.
     * findBy searches by E value.
     * @param value is been looked for.
     * @return Optional<Node<E>> container.
     */
    Optional<Node<E>> findBy(E value);
}
