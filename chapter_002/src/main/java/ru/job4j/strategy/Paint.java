package ru.job4j.strategy;

/**.
 * Class Paint uses shape drawing function.
 * @author Mikhail Vlasov
 * @since 8.5.2017
 * @version 1
 */
public class Paint {
    /**.
     * Draws specific shape.
     * @param shape object.
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
}
