package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static java.lang.Math.abs;

/**.
 * Class Tracker puts all tasks in array
 * @author Mikhail Vlasov
 * @since 5.15.2017
 * @version 1
 */
public class Tracker {
    /**.
     * General ArrayList for Item tasks.
     */
    private List<Item> items = new ArrayList<>();
    /**.
     * Random object
     */
    private static final Random RAND = new Random();

    /**.
     * Generates Id when new Item added
     * @return String id
     */
    private String generateId() {
        return String.valueOf(abs(System.currentTimeMillis() + RAND.nextLong()));
    }

    /**.
     * Adds item in array
     * @param item to add
     * @return Item
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    /**.
     * Updates item in array
     * @param item which needs to be updated
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                break;
            }
        }
    }

    /**.
     * Delets item from array
     * @param item which need to delete
     */
    public void delete(Item item) {
        String id = item.getId();
        Iterator<Item> itr = items.iterator();
        while (itr.hasNext()) {
            Item tempItem = itr.next();
            if (tempItem.getId().equals(id)) {
                itr.remove();
                break;
            }
        }

    }

    /**.
     * Finds all not null items
     * @return Item[] array
     */
    public Item[] findAll() {
        if (items.size() == 0) {
            throw new MenuOutException("В трэкере нет заявок.");
        }
        Item[] resultArray = new Item[items.size()];
        return items.toArray(resultArray);
    }

    /**.
     * Finds all not null items by name
     * @param key to find by name
     * @return Item[] array
     */
    public Item[] findByName(String key) {
        List<Item> tempList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                tempList.add(item);
            }
        }
        Item[] resultArray = new Item[tempList.size()];
        return tempList.toArray(resultArray);
    }

    /**.
     * Finds an item by ID
     * @param id to find by ID
     * @return Item item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
