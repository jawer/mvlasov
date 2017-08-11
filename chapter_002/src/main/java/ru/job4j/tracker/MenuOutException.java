package ru.job4j.tracker;

/**.
 * Class MenuOutException extends RuntimeException to handle exceptions.
 * @author Mikhail Vlasov
 * @since 8.10.2017
 * @version 1
 */
public class MenuOutException extends RuntimeException {
    /**.
     * Constructor gets exception message and sends it to parent class.
     * @param msg message.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
