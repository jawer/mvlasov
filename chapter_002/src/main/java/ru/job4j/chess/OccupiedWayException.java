package ru.job4j.chess;

/**.
 * class OccupiedWayException extends Exception
 * @author Mikhail Vlasov
 * @since 8.23.2017
 * @version 1
 */
public class OccupiedWayException extends Exception {
    /**.
     * Constructor for OccupiedWayException.
     * @param owe message.
     */
    public OccupiedWayException(String owe) {
        super(owe);
    }
}
