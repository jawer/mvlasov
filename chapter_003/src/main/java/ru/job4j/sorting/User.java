package ru.job4j.sorting;

/**.
 * Class User information.
 * @author Mikhail Vlasov
 * @since 9.25.2017
 * @version 1
 */
public class User implements Comparable<User> {
    /**.
     * Name.
     */
    private String name;
    /**.
     * Age.
     */
    private int age;

    /**.
     * Constructor for User class.
     * @param name of user.
     * @param age of user.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**.
     * Getter for name.
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**.
     * Getter for age.
     * @return int age.
     */
    public int getAge() {
        return age;
    }

    /**.
     * Implements compareTo.
     * @param user object.
     * @return int 1, 0 or -1.
     */
    @Override
    public int compareTo(User user) {
        if (this.getAge() == user.getAge()) {
            return 0;
        }
        return this.getAge() > user.getAge() ? 1 : -1;
    }

    /**.
     * Overrides toString.
     * @return String of user.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }
}
