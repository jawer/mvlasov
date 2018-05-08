package ru.job4j.mapdiscovery;

import java.util.Calendar;

/**.
 * Class User.
 * @author Mikhail Vlasov
 * @since 04.29.2018
 * @version 1
 */
public class User {
    /**.
     * name of the user.
     */
    private String name;
    /**.
     * @param children quantity.
     */
    private int children;
    /**.
     * @param birthday of the user.
     */
    private Calendar birthday;

    /**.
     * Constructor.
     * @param name of the user.
     * @param children quantity.
     * @param birthday of the user.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**.
     * Gets user name.
     * @return String of the user name.
     */
    public String getName() {
        return name;
    }

    /**.
     * Gets children quantity.
     * @return int children quantity of the user.
     */
    public int getChildren() {
        return children;
    }

    /**.
     * Gets user birthday.
     * @return Calendar of the user birthday.
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**.
     * Overrides hashCode using name, children and birthday.
     * @return int hash code.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
