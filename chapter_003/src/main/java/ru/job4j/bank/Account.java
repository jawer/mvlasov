package ru.job4j.bank;

/**.
 * Class Account implements account.
 * @author Mikhail Vlasov
 * @since 11.24.2017
 * @version 1
 */
public class Account {
    /**.
     * Requisites of account.
     */
    private int requisites;
    /**.
     * Value on the account.
     */
    private double value;

    /**.
     * Constructor for Account class.
     * @param requisites of account.
     * @param value on the account.
     */
    public Account(int requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    /**.
     * Getter for requisites.
     * @return int requisites.
     */
    public int getRequisites() {
        return requisites;
    }

    /**.
     * Getter for value.
     * @return double value.
     */
    public double getValue() {
        return value;
    }

    /**.
     * Setter for requisites.
     * @param requisites of the account.
     */
    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    /**.
     * Setter for value.
     * @param value on the account.
     */
    public void setValue(double value) {
        this.value = value;
    }
}
