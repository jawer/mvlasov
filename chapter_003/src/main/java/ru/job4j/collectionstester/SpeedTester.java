package ru.job4j.collectionstester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

/**.
 * Class SpeedTester замеряет время вставки в коллекцию большого количества случайных строк и
 * удаления в коллекции первых n элементов для:
 * LinkedList,
 * ArrayList,
 * TreeSet.
 * @author Mikhail Vlasov
 * @since 9.12.2017
 * @version 1
 */
public class SpeedTester {
    /**.
     * Adds random strings into collection.
     * @param collection empty.
     * @param amount of strings to be added.
     * @return long time of operation.
     */
    public long add(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(System.currentTimeMillis() + i));
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**.
     * Delete strings from collection.
     * @param collection of strings.
     * @param amount of strings to be deleted.
     * @return long time of operation.
     */
    public long delete(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext() && amount > 0) {
            iterator.next();
            iterator.remove();
            amount--;
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**.
     * Program entrance point.
     * @param args array of strings.
     */
    public static void main(String[] args) {
        SpeedTester sp = new SpeedTester();
        LinkedList<String> linkedList = new LinkedList<String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        TreeSet<String> treeSet = new TreeSet<String>();

        System.out.println(String.format("Время добавления 50000 строк в ArrayList: %d msec", sp.add(arrayList, 50000)));
        System.out.println(String.format("Время удаления 40000 строк из ArrayList: %d msec", sp.delete(arrayList, 40000)));

        System.out.println(String.format("Время добавления 50000 строк в LinkedList: %d msec", sp.add(linkedList, 50000)));
        System.out.println(String.format("Время удаления 40000 строк из LinkedList: %d msec", sp.delete(linkedList, 40000)));

        System.out.println(String.format("Время добавления 50000 строк в TreeSet: %d msec", sp.add(treeSet, 50000)));
        System.out.println(String.format("Время удаления 40000 строк из TreeSet: %d msec", sp.delete(treeSet, 40000)));
    }
}
