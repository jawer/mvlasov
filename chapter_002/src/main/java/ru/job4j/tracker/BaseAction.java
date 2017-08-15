package ru.job4j.tracker;

/**
 * Created by hed1n on 14.08.2017.
 */
public abstract class BaseAction implements UserAction {
    /**.
     * Name of the action.
     */
    private String name;
    /**.
     * Key of the action.
     */
    private int key;
    /**.
     * Constructor for BaseAction abstract class.
     * @param name of the action.
     * @param key of the action.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**.
     * Contains info
     * @return String info.
     */
    public String info() {
        return String.format("%s. %s", key, name);
    }
}
