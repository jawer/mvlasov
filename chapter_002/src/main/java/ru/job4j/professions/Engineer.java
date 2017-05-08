package ru.job4j.professions;

/**.
 * Class Engineer solving part 2 task 3
 * @author Mikhail Vlasov
 * @since 5.7.2017
 * @version 1
 */
public class Engineer extends Profession {
    /**.
     * Knowledge
     */
    private int rank;

    /**.
     * Constructor
     * @param name of object
     */
    public Engineer(String name) {
        setName(name);
    }

    /**.
     * Making project
     */
    public void makeProject() { }

    /**.
     * Making Drawing
     */
    public void makeDrawing() { }

    /**.
     * Making Estimate Drawing
     * @param doctor of Doctor
     */
    public void makeEstimateDrawing(Doctor doctor) { }
}
