package ru.job4j.cyclechecker;

/**.
 * Class Node makes a list from its objects.
 * @author Mikhail Vlasov
 * @since 03.25.2018
 * @version 1
 */
public class Node<T> {
    /**.
     * Object counter.
     */
    private static int index = 0;
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
        setIndex();
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
     * Increases index by 1.
     */
    private static void setIndex() {
        Node.index++;
    }

    /**.
     * Gets index.
     * @return int index.
     */
    public static int getIndex() {
        return index;
    }

    /**.
     * Checks if nodes are cycled.
     * @return boolean true if cycled, false if not.
     */
    public static boolean hasCycle(Node first) {
        int counter = 0;
        Node nextNode = first;

        while (nextNode != null) {
            nextNode = nextNode.getNext();
            counter++;
            if (counter > getIndex()) {
                return true;
            }
        }

        return false;
    }
}
