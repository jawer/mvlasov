package ru.job4j.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**.
 * Class SortUser for User sorting.
 * @author Mikhail Vlasov
 * @since 9.25.2017
 * @version 1
 */
public class SortUser {
    /**.
     * Converts List<User> to TreeSet<User>.
     * @param userList of users.
     * @return Set<User> of users.
     */
    public Set<User> sort(List<User> userList) {
        return new TreeSet<>(userList);
    }

    /**.
     * В этом методе необходимо определить Comparator для метода Collections.sort
     * и отсортировать List<User> по длине имени.
     * @param userList of users.
     * @return List<User> of users.
     */
    public List<User> sortNameLength(List<User> userList) {
        userList.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return userList;
    }

    /**.
     * в этом методе необходимо определить Comparator для метода Collections.sort
     * и отсортировать List<User> по 2-м полям, сначала проверка по имени, потом по возрасту.
     * @param userList of users.
     * @return List<User> of users.
     */
    public List<User> sortByAllFields(List<User> userList) {
        userList.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        final int comparatorByName = o1.getName().compareTo(o2.getName());
                        return comparatorByName != 0 ? comparatorByName : Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        return userList;
    }
}
