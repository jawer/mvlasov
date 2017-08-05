package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**.
 * Class PaintTest testing
 * @author Mikhail Vlasov
 * @since 8.5.2017
 * @version 1
 */
public class PaintTest {
    /**.
     * Tests square drawing.
     */
    @Test
    public void whenCreateSquareThenDrawSquare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Paint paint = new Paint();
        paint.draw(new Square());

        StringBuilder square = new StringBuilder();
        square.append("#####");
        square.append("#####");
        square.append("#####");
        square.append("#####");
        square.append("#####");

        assertThat(out.toString(), is(square.toString()));
    }

    /**.
     * Tests triangle drawing.
     */
    @Test
    public void whenCreateTriangleThenDrawTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Paint paint = new Paint();
        paint.draw(new Triangle());

        StringBuilder triangle = new StringBuilder();
        triangle.append("  #  ");
        triangle.append(" ### ");
        triangle.append("#####");

        assertThat(out.toString(), is(triangle.toString()));
    }
}
