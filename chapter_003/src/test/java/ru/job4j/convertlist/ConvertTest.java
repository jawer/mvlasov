package ru.job4j.convertlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Class ConvertTest tests convert function
 * @author Mikhail Vlasov
 * @since 9.17.2017
 * @version 1
 */
public class ConvertTest {
    /**.
     * Tests conversion from list af arrays to list of Integer.
     */
    @Test
    public void whenConvertListOfArraysThenListOfInteger() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5});
        ConvertList convertList = new ConvertList();
        List<Integer> resultList = convertList.convert(list);
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);
        expectedList.add(5);
        assertThat(resultList, is(expectedList));
    }
}
