package home;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Task06CountDistanceBetweenStringsTest {

    private final Task06CountDistanceBetweenStrings solution = new Task06CountDistanceBetweenStrings();

    @Test
    public void countDistance() {
        assertThat(solution.countDistance("paladin", "blabladin"), is(3));
        assertThat(solution.countDistance("", ""), is(0));
        assertThat(solution.countDistance("a", "a"), is(0));
        assertThat(solution.countDistance("ab", "ab"), is(0));
        assertThat(solution.countDistance("paladin", "paladin"), is(0));
        assertThat(solution.countDistance("banana", "blabladin"), is(6));
        assertThat(solution.countDistance("robot", "krobot"), is(1));
        assertThat(solution.countDistance("horse", "ros"), is(3));
        assertThat(solution.countDistance("intention", "execution"), is(5));
        assertThat(solution.countDistance("plasma", "altriusm"), is(6));
    }
}