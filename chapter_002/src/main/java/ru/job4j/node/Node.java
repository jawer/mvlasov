package ru.job4j.node;

/**.
 * Class Node make a list from its objects
 * @author Mikhail Vlasov
 * @since 8.20.2017
 * @version 1
 */
public class Node {
    /**.
     * Keep reference to the next object.
     */
    private Node next;
    /**.
     * Node id
     */
    private int value;

    /**.
     * Constructor
     * @param value id of the Node
     */
    public Node(int value) {
        this.value = value;
    }

    /**.
     * Setter
     * @param next Node.
     */
    void setNext(Node next) {
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
     * Converts Node to be root.
     * @param root object.
     */
    void convert(Node root) {
        root.setNext(this);
    }
}
