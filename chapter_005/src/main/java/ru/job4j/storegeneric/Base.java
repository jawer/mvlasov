package ru.job4j.storegeneric;

/**.
 * Abstract Class Base describes model.
 * @author Mikhail Vlasov
 * @since 03.20.2018
 * @version 1
 */
public abstract class Base {
    /**.
     * ID of the model.
     */
    private final String id;

    /**.
     * Constructor.
     * @param id of the model.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**.
     * Getter.
     * @return String ID of the model.
     */
    public String getId() {
        return id;
    }
}