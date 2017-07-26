package ru.job4j.tracker;

/**
 * Created by hed1n on 7/20/2017.
 */
public class StubInput implements Input {
    /**.
     * Variable for array of answers.
     */
    private String[] answers;
    /**.
     * Variable for array position.
     */
    private int position;

    /**.
     * Constructor for StubInput class.
     * @param answers array
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**.
     * Constructor for StubInput class.
     * @param question array
     * @return String answer
     */
    public String ask(String question) {
        return answers[position++];
    }
}
