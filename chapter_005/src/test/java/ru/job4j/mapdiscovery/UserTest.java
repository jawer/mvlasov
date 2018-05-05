package ru.job4j.mapdiscovery;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**.
 * Class UserTest tests User class.
 * @author Mikhail Vlasov
 * @since 04.29.2018
 * @version 1
 */
public class UserTest {
    /**.
     * Tests User creation.
     */
    @Test
    public void whenCreateUserShouldBeCreated() {
        Calendar dayOfBirth = Calendar.getInstance();
        dayOfBirth.set(1990, 11, 31);
        User user = new User("Mike", 2, dayOfBirth);

        assertThat(user.getName(), is("Mike"));
        assertThat(user.getChildren(), is(2));
        assertThat(new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday().getTimeInMillis()), is("1990-12-31"));
    }

    /**.
     * Tests when two users created without equals() and hashCode() overriding.
     */
    @Test
    public void whenTwoUsersAddedToMapWithoutEqualsHashCodeOverridingThenCheckResult() {
        Calendar dayOfBirth = Calendar.getInstance();
        dayOfBirth.set(1990, 11, 31);
        User user1 = new User("Mike", 2, dayOfBirth);
        User user2 = new User("Mike", 2, dayOfBirth);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");

        for (Map.Entry<User, Object> entry : map.entrySet()) {
            System.out.println("" + entry.getKey());
        }
    }
}
