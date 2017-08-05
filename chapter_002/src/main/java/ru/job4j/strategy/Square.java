package ru.job4j.strategy;

/**.
 * Class Square describes square
 * @author Mikhail Vlasov
 * @since 8.5.2017
 * @version 1
 */
public class Square implements Shape {
    /**.
     * Defines square.
     * @return String square.
     */
    public String pic() {
        StringBuilder square = new StringBuilder();
        square.append("#####");
        square.append("#####");
        square.append("#####");
        square.append("#####");
        square.append("#####");
        return square.toString();
    }
}
