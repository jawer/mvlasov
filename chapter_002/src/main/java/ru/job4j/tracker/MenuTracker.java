package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
     * ArrayList for actions
     */
    private List<UserAction> actions = new ArrayList<>();
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
        actions.add(new AddItem("Add new item.", 0));
        actions.add(new MenuTracker.ShowItems("Show items.", 1));
        actions.add(new EditItem("Edit item.", 2));
        actions.add(new DeleteItem("Delete item.", 3));
        actions.add(new FindItemById("Find item by item's id.", 4));
        actions.add(new FindItemByName("Find item by item's name.", 5));
    }

    /**.
     * Gets identification key for each menu option.
     * @return int[] array of keys.
     */
    public int[] getUserActionKeys() {
        int[] range = new int[actions.size()];
        int position = 0;
        for (UserAction userAction : actions) {
            range[position++] = userAction.key();
        }
        return range;
    }

    /**.
     * Prints menu for tracker work.
     */
    public void show() {
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
    }

    /**.
     * Executes an option from menu
     * @param key id
     */
    public void select(int key) {
        this.actions.get(key).execute(input, tracker);
    }

    /**.
     * Class AddItem adds task in tracker.
     * @author Mikhail Vlasov
     * @since 8.6.2017
     * @version 1
     */
    private class AddItem extends BaseAction {
        /**.
         * Constructor for AddItem internal non static class.
         * @param name of the action.
         * @param key of the action.
         */
        AddItem(String name, int key) {
            super(name, key);
        }

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
    }

    /**.
     * Class ShowItems print all tasks from tracker.
     * @author Mikhail Vlasov
     * @since 8.6.2017
     * @version 1
     */
    private static class ShowItems extends BaseAction {
        /**.
         * Constructor for ShowItems internal static class.
         * @param name of the action.
         * @param key of the action.
         */
        ShowItems(String name, int key) {
            super(name, key);
        }

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
    }
}

/**.
 * Class EditItem edits task.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class EditItem extends BaseAction {
    /**.
     * Constructor for EditItem internal external class.
     * @param name of the action.
     * @param key of the action.
     */
    EditItem(String name, int key) {
        super(name, key);
    }

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
}

/**.
 * Class DeleteItem deletes task.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class DeleteItem extends BaseAction {
    /**.
     * Constructor for DeleteItem internal external class.
     * @param name of the action.
     * @param key of the action.
     */
    DeleteItem(String name, int key) {
        super(name, key);
    }

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
}

/**.
 * Class FindItemById prints task by id.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class FindItemById extends BaseAction {
    /**.
     * Constructor for FindItemById internal external class.
     * @param name of the action.
     * @param key of the action.
     */
    FindItemById(String name, int key) {
        super(name, key);
    }

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
}

/**.
 * Class FindItemByName prints task by name.
 * @author Mikhail Vlasov
 * @since 8.6.2017
 * @version 1
 */
class FindItemByName extends BaseAction {
    /**.
     * Constructor for FindItemByName internal external class.
     * @param name of the action.
     * @param key of the action.
     */
    FindItemByName(String name, int key) {
        super(name, key);
    }

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
}