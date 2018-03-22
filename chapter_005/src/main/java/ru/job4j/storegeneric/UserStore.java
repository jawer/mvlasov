package ru.job4j.storegeneric;
import ru.job4j.simplearray.SimpleArray;
import java.util.NoSuchElementException;

/**.
 * Class UserStore extends AbstractStore, implements Store.
 * @author Mikhail Vlasov
 * @since 03.20.2018
 * @version 1
 */
public class UserStore<User extends Base> extends AbstractStore<User> {
    /**.
     * Constructor.
     * @param size of the new user container.
     */
    public UserStore(int size) {
        super(size);
    }
}
