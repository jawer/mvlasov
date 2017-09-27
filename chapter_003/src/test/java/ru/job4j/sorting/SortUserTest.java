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

    /**.
     * Tests if sorting by name length was successful.
     */
    @Test
    public void whenSortListByNameLengthThenSortedList() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Lee", 10);
        User user2 = new User("Maksim", 8);
        User user3 = new User("Lesha", 9);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        SortUser sortUser = new SortUser();

        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(user1);
        expectedUsers.add(user3);
        expectedUsers.add(user2);

        assertThat(sortUser.sortNameLength(users), is(expectedUsers));
    }

    /**.
     * Tests if sorting by name first and then by age was successful.
     */
    @Test
    public void whenSortByAllFieldsThenSortedList() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        User user4 = new User("Иван", 25);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        SortUser sortUser = new SortUser();

        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(user4);
        expectedUsers.add(user2);
        expectedUsers.add(user3);
        expectedUsers.add(user1);

        assertThat(sortUser.sortByAllFields(users), is(expectedUsers));
    }
}
