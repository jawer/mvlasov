package ru.job4j.storegeneric;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.NoSuchElementException;

/**.
 * Class RoleStoreTest test RoleStore class.
 * @author Mikhail Vlasov
 * @since 03.21.2018
 * @version 1
 */
public class RoleStoreTest {
    /**.
     * Roles.
     */
    Role role0, role1, role2, role3, role4;

    /**.
     * Users setup.
     */
    @Before
    public void setUp() {
        role0 = new Role("role0");
        role1 = new Role("role1");
        role2 = new Role("role2");
        role3 = new Role("role3");
        role4 = new Role("role4");
    }

    /**.
     * Tests add().
     */
    @Test
    public void whenAddRoleToRoleStoreThenTheRoleExists() {
        RoleStore<Role> roleStore0 = new RoleStore<>(100);
        roleStore0.add(role0);
        Role tempR = (Role) roleStore0.getModels().get(0);
        assertThat(tempR.getId(), is("role0"));
    }

    /**.
     * Tests findById().
     */
    @Test
    public void whenLookForUserByIdThenGotTheUser() {
        RoleStore<Role> roleStore1 = new RoleStore<>(100);
        roleStore1.add(role1);
        roleStore1.add(role2);
        roleStore1.add(role3);
        assertThat(roleStore1.findById("role1"), is(role1));
        assertThat(roleStore1.findById("role2"), is(role2));
        assertThat(roleStore1.findById("role3"), is(role3));
    }

    /**.
     * Tests replace().
     */
    @Test
    public void whenReplaceUserInStoreThenNewUserExists() {
        RoleStore<Role> roleStore2 = new RoleStore<>(5);
        User testUser = new User("test");
        roleStore2.add(role3);
        roleStore2.replace("role3", role4);
        assertThat(roleStore2.findById("role4"), is(role4));
    }

    /**.
     * Tests delete().
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteUserThenNoSuchElementException() {
        RoleStore<Role> roleStore3 = new RoleStore<>(5);
        roleStore3.add(role1);
        assertThat(roleStore3.findById("role1"), is(role1));
        roleStore3.delete("user1");
        roleStore3.findById("user1");
    }
}
