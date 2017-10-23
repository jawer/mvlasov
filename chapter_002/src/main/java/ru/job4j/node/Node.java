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
     * @param root object.
     */
    static void convert(Node root) {
        //root.setNext(this);
        //Считаем сколько в списке объектов.
        Node first = root;
        Node current = root;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != null);

        //Создаём массив по количеству объектов в списке и заполняем его в обратном порядке.
        //1 > 2 > 3 => {3, 2, 1}
        Node[] nodeArray = new Node[count];
        current = first;
        do {
            nodeArray[count - 1] = current;
            current = current.next;
            count--;
        } while (current != null);

        //Связываем элементы массива в список: 3 > 2 > 1.
        for (int i = 0; i < nodeArray.length - 1; i++) {
            nodeArray[i].next = nodeArray[i + 1];
        }

        //Последний элемент указывает на null.
        nodeArray[nodeArray.length - 1].next = null;
    }
}
