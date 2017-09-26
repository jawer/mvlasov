package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Class SortUserTest for SortUser testing.
 * @author Mikhail Vlasov
 * @since 9.25.2017
 * @version 1
 */
public class SortUserTest {
    /**.
     * Tests if sorting was successful.
     */
    @Test
    public void whenConvertListOfUsersToSetThenSortedTreeSet() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Misha", 10);
        User user2 = new User("Sasha", 8);
        User user3 = new User("Lesha", 9);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        SortUser sortUser = new SortUser();

        Set<User> expectedUserSet = new TreeSet<>();
        expectedUserSet.add(user1);
        expectedUserSet.add(user2);
        expectedUserSet.add(user3);

        assertThat(sortUser.sort(users), is(expectedUserSet));
    }
}
