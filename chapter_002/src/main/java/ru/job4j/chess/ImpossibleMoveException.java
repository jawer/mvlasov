package ru.job4j.chess;

/**.
 * class ImpossibleMoveException extends Exception
 * @author Mikhail Vlasov
 * @since 8.23.2017
 * @version 1
 */
public class ImpossibleMoveException extends Exception {
    /**.
     * Constructor for ImpossibleMoveException.
     * @param ime message.
     */
    public ImpossibleMoveException(String ime) {
        super(ime);
    }
}
