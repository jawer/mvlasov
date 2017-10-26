package ru.job4j.directory;

import java.util.*;

/**.
 * Class Directory:
 * В организации было решено ввести справочник подразделений. Коды подразделений
 * представлены в виде массива строк вида:
 * “K1\SK1”
 * “K1\SK2”
 * “K1\SK1\SSK1”
 * “K1\SK1\SSK2”
 * “K2”
 * “K2\SK1\SSK1”
 * “K2\SK1\SSK2”
 *, где каждая строка имеет следующую структуру: каждая строка включает в себя код
 * данного подразделения, а также все коды подразделений, которые включают в свою
 * структуру данное подразделение (к примеру департамент K1 включает в себя службу SK1,
 * включающую в себя отдел SSK1). Подразделения в одной строке разделены знаком “\”.
 * Возможны случаи, когда в массиве отсутствуют строки с кодом верхнеуровнего подразделения
 * (в показанном выше массиве есть строки с подразделением K1, но данный код подразделения
 * не представлен отдельной строкой “K1”, аналогичный случай с кодом K2\SK1), в таком случае
 * необходимо добавить строку с кодом данного подразделения и учитывать ее при сортировке.
 * Задача:
 * Реализовать возможность сортировки массива кодов подразделений по возрастанию и убыванию,
 * при которых сохранялась бы иерархическая структура (показано далее в примерах сортировки),
 * т.к. отсортированный массив используется для отображения категорий пользователю.
 * Отсортированный тестовый массив должен иметь вид:
 * Сортировка по возрастанию:
 * “K1”
 * “K1\SK1”
 * “K1\SK1\SSK1”
 * “K1\SK1\SSK2”
 * “K1\SK2”
 * “K2”
 * “K2\SK1”
 * “K2\SK1\SSK1”
 * “K2\SK1\SSK2”
 *
 * Сортировка по убыванию:
 * “K2”
 * “K2\SK1”
 * “K2\SK1\SSK2”
 * “K2\SK1\SSK1”
 * “K1”
 * “K1\SK2”
 * “K1\SK1”
 * “K1\SK1\SSK2”
 * “K1\SK1\SSK1”.
 * @author Mikhail Vlasov
 * @since 10.25.2017
 * @version 1
 */
public class Directory {
    /**.
     * Sorts ArrayList<String> forward.
     * @param strArray ArrayList of company units.
     * @return Set<String> Sorted set.
     */
    public Set sortForward(String[] strArray) {
        Set<String> unitList = new TreeSet<>(splitAndCombine(strArray));
        return unitList;
    }

    /**.
     * Sorts ArrayList<String> backward according specification.
     * @param strArray ArrayList of company units.
     * @return Set<String> Sorted set.
     */
    public Set sortBackward(String[] strArray) {
        Set<String> unitList = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        //Взял из String.compare и немного поменял.
                        int n1 = s1.length();
                        int n2 = s2.length();
                        int min = Math.min(n1, n2);
                        for (int i = 0; i < min; i++) {
                            char c1 = s1.charAt(i);
                            char c2 = s2.charAt(i);
                            if (c1 != c2) {
                                c1 = Character.toUpperCase(c1);
                                c2 = Character.toUpperCase(c2);
                                if (c1 != c2) {
                                    c1 = Character.toLowerCase(c1);
                                    c2 = Character.toLowerCase(c2);
                                    if (c1 != c2) {
                                        // No overflow because of numeric promotion
                                        return c2 - c1;
                                    }
                                }
                            }
                        }
                        return n1 - n2;
                    }
                }
        );

        unitList.addAll(splitAndCombine(strArray));
        return unitList;
    }

    /**.
     * Создаём ArrayList из массива строк (справочника подразделений) используя разделитель '/'
     * и комбинируем согласно иерархии.
     * A/B/C/D => A, A/B, A/B/C, A/B/C/D.
     * @param strArray ArrayList of company units.
     * @return List<String> Split and combined ArrayList.
     */
    private List splitAndCombine(String[] strArray) {
        List<String> unitList = new ArrayList<>();
        for (String str : strArray) {
            String[] tempStr = str.split("/");
            //Комбинируем.
            String growStr = null;
            for (String tStr : tempStr) {
                if (growStr == null) {
                    growStr = tStr;
                } else {
                    growStr += "/" + tStr;
                }
                unitList.add(growStr);
            }
        }
        return unitList;
    }
}
