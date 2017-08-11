package ru.job4j.tracker;

import java.util.Scanner;

/**.
 * Class ConsoleInput implements input from console.
 * @author Mikhail Vlasov
 * @since 6.4.2017
 * @version 1
 */
public class ConsoleInput implements Input {
    /**.
     * Variable for Scanner class.
     */
    private Scanner scanner = new Scanner(System.in);

    /**.
     * Asking and getting input from console.
     * @param question for user.
     * @return String user input.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**.
     * Asking and getting input from console using simple ask.
     * @param question for user.
     * @param range array of key range.
     * @return int user input key.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
