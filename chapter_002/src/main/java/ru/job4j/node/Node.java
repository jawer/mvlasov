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
     * Getter
     * @return int value.
     */
    public int getValue() {
        return value;
    }

    /**.
     * Converts 1 > 2 > 3 to 3 >  2 > 1.
     * Перебираем все элементы списка и на каждой итерации меняем значение поля next так,
     * чтобы оно указывало на предыдущий элемент.
     * @param root object.
     */
    static void convert(Node root) {
        int counter = 0;
        Node nextNode = root;
        Node previousNode = root;
        Node currentNode = root;
        while (nextNode != null) {
            //Если первый элемент списка, то:
            if (counter == 0) {
                nextNode = currentNode.getNext();
                currentNode.setNext(null);
            //Иначе для всех последующих элементов:
            } else {
                currentNode = nextNode;
                nextNode = currentNode.getNext();
                currentNode.setNext(previousNode);
                previousNode = currentNode;
            }
            counter++;
        }
    }
}
