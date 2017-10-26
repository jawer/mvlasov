package ru.job4j.directory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Class DirectoryTest for sorted directories testing.
 * @author Mikhail Vlasov
 * @since 10.25.2017
 * @version 1
 */
public class DirectoryTest {

    /**.
     * Tests if sorting forward directory was correct.
     */
    @Test
    public void whenCreateDirectoryAndSortForwardThenThenSortedForward() {
        Directory dir = new Directory();
        Set<String> sortedForward = dir.sortForward(new String[] {
                "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2"
        });

        List<String> expectedList = new ArrayList<>(Arrays.asList(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"));

        assertThat(new ArrayList<String>(sortedForward), is(expectedList));
    }

    /**.
     * Tests if sorting backward directory was correct.
     */
    @Test
    public void whenCreateDirectoryAndSortBackwardThenThenSortedBackward() {
        Directory dir = new Directory();
        Set<String> sortedBackward = dir.sortBackward(new String[] {
                "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2"
        });

        List<String> expectedList = new ArrayList<>(Arrays.asList(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"));

        assertThat(new ArrayList<String>(sortedBackward), is(expectedList));
    }
}
