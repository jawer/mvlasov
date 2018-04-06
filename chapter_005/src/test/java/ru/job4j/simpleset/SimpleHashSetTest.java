package ru.job4j.simpleset;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**.
 * Class SimpleHashSetTest tests SimpleHashSet class.
 * @author Mikhail Vlasov
 * @since 04.05.2018
 * @version 1
 */
public class SimpleHashSetTest {
    /**.
     * Tests add().
     */
    @Test
    public void whenAddValueShouldContainTheValue() {
        SimpleHashSet<String> simpleHashSet = new SimpleHashSet<>();

        assertThat(simpleHashSet.contains("test1"), is(false));
        simpleHashSet.add("test1");
        assertThat(simpleHashSet.contains("test1"), is(true));
    }

    /**.
     * Tests contains().
     */
    @Test
    public void whenTestContainsShouldReturnExpectedValues() {
        SimpleHashSet<String> simpleHashSet = new SimpleHashSet<>();

        for (int i = 0; i < 11; i++) {
            simpleHashSet.add(String.format("test%d", i));
        }

        Object[] con = simpleHashSet.getContainer();
        for (Object o : con) {
            System.out.println((String) o);
        }

        assertThat(simpleHashSet.contains("test0"), is(true));
        assertThat(simpleHashSet.contains("test1"), is(true));
        assertThat(simpleHashSet.contains("test2"), is(true));
        assertThat(simpleHashSet.contains("test3"), is(true));
        assertThat(simpleHashSet.contains("test4"), is(true));
        assertThat(simpleHashSet.contains("test5"), is(true));
        assertThat(simpleHashSet.contains("test6"), is(true));
        assertThat(simpleHashSet.contains("test7"), is(true));
        assertThat(simpleHashSet.contains("test8"), is(true));
        assertThat(simpleHashSet.contains("test9"), is(true));
        assertThat(simpleHashSet.contains("test10"), is(true));
        assertThat(simpleHashSet.contains("test11"), is(false));
    }

    /**.
     * Tests remove().
     */
    @Test
    public void whenRemoveShouldGetRemoved() {
        SimpleHashSet<String> simpleHashSet = new SimpleHashSet<>();

        assertThat(simpleHashSet.contains("test1"), is(false));
        simpleHashSet.add("test1");
        assertThat(simpleHashSet.contains("test1"), is(true));
        simpleHashSet.remove("test1");
        assertThat(simpleHashSet.contains("test1"), is(false));
    }
}
