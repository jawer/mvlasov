package ru.job4j.tracker;

import java.text.SimpleDateFormat;

/**.
 * Class StartUI entry point
 * @author Mikhail Vlasov
 * @since 6.4.2017
 * @version 1
 */
public class StartUI {
    /**.
     * Variable for Interface
     */
    private Input input;
    /**.
     * Variable for Tracker
     */
    private Tracker tracker;
    /**.
     * Constants for menu choice.
     */
    private static final int ZERO = 0, ONE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6;
    /**.
     * Constructor for StartUI class.
     * @param input interface.
     */
    public StartUI(Input input) {
        this.input = input;
        this.tracker = new Tracker();
    }
    /**.
     * Constructor for StartUI class.
     * @param input interface.
     * @param tracker object.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**.
     * Entry point.
     * @param args string array
     */
    public static void main(String[] args) {
        /**.
         * ConsoleInput class object.
         */
        Input input = new ConsoleInput();
        /**.
         * Starts questionnaire function.
         */
        new StartUI(input).init();
    }

    /**.
     * Main menu
     */
    public void init() {
        /**.
         * Simple date and time of item creation pattern.
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        /**.
         * Main menu string
         */
        String question = "0. Add new Item" + System.lineSeparator()
                        + "1. Show all items" + System.lineSeparator()
                        + "2. Edit item" + System.lineSeparator()
                        + "3. Delete item" + System.lineSeparator()
                        + "4. Find item by Id" + System.lineSeparator()
                        + "5. Find items by name" + System.lineSeparator()
                        + "6. Exit Program" + System.lineSeparator();
        /**.
         * Contains user's choice.
         */
        int choice = Integer.parseInt(input.ask(question));

        while (SIX != choice) {
            if (ZERO == choice) {
                String name = input.ask("Enter name: ");
                String description = input.ask("Enter description: ");
                tracker.add(new Item(name, description));

            } else if (ONE == choice) {
                Item[] items = tracker.findAll();
                if (items == null) {
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

            } else if (TWO == choice) {
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
                            item.getName(), item.getDescription(), item.getId(), simpleDateFormat.format(item.getCreated())
                    ));
                    String desc = input.ask("Enter new description: ");
                    item.setDescription(desc);
                    tracker.update(item);
                }

            } else if (THREE == choice) {
                String id = input.ask("Enter id of the task you want to delete: ");
                Item item = tracker.findById(id);

                if (item == null) {
                    System.out.println("No task found");

                } else {
                    tracker.delete(item);
                    System.out.println("The task was deleted.");
                }

            } else if (FOUR == choice) {
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
                            item.getName(), item.getDescription(), item.getId(), simpleDateFormat.format(item.getCreated())
                    ));
                }

            } else if (FIVE == choice) {
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
                                item.getName(), item.getDescription(), item.getId(), simpleDateFormat.format(item.getCreated())
                        ));
                    }
                }
            }
            choice = Integer.parseInt(input.ask(question));
        }
    }
}
