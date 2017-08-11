package ru.job4j.tracker;

/**.
 * Class ValidateInput extends ConsoleInput to handle exceptions.
 * @author Mikhail Vlasov
 * @since 8.10.2017
 * @version 1
 */
public class ValidateInput extends ConsoleInput {
    /**.
     * Asking a question including range of keys.
     * @param question for input.
     * @param range of choice.
     * @return int user input key.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, select key from the menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter valid key.");
            }
        } while (invalid);
        return value;
    }
}
