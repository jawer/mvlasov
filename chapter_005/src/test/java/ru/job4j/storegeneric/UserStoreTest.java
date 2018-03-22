package ru.job4j.storegeneric;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.NoSuchElementException;

/**.
 * Class UserStoreTest test UserStore class.
 * @author Mikhail Vlasov
 * @since 03.21.2018
 * @version 1
 */
public class UserStoreTest {
    /**.
     * Users.
     */
    User user0, user1, user2, user3, user4;

    /**.
     * Users setup.
     */
    @Before
    public void setUp() {
        user0 = new User("user0");
        user1 = new User("user1");
        user2 = new User("user2");
        user3 = new User("user3");
        user4 = new User("user4");
    }

    /**.
     * Tests add().
     */
    @Test
    public void whenAddUserToUserStoreThenTheUserExists() {
        UserStore<User> userStore0 = new UserStore<>(100);
        userStore0.add(user0);
        User tempU = (User) userStore0.getModels().get(0);
        assertThat(tempU.getId(), is("user0"));
    }

    /**.
     * Tests findById().
     */
    @Test
    public void whenLookForUserByIdThenGotTheUser() {
        UserStore<User> userStore1 = new UserStore<>(100);
        userStore1.add(user1);
        userStore1.add(user2);
        userStore1.add(user3);
        assertThat(userStore1.findById("user1"), is(user1));
        assertThat(userStore1.findById("user2"), is(user2));
        assertThat(userStore1.findById("user3"), is(user3));
    }

    /**.
     * Tests replace().
     */
    @Test
    public void whenReplaceUserInStoreThenNewUserExists() {
        UserStore<User> userStore2 = new UserStore<>(100);
        userStore2.add(user3);
        userStore2.replace("user3", user4);
        assertThat(userStore2.findById("user4"), is(user4));
    }

    /**.
     * Tests delete().
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteUserThenNoSuchElementException() {
        UserStore<User> userStore3 = new UserStore<>(100);
        userStore3.add(user1);
        assertThat(userStore3.findById("user1"), is(user1));
        userStore3.delete("user1");
        userStore3.findById("user1");
    }
}
