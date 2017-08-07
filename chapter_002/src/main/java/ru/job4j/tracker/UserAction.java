package ru.job4j.tracker;

/**.
 * Interface UserAction defines action.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
public interface UserAction {
    /**.
     * Returns id of the option.
     * @return int id.
     */
    int key();
    /**.
     * Executes an action.
     * @param input object.
     * @param tracker object.
     */
    void execute(Input input, Tracker tracker);
    /**.
     * Contains info
     * @return String info.
     */
    String info();
}
