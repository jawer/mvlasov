package ru.job4j.storestatistics;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**.
 * Class StoreTest tests Store of Users classes.
 * @author Mikhail Vlasov
 * @since 12.08.2018
 * @version 1
 */
public class StoreTest {
    /**.
     * Tests adding, changing and deleting Users.
     */
    @Test
    public void whenCreateASoreShouldReturnCorrectStatistic() {
        Store store = new Store();
        Store.User usr1 = new Store.User(1, "A");
        Store.User usr2 = new Store.User(2, "B");
        Store.User usr3 = new Store.User(3, "C");
        Store.User usr4 = new Store.User(4, "D");
        Store.User usr5 = new Store.User(5, "E");
        Store.User usr6 = new Store.User(6, "F");
        store.addUser(usr1);
        store.addUser(usr2);
        store.addUser(usr3);
        store.addUser(usr4);
        List<Store.User> usrLstPrev = store.getUsrLst();

        store.deleteUser(usr2);
        store.editUser(usr4, "DD");
        store.addUser(usr5);
        store.addUser(usr6);
        List<Store.User> usrLstCurr = store.getUsrLst();
        Info inf = store.diff(usrLstPrev, usrLstCurr);

        assertThat(inf.toString(), is("Info{deleted=1, changed=1, added=2}"));

        store.addUser(usr2);
        store.deleteUser(usr1);
        store.deleteUser(usr3);
        store.editUser(usr4, "D");
        store.editUser(usr6, "FF");
        List<Store.User> usrLstNew = store.getUsrLst();
        Info inf1 = store.diff(usrLstCurr, usrLstNew);

        assertThat(inf1.toString(), is("Info{deleted=2, changed=2, added=1}"));
    }
}