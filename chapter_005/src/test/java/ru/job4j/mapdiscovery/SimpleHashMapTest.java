package ru.job4j.mapdiscovery;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**.
 * Class SimpleHashMapTest tests SimpleHashMap class.
 * @author Mikhail Vlasov
 * @since 20.05.2018
 * @version 1
 */
public class SimpleHashMapTest {
    /**.
     * Tests insert().
     */
    @Test
    public void whenAddValueShouldContainTheValue() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<String, String>();

        assertThat(shm.contains("key1"), is(false));
        shm.insert("key1", "val1");
        assertThat(shm.contains("key1"), is(true));
    }

    /**.
     * Tests contains().
     */
    @Test
    public void whenTestContainsShouldReturnExpectedValues() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<String, String>();

        for (int i = 0; i < 11; i++) {
            shm.insert(String.format("key%d", i), String.format("val%d", i));
        }

        assertThat(shm.contains("key0"), is(true));
        assertThat(shm.contains("key1"), is(true));
        assertThat(shm.contains("key2"), is(true));
        assertThat(shm.contains("key3"), is(true));
        assertThat(shm.contains("key4"), is(true));
        assertThat(shm.contains("key5"), is(true));
        assertThat(shm.contains("key6"), is(true));
        assertThat(shm.contains("key7"), is(true));
        assertThat(shm.contains("key8"), is(true));
        assertThat(shm.contains("key9"), is(false));
        assertThat(shm.contains("key10"), is(true));
        assertThat(shm.contains("key11"), is(false));
    }

    /**.
     * Tests iterator().
     */
    @Test (expected = NoSuchElementException.class)
    public void whenTestIteratorShouldReturnExpectedValues() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<String, String>();

        for (int i = 0; i < 11; i++) {
            shm.insert(String.format("key%d", i), String.format("val%d", i));
        }

        Iterator<SimpleHashMap.Node> it = shm.iterator();

        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val3"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val4"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val5"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val6"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val7"));
        assertThat(it.next().getValue(), is("val8"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val10"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val0"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("val2"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**.
     * Tests get().
     */
    @Test (expected = NoSuchElementException.class)
    public void whenGetShouldReturnExpectedValues() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<String, String>();

        for (int i = 0; i < 11; i++) {
            shm.insert(String.format("key%d", i), String.format("val%d", i));
        }

        assertThat(shm.get("key0"), is("val0"));
        assertThat(shm.get("key1"), is("val1"));
        assertThat(shm.get("key2"), is("val2"));
        assertThat(shm.get("key3"), is("val3"));
        assertThat(shm.get("key4"), is("val4"));
        assertThat(shm.get("key5"), is("val5"));
        assertThat(shm.get("key6"), is("val6"));
        assertThat(shm.get("key7"), is("val7"));
        assertThat(shm.get("key8"), is("val8"));
        assertThat(shm.get("key10"), is("val10"));
        shm.get("key9");
    }

    /**.
     * Tests delete().
     */
    @Test (expected = NoSuchElementException.class)
    public void whenDeleteShouldEraseTheValue() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<String, String>();

        for (int i = 0; i < 11; i++) {
            shm.insert(String.format("key%d", i), String.format("val%d", i));
        }

        assertThat(shm.get("key0"), is("val0"));
        assertThat(shm.get("key1"), is("val1"));
        assertThat(shm.get("key2"), is("val2"));
        assertThat(shm.get("key3"), is("val3"));
        assertThat(shm.get("key4"), is("val4"));
        assertThat(shm.get("key5"), is("val5"));
        assertThat(shm.contains("key2"), is(true));
        shm.delete("key2");
        assertThat(shm.get("key6"), is("val6"));
        assertThat(shm.get("key7"), is("val7"));
        assertThat(shm.get("key8"), is("val8"));
        assertThat(shm.get("key10"), is("val10"));
        assertThat(shm.contains("key2"), is(false));
        shm.get("key9");
    }
}
