package ru.job4j.convertlist;

import java.util.ArrayList;
import java.util.List;

/**.
 * Class ConvertList converts ArrayList to array[][] and array[][] to ArrayList.
 * @author Mikhail Vlasov
 * @since 9.14.2017
 * @version 1
 */
public class ConvertList {
    /**.
     * Converts two dimensional array to ArrayList.
     * @param array two dimensional.
     * @return List<Integer> ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    /**.
     * Converts ArrayList to two dimensional array.
     * @param list ArrayList.
     * @param rows quantity.
     * @return int[][] array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int columns = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][columns];
        for (Integer index : list) {
            int indexOf = list.indexOf(index);
            int jArray = (int) Math.floor((double) indexOf / (double) columns);
            int iArray = indexOf % columns;
            array[jArray][iArray] = index;
        }
        return array;
    }
}
