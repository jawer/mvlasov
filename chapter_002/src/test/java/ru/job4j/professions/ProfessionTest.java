package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Vlasov (mailto:hednight@gmail.com)
 * @version 1
 * @since 5.7.2017
 */
public class ProfessionTest {

    /**.
     * Class ProfessionTest testing Profession
     */
    @Test
    public void whenCreateProfessionsAndDoctorHealsThenString() {
        Doctor doctor = new Doctor("Иван");
        Engineer engineer = new Engineer("Сергей");
        Teacher teacher = new Teacher("Томара");
        String expected = "Доктор Иван лечит Сергей";
        String result = doctor.heal(engineer);
        assertThat(result, is(expected));
    }
}
