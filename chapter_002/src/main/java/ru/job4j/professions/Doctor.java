package ru.job4j.professions;

/**.
 * Class Doctor solving part 2 task 3
 * @author Mikhail Vlasov
 * @since 5.7.2017
 * @version 1
 */
public class Doctor extends Profession {
    /**.
     * Document
     */
    private String diploma;

    /**.
     * Constructor
     * @param name of object
     */
    public Doctor(String name) {
        setName(name);
    }

    /**.
     * Healing
     * @param profession of Profession
     * @return String
     */
    public String heal(Profession profession) {
        return "Доктор " + this.getName() + " лечит " + profession.getName();
    }

    /**.
     * Doing sergery
     */
    public void duSergery() { }

    /**.
     * Writing prescription
     * @return String
     */
    public String writePrescription() {
        return "Prescription has written";
    }

    /**.
     * Consulting
     * @param teacher of Teacher
     */
    public void consult(Teacher teacher) { }
}