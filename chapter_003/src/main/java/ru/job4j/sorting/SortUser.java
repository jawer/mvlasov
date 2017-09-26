package ru.job4j.sorting;

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
}
