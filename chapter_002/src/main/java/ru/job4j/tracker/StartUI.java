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
     * Constructor for StartUI class.
     * @param input interface.
     */
    public StartUI(Input input) {
        this.input = input;
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
         * Class Tracker object initialization.
         */
        Tracker tracker = new Tracker();
        /**.
         * Contains user's choice.
         */
        String choise = input.ask(question);

        while (!"6".equals(choise)) {
            if ("0".equals(choise)) {
                String name = input.ask("Enter name: ");
                String description = input.ask("Enter description: ");
                tracker.add(new Item(name, description));

            } else if ("1".equals(choise)) {
                Item[] items = tracker.findAll();
                for (Item item: items) {
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

            } else if ("2".equals(choise)) {
                String id = input.ask("Enter id of the task you want to edit: ");
                Item item = tracker.findById(id);

                if (item == null) {
                    System.out.println("No task found");

                } else {
                    System.out.println(String.format("Name of task: %s"
                                                    + System.lineSeparator()
                                                    + "Description: %s"
                                                    + System.lineSeparator()
                                                    + "ID: %s" + System.lineSeparator()
                                                    + "Date of creation: %s",
                            item.getName(), item.getDescription(), item.getId(), simpleDateFormat.format(item.getCreated())
                    ));
                    String desc = input.ask("Enter new description: ");
                    item.setDescription(desc);
                    tracker.update(item);
                }

            } else if ("3".equals(choise)) {
                String id = input.ask("Enter id of the task you want to edit: ");
                Item item = tracker.findById(id);

                if (item == null) {
                    System.out.println("No task found");

                } else {
                    tracker.delete(item);
                    System.out.println("The task was deleted.");
                }

            } else if ("4".equals(choise)) {
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

            } else if ("5".equals(choise)) {
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
            choise = input.ask(question);
        }
    }
}
