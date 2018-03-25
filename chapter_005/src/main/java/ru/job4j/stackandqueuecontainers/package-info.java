/**
 * Используя контейнер на базе связанного списка создать контейнер Stack и Queue.
 * Метод poll - должен возвращать значение и удалять его из коллекции.
 * При реализации очереди и стека можете использовать коллекции, которые вы реализовывали в предыдущих заданиях.
 *
 * Описание Queue - очередь. Описывается FIFO - first input first output.
 * То есть, первый зашел и первый вышел. Например.
 *
 * push(1);
 * push(2);
 * push(3);
 *
 * poll() - 1
 * poll() - 2
 * poll() - 3
 *
 * Описание Stack - стек. Описывается LIFO - last input first output.
 * То есть, последний зашел и первый вышел. Например.
 *
 * push(1);
 * push(2);
 * push(3);
 *
 * poll() - 3
 * poll() - 2
 * poll() - 1
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 03.25.2018
 */
package ru.job4j.stackandqueuecontainers;