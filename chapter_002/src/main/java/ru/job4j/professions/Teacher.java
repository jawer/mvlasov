package ru.job4j.professions;

/**.
 * Class Teacher solving part 2 task 3
 * @author Mikhail Vlasov
 * @since 5.7.2017
 * @version 1
 */
public class Teacher extends Profession {
    /**.
     * Level of knowledge
     */
    private int level;

    /**.
     * Constructor
     * @param name of object
     */
    public Teacher(String name) {
        setName(name);
    }

    /**.
     * Teaching
     */
    public void teach() { }

    /**.
     * Conducting exam
     */
    public void conductExam() { }

    /**.
     * Conducting course
     * @param engineer of Engineer
     */
    public void conductCourse(Engineer engineer) { }
}
