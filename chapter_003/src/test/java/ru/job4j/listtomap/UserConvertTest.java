package ru.job4j.listtomap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Class UserConvertTest tests conversion from List<User> to HashMap<Integer, User>.
 * @author Mikhail Vlasov
 * @since 9.17.2017
 * @version 1
 */
public class UserConvertTest {
    /**.
     * Tests List-to-HashMap conversion.
     */
    @Test
    public void whenConvertListOfUsersThenUserMap() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "Ivan", "Moscow");
        User user2 = new User(2, "Alex", "Minsk");
        userList.add(user1);
        userList.add(user2);
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> resultUserMap = userConvert.process(userList);

        HashMap<Integer, User> expectedUserMap = new HashMap<>();
        expectedUserMap.put(1, user1);
        expectedUserMap.put(2, user2);
        assertThat(resultUserMap, is(expectedUserMap));
    }
}
