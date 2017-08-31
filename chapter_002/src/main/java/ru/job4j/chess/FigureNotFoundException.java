package ru.job4j.chess;

/**.
 * class FigureNotFoundException extends Exception
 * @author Mikhail Vlasov
 * @since 8.23.2017
 * @version 1
 */
public class FigureNotFoundException extends Exception {
    /**.
     * Constructor for FigureNotFoundException.
     * @param fnfe message.
     */
    public FigureNotFoundException(String fnfe) {
        super(fnfe);
    }
}
