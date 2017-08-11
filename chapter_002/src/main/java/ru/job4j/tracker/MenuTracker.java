package ru.job4j.tracker;

import java.text.SimpleDateFormat;

/**.
 * Class MenuTracker contains menu and actions for each option.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
public class MenuTracker {
    /**.
     * Variable for Interface
     */
    private Input input;
    /**.
     * Variable for Tracker
     */
    private Tracker tracker;
    /**.
     * Array for actions
     */
    private UserAction[] actions = new UserAction[6];
    /**.
     * Simple date and time of item creation pattern.
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    /**.
     * Getter for simpleDateFormat.
     * @return SimpleDateFormat object.
     */
    public static SimpleDateFormat getSimpleDateFormat() {
        return MenuTracker.simpleDateFormat;
    }
    /**.
     * Constructor for MenuTracker class.
     * @param input interface.
     * @param tracker object.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**.
     * Fills menu for work with tracker.
     */
    public void fillActions() {
        actions[0] = new AddItem();
        actions[1] = new MenuTracker.ShowItems();
        actions[2] = new EditItem();
        actions[3] = new DeleteItem();
        actions[4] = new FindItemById();
        actions[5] = new FindItemByName();
    }

    /**.
     * Gets identification key for each menu option.
     * @return int[] array of keys.
     */
    public int[] getUserActionKeys() {
        int[] range = new int[actions.length];
        for (int i = 0; i < range.length; i++) {
            range[i] = actions[i].key();
        }
        return range;
    }

    /**.
     * Prints menu for tracker work.
     */
    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**.
     * Executes an option from menu
     * @param key id
     */
    public void select(int key) {
        this.actions[key].execute(input, tracker);
    }

    /**.
     * Class AddItem adds task in tracker.
     * @author Mikhail Vlasov
     * @since 8.6.2017
     * @version 1
     */
    private class AddItem implements UserAction {
        /**.
         * Returns id of the option.
         * @return int id.
         */
        public int key() {
            return 0;
        }

        /**.
         * Executes an action.
         * @param input object.
         * @param tracker object.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter task's name: ");
            String desc = input.ask("Please, enter task's description: ");
            tracker.add(new Item(name, desc));
        }

        /**.
         * Contains info
         * @return String info.
         */
        public String info() {
            return String.format("%s. %s", key(), "Add new item.");
        }
    }

    /**.
     * Class ShowItems print all tasks from tracker.
     * @author Mikhail Vlasov
     * @since 8.6.2017
     * @version 1
     */
    private static class ShowItems implements UserAction {
        /**.
         * Returns id of the option.
         * @return int id.
         */
        public int key() {
            return 1;
        }

        /**.
         * Executes an action.
         * @param input object.
         * @param tracker object.
         */
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items[0] == null) {
                System.out.println("No tasks available.");
            } else {
                for (Item item : items) {
                    System.out.println(String.format("Name of task: %s"
                                    + System.lineSeparator()
                                    + "Description: %s"
                                    + System.lineSeparator()
                                    + "ID: %s"
                                    + System.lineSeparator()
                                    + "Date of creation: %s",
                            item.getName(), item.getDescription(), item.getId(), simpleDateFormat.format(item.getCreated())
                    ));
                    System.lineSeparator();
                }
            }
        }

        /**.
         * Contains info
         * @return String info.
         */
        public String info() {
            return String.format("%s. %s", key(), "Show items.");
        }
    }
}

/**.
 * Class EditItem edits task.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class EditItem implements UserAction {
    /**.
     * Returns id of the option.
     * @return int id.
     */
    public int key() {
        return 2;
    }

    /**.
     * Executes an action.
     * @param input object.
     * @param tracker object.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of the task you want to edit: ");
        Item item = tracker.findById(id);

        if (item == null) {
            System.out.println("No task found");

        } else {
            System.out.println(String.format("Name of task: %s"
                            + System.lineSeparator()
                            + "Description: %s"
                            + System.lineSeparator()
                            + "ID: %s"
                            + System.lineSeparator()
                            + "Date of creation: %s"
                            + System.lineSeparator(),
                    item.getName(), item.getDescription(), item.getId(), MenuTracker.getSimpleDateFormat().format(item.getCreated())
            ));
            String name = input.ask("Enter new name: ");
            String desc = input.ask("Enter new description: ");
            item.setDescription(desc);
            item.setName(name);
            tracker.update(item);
        }
    }

    /**.
     * Contains info
     * @return String info.
     */
    public String info() {
        return String.format("%s. %s", key(), "Edit item.");
    }
}

/**.
 * Class DeleteItem deletes task.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class DeleteItem implements UserAction {
    /**.
     * Returns id of the option.
     * @return int id.
     */
    public int key() {
        return 3;
    }

    /**.
     * Executes an action.
     * @param input object.
     * @param tracker object.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of the task you want to delete: ");
        Item item = tracker.findById(id);

        if (item == null) {
            System.out.println("No task found");

        } else {
            tracker.delete(item);
            System.out.println("The task was deleted.");
        }
    }

    /**.
     * Contains info
     * @return String info.
     */
    public String info() {
        return String.format("%s. %s", key(), "Delete item.");
    }
}

/**.
 * Class FindItemById prints task by id.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class FindItemById implements UserAction {
    /**.
     * Returns id of the option.
     * @return int id.
     */
    public int key() {
        return 4;
    }

    /**.
     * Executes an action.
     * @param input object.
     * @param tracker object.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of the task you want to find: ");
        Item item = tracker.findById(id);

        if (item == null) {
            System.out.println("No task found");

        } else {
            System.out.println(String.format("Name of task: %s"
                            + System.lineSeparator()
                            + "Description: %s" + System.lineSeparator()
                            + "ID: %s" + System.lineSeparator()
                            + "Date of creation: %s",
                    item.getName(), item.getDescription(), item.getId(), MenuTracker.getSimpleDateFormat().format(item.getCreated())
            ));
        }
    }

    /**.
     * Contains info
     * @return String info.
     */
    public String info() {
        return String.format("%s. %s", key(), "Find item by id item.");
    }
}

/**.
 * Class FindItemByName prints task by name.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class FindItemByName implements UserAction {
    /**.
     * Returns id of the option.
     * @return int id.
     */
    public int key() {
        return 5;
    }

    /**.
     * Executes an action.
     * @param input object.
     * @param tracker object.
     */
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter name: ");
        Item[] items = tracker.findByName(name);

        if (items == null) {
            System.out.println("No task found");

        } else {
            for (Item item : items) {
                System.out.println(String.format("Name of task: %s"
                                + System.lineSeparator()
                                + "Description: %s" + System.lineSeparator()
                                + "ID: %s"
                                + System.lineSeparator()
                                + "Date of creation: %s",
                        item.getName(), item.getDescription(), item.getId(), MenuTracker.getSimpleDateFormat().format(item.getCreated())
                ));
            }
        }
    }

    /**.
     * Contains info
     * @return String info.
     */
    public String info() {
        return String.format("%s. %s", key(), "Find item by name item.");
    }
}