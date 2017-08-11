package ru.job4j.tracker;

/**.
 * Interface Input asks questions
 * @author Mikhail Vlasov
 * @since 6.4.2017
 * @version 1
 */
public interface Input {
    /**.
     * Asking a question
     * @param question for input.
     * @return String input.
     */
    String ask(String question);

    /**.
     * Asking a question overload.
     * @param question for input.
     * @param range of choice.
     * @return int key.
     */
    int ask(String question, int[] range);
}
