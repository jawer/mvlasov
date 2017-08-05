package ru.job4j.strategy;

/**.
 * Class Square describes triangle
 * @author Mikhail Vlasov
 * @since 8.5.2017
 * @version 1
 */
public class Triangle implements Shape {
    /**.
     * Defines triangle.
     * @return String triangle.
     */
    public String pic() {
        StringBuilder square = new StringBuilder();
        square.append("  #  ");
        square.append(" ### ");
        square.append("#####");
        return square.toString();
    }
}
