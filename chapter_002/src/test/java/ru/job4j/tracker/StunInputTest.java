package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hed1n on 7/20/2017.
 */
public class StunInputTest {
    /**.
     * Tests tracker adding function.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        //   создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**.
     * Tests tracker showing function.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("Test name 1", "Test description 1"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("Test name 1"));
    }

    /**.
     * Tests tracker changing description.
     */
    @Test
    public void whenEditThenTrackerHasUpdatedDescription() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name 2", "Test description 2"));
        Input input = new StubInput(new String[]{"2", item.getId(), "New name", "New description", "y"});
        new StartUI(input, tracker).init();
        // проверяем, что заявка изменилась.
        assertThat(tracker.findById(item.getId()).getDescription(), is("New description"));
    }

    /**.
     * Tests tracker deleting function
     */
    @Test
    public void whenDeleteThenTrackerHasDeletedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name 3", "Test description 3"));
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        Item expected = null;
        // проверяем, что заявка удалена.
        assertThat(tracker.findById(item.getId()), is(expected));
    }

    /**.
     * Tests tracker finding by ID.
     */
    @Test
    public void whenLookingByIdThenTrackerShowsItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name 4", "Test description 4"));
        String expectedID = tracker.findById(item.getId()).getId();
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        // проверяем, что заявка найдена по ID.
        assertThat(tracker.findById(item.getId()).getId(), is(expectedID));
    }

    /**.
     * Tests tracker finding by name.
     */
    @Test
    public void whenLookingByNameThenTrackerShowsItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name 5", "Test description 5"));
        Input input = new StubInput(new String[]{"5", "Test name 5", "y"});
        new StartUI(input, tracker).init();
        /**.
         * проверяем, что заявка найдена по имени.
         */
        assertThat(tracker.findById(item.getId()).getName(), is("Test name 5"));
    }
}
