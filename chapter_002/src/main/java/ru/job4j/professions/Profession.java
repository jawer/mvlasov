package ru.job4j.professions;

/**.
 * Class Profession solving part 2 task 3
 * @author Mikhail Vlasov
 * @since 5.7.2017
 * @version 1
 */
public class Profession {

    /**.
     * Name
     */
    private String name;

    /**.
     * Age
     */
    private int age;

    /**.
     * Specialization
     */
    private String specialization;

    /**.
     * Setter
     * @param name string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**.
     * Getter
     * @return String
     */
    public String getName() {
        return this.name;
    }
}