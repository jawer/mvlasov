package ru.job4j.cyclechecker;

/**.
 * Class Node makes a list from its objects.
 * @author Mikhail Vlasov
 * @since 03.25.2018
 * @version 1
 */
public class Node<T> {
    /**.
     * Reference to the next object.
     */
    private Node next;

    /**.
     * Node id
     */
    private Object value;

    /**.
     * Constructor
     * @param value value of the Node
     */
    public Node(T value) {
        this.value = value;
    }

    /**.
     * Setter
     * @param next Node.
     */
    void next(Node next) {
        this.next = next;
    }

    /**.
     * Getter
     * @return Node object.
     */
    Node getNext() {
        return next;
    }

    /**.
     * Getter
     * @return T value.
     */
    public T getValue() {
        return (T) value;
    }

    /**.
     * Checks if nodes are cycled based on Floyd's Tortoise and Hare algorithm.
     * @return boolean true if cycled, false if not.
     */
    public boolean hasCycle(Node first) {
        Node tortoise = first;
        Node hare = first.getNext();

        while (tortoise != hare) {
            //If current hare or next hare doesn't exist then no cycle.
            if (hare == null || hare.getNext() == null) {
                return false;
            }
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
        }
        return true;
    }
}
