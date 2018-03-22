package ru.job4j.storegeneric;

/**.
 * Interface Store extends abstract class Base.
 * @author Mikhail Vlasov
 * @since 03.20.2018
 * @version 1
 */
public interface Store<T extends Base> {
    /**.
     * Adds model to the container.
     * @param model object.
     */
    void add(T model);

    /**.
     * Replaces model.
     * @param id of the model to be replaced.
     * @param model object to be replaced with.
     * @return boolean true if model found, false if not.
     */
    boolean replace(String id, T model);

    /**.
     * Deletes model.
     * @param id of the model to be deleted.
     * @return boolean true if model found, false if not.
     */
    boolean delete(String id);

    /**.
     * Finds by ID.
     * @param id of the model to be found.
     * @return T model.
     */
    T findById(String id);
}