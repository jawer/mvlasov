package ru.job4j.listtomap;

/**.
 * Class User information.
 * @author Mikhail Vlasov
 * @since 9.17.2017
 * @version 1
 */
public class User {
    /**.
     * ID code.
     */
    private Integer id;
    /**.
     * Name.
     */
    private String name;
    /**.
     * City.
     */
    private String city;

    /**.
     * Constructor for User class.
     * @param id code.
     * @param name of user.
     * @param city of living.
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**.
     * Getter for id.
     * @return Integer id.
     */
    public Integer getId() {
        return id;
    }

    /**.
     * Getter for name.
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**.
     * Getter for city.
     * @return String city.
     */
    public String getCity() {
        return city;
    }
}
