package ru.job4j.listtomap;

import java.util.HashMap;
import java.util.List;

/**.
 * Class UserConvert for conversion from List<User> to HashMap<Integer, User>.
 * @author Mikhail Vlasov
 * @since 9.17.2017
 * @version 1
 */
public class UserConvert {
    /**.
     * Converts List<User> to HashMap<Integer, User>.
     * @param list of Users.
     * @return HashMap<Integer, User> of user id as a key and User as a value.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.getId(), user);
        }
        return userMap;
    }
}
