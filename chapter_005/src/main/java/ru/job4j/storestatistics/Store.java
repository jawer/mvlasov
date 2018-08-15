package ru.job4j.storestatistics;

import java.util.ArrayList;
import java.util.List;

/**.
 * Class Store creates Store that keeps Users.
 * @author Mikhail Vlasov
 * @since 07.08.2018
 * @version 1
 */
public class Store {
    /**.
     * User list.
     */
    private List<User> usrLst;

    /**.
     * Constructor.
     */
    public Store() {
        usrLst = new ArrayList<>();
    }

    /**.
     * Adds users.
     * @param usr User.
     * @return User same object.
     */
    User addUser(User usr) {
        usrLst.add(usr);
        return usr;
    }

    /**.
     * Edits user.
     * @param usr User.
     * @param nm new name.
     */
    void editUser(User usr, String nm) {
        usr.name = nm;
        usr.wasChanged = true;
    }

    /**.
     * Deletes user.
     * @param usr User.
     */
    void deleteUser(User usr) {
        usrLst.remove(usr);
        usr.wasChanged = false;
    }

    /**.
     * Gets user list.
     * @return List<User>
     */
    List<User> getUsrLst() {
        return new ArrayList<>(usrLst);
    }

    /**.
     * Returns statistics by comparing 2 user lists.
     * @param previous user list.
     * @param current user list.
     * @return Info object.
     */
    Info diff(List<User> previous, List<User> current) {
        return new Info(previous, current);
    }

    /**.
     * Class User describes single user.
     * @author Mikhail Vlasov
     * @since 07.08.2018
     * @version 1
     */
    static class User {
        /**.
         * User id.
         */
        int id;
        /**.
         * User name.
         */
        String name;
        /**.
         * User flag if it was changed.
         */
        private boolean wasChanged;

        /**.
         * Constructor.
         * @param id of user.
         * @param name of user.
         */
        public User(int id, String name) {
            this.id = id;
            this.name = name;
            this.wasChanged = false;
        }

        /**.
         * Gets user name.
         * @return String name.
         */
        public String getName() {
            return name;
        }

        /**.
         * Gets user id.
         * @return int id.
         */
        public int getId() {
            return id;
        }

        /**.
         * Gets status if it was changed.
         * @return boolean status.
         */
        public boolean isWasChanged() {
            return wasChanged;
        }

        /**.
         * Overrides equals.
         * @return boolean equality.
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

            return id == user.id;
        }

        /**.
         * Overrides hashCode.
         * @return int hash code.
         */
        @Override
        public int hashCode() {
            return id;
        }

        /**.
         * Overrides toString.
         * @return String user.
         */
        @Override
        public String toString() {
            return "User{"
                    + "id="
                    + id
                    + ", name='"
                    + name
                    + '\''
                    + '}';
        }
    }
}
