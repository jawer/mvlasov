package ru.job4j.tracker;

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
     * Constructor for StartUI class.
     * @param input interface.
     */
    public StartUI(Input input) {
        this.input = input;
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
     * Main menu build and questionnaire.
     */
    public void init() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (!"y".equals(input.ask("Exit?(y): ")));
    }
}
