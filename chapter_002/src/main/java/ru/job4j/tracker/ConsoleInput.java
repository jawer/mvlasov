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
}
