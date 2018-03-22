package ru.job4j.storegeneric;
import ru.job4j.simplearray.SimpleArray;
import java.util.NoSuchElementException;

/**.
 * Class UserStore extends AbstractStore, implements Store.
 * @author Mikhail Vlasov
 * @since 03.21.2018
 * @version 1
 */
public class RoleStore<Role extends Base> extends AbstractStore<Role> {
    /**.
     * Constructor.
     * @param size of the new role container.
     */
    public RoleStore(int size) {
        super(size);
    }
}
