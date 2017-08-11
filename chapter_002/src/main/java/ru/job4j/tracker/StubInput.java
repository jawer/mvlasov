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
     * Simulate asking.
     * @param question array
     * @return String answer
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**.
     * Simulate asking overload.
     * @param question array
     * @param range of valid keys
     * @return int answer
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
