package ru.job4j.storestatistics;

import java.util.List;

/**.
 * Class Info creates statistics for two arrays of Users.
 * @author Mikhail Vlasov
 * @since 07.08.2018
 * @version 1
 */
public class Info {
    /**.
     * Previous list of Users.
     */
    private List<Store.User> previous;
    /**.
     * Current list of Users.
     */
    private List<Store.User> current;
    /**.
     * Statistics values.
     */
    private int deleted, changed, added;

    /**.
     * Constructor.
     * @param previous list of Users.
     * @param current list of Users.
     */
    public Info(List<Store.User> previous, List<Store.User> current) {
        this.previous = previous;
        this.current = current;
        deleted = 0;
        changed = 0;
        added = 0;
        statistics();
    }

    /**.
     * Compares two user lists and creates statistics.
     */
    private void statistics() {
            for (Store.User usrC : current) {
                if (!previous.contains(usrC)) {
                    added++;
                    continue;
                } else {
                    if (usrC.isWasChanged()) {
                        changed++;
                        continue;
                    }
                }

            }

            for (Store.User usrP : previous) {
                if (!current.contains(usrP)) {
                    deleted++;
                }
            }
    }

    /**.
     * Overrides toString().
     */
    @Override
    public String toString() {
        return "Info{"
                + "deleted="
                + deleted
                + ", changed="
                + changed
                + ", added="
                + added
                + '}';
    }
}
