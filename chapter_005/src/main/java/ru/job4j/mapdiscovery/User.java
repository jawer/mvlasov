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
/*    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }*/

    /**.
     * Overrides equals, compares fields name, children and birthday.
     * @return boolean true or false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    /**.
     * Overrides hashCode using Object's hashCode().
     * Couldn't skip, audit tool cried.
     * @return int hash code.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
