package ru.job4j.tracker;

/**.
 * Class Item defines one task structure
 * @author Mikhail Vlasov
 * @since 5.15.2017
 * @version 1
 */
public class Item {
    /**.
     * ID
     */
    private String id;
    /**.
     * Name
     */
    private String name;
    /**.
     * Description
     */
    private String description;
    /**.
     * Date of creation
     */
    private long created;
    /**.
     * Array of comments
     */
    private String[] comments = new String[100];

    /**.
     * Constructor
     * @param name of task
     * @param description of task
     */
    public Item(String name, String description) {
        setName(name);
        setDescription(description);
        setCreated();
    }

    /**.
     * Setter
     * @param id string
     */
    public void setId(String id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    /**.
     * Setter
     * @param name string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**.
     * Setter
     * @param description string
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**.
     * Setter
     */
    public void setCreated() {
        if (this.created == 0L) {
            this.created = System.currentTimeMillis();
        }
    }

    /**.
     * Setter
     * @param comment string
     */
    public void setComments(String comment) {
        /**.
         * If array of comments is full then increases array length and adds comment
         */
        if (!(comments[comments.length - 1] == null)) {
            String[] newComments = new String[comments.length + 100];
            System.arraycopy(comments, 0, newComments, 0, comments.length);
            newComments[comments.length] = comment;
            comments = newComments;
        } else {
            /**.
             * Otherwise adds comment at the end of the array of comments
             */
            for (int i = 0; i < comments.length; i++) {
                if (comments[i] == null) {
                    comments[i] = comment;
                    break;
                }
            }
        }
    }

    /**.
     * Getter
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**.
     * Getter
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**.
     * Getter
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**.
     * Getter
     * @return long date of creation
     */
    public long getCreated() {
        return created;
    }

    /**.
     * Getter
     * @return String[] array of comments
     */
    public String[] getComments() {
        return comments;
    }
}
