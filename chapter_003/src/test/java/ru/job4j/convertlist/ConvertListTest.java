package ru.job4j.convertlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Class ConvertListTest tests ConvertList
 * @author Mikhail Vlasov
 * @since 9.14.2017
 * @version 1
 */
public class ConvertListTest {
    /**.
     * Tests Array-To-List function.
     */
    @Test
    public void whenConvertArrayToListThenList() {
        ConvertList convertList = new ConvertList();
        List<Integer> resultList = convertList.toList(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0, 1);
        expectedList.add(1, 2);
        expectedList.add(2, 3);
        expectedList.add(3, 4);
        expectedList.add(4, 5);
        expectedList.add(5, 6);
        expectedList.add(6, 7);
        expectedList.add(7, 8);
        expectedList.add(8, 9);
        assertThat(resultList, is(expectedList));
    }

    /**.
     * Tests List-To-Array function.
     */
    @Test
    public void whenConvertListToArrayThenArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 5);
        list.add(5, 6);
        list.add(6, 7);
        list.add(7, 8);
        list.add(8, 9);
        int[][] resultArray = convertList.toArray(list, 5);
        int[][] expectedArray = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}};
        assertThat(resultArray, is(expectedArray));
    }
}
