package ru.job4j.storegeneric;
import ru.job4j.simplearray.SimpleArray;
import java.util.NoSuchElementException;

/**.
 * Abstract Class AbstractStore implements basic operations on models in general. It stores models in SimpleArray.
 * @author Mikhail Vlasov
 * @since 03.21.2018
 * @version 1
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**.
     * Simple array.
     */
    private SimpleArray<T> models;

    /**.
     * Constructor.
     * @param size of the new container.
     */
    public AbstractStore(int size) {
        this.models = new SimpleArray<T>(size);
    }

    /**.
     * Getter for test purpose.
     * @return SimpleArray container.
     */
    public SimpleArray getModels() {
        return models;
    }

    /**.
     * Adds model to the container.
     * @param model object.
     */
    public void add(T model) {
        models.add(model);
    }

    /**.
     * Replaces model.
     * @param id of the model to be replaced.
     * @param model object to be replaced with.
     * @return boolean true if model found, false if not.
     */
    public boolean replace(String id, T model) {
        int index = 0;

        for (T mod : models) {
            if (id.equals(mod.getId())) {
                models.set(index, model);
                return true;
            }
            index++;
        }
        return false;
    }

    /**.
     * Deletes model.
     * @param id of the model to be deleted.
     * @return boolean true if model found, false if not.
     */
    public boolean delete(String id) {
        int index = 0;

        for (T mod : models) {
            if (id.equals(mod.getId())) {
                models.delete(index);
                return true;
            }
            index++;
        }
        return false;
    }

    /**.
     * Finds by ID.
     * @param id of the model to be found.
     * @return Base model, NoSuchElementException if not found.
     */
    public T findById(String id) {
        int index = 0;

        for (T mod : models) {
            if (id.equals(mod.getId())) {
                return mod;
            }
            index++;
        }
        throw new NoSuchElementException("No such element in Store.");
    }
}
