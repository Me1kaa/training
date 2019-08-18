package home;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task05ImplementRegexpMatcherTest {

    private final Task05ImplementRegexpMatcher solution = new Task05ImplementRegexpMatcher();

    @Test
    public void isMatchTest() {
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("aa", "a*"));
        assertTrue(solution.isMatch("aa", ".*"));
        assertTrue(solution.isMatch("ab", ".*"));
        assertTrue(solution.isMatch("aab", "c*a*b"));
        assertTrue(solution.isMatch("", ""));
        assertFalse(solution.isMatch("", "."));
        assertTrue(solution.isMatch("", ".*"));
        assertTrue(solution.isMatch("fsjsfjrkfevjemvcwosk", ".*"));
        assertTrue(solution.isMatch("fsjsfjrkfevjemvcwosk", ".*.."));
        assertTrue(solution.isMatch("fsjsfjrkfevjemvcwosk", ".*."));
        assertTrue(solution.isMatch("fff", "..."));
        assertFalse(solution.isMatch("fff", ".."));
        assertTrue(solution.isMatch("aa", "aa"));
        assertTrue(solution.isMatch("aa", "aaa*"));
    }
}