package ru.job4j.bank;

/**.
 * Class User implements user with name and passport data.
 * @author Mikhail Vlasov
 * @since 11.24.2017
 * @version 1
 */
public class User {
    /**.
     * Name.
     */
    private String name;
    /**.
     * Passport.
     */
    private String passport;

    /**.
     * Constructor for User class.
     * @param name of user.
     * @param passport of user.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**.
     * Getter for name.
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**.
     * Getter for passport.
     * @return String passport.
     */
    public String getPassport() {
        return passport;
    }

    /**.
     * Setter for name.
     * @param name of user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**.
     * Setter for passport.
     * @param passport of user.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**.
     * Overriden equals compares two users by name and passports.
     * @param o user to be compared with.
     * @return boolean true if users are the same.
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

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    /**.
     * Overriden hashCode gets hash code on user name and passport base.
     * @return int hash code.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
