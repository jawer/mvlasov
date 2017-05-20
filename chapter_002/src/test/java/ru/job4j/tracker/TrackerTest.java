package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hed1n on 5/20/2017.
 */
public class TrackerTest {

    /**.
     * Tests add function
     */
    @Test
    public void whenAddItemThenTrackerHasOneItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "first description", 111L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**.
     * Tests update function
     */
    @Test
    public void whenUpdateItemInTrackerThenUpdatedItemInTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "first description", 111L);
        tracker.add(item);
        item.setDescription("description changed");
        tracker.update(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**.
     * Tests delete function
     */
    @Test
    public void whenDeleteItemInTrackerThenNullInTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "first description", 111L);
        Item item2 = new Item("two", "second description", 222L);
        tracker.add(item);
        tracker.add(item2);
        tracker.delete(item);
        assertThat(tracker.findAll()[0], is(item2));
    }

    /**.
     * Tests findAll function
     */
    @Test
    public void whenFindAllThenNotNullElements() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "first description", 111L);
        Item item2 = new Item("two", "second description", 222L);
        tracker.add(item);
        tracker.add(item2);
        tracker.delete(item);
        assertThat(tracker.findAll().length, is(1));
    }

    /**.
     * Tests findByName function
     */
    @Test
    public void whenPutNameThenArrayOfMatchingElements() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "first description", 111L);
        tracker.add(item);
        Item[] result = tracker.findByName("one");
        Item[] expected = {item};
        assertThat(result, is(expected));
    }

    /**.
     * Tests findById function
     */
    @Test
    public void whenPutIdThenElementWithMatchingId() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "first description", 111L);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result, is(item));
    }
}
