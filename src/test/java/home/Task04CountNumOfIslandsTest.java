package home;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task04CountNumOfIslandsTest {

    private final Task04CountNumOfIslands solution = new Task04CountNumOfIslands();

    @Test
    public void countIslandsNumTest() {
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 0}, new int[]{0, 1, 0}}), 2);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}}), 1);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{1, 0, 1}, new int[]{0, 1, 0}, new int[]{1, 0, 1}}), 5);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}}), 1);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 1}, new int[]{1, 1, 1}}), 2);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}}), 1);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}), 0);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{0, 0, 0, 1}, new int[]{0, 0, 0, 1}, new int[]{0, 1, 0, 0}}), 2);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{1, 0, 1, 0}, new int[]{0, 1, 0, 1}, new int[]{1, 0, 1, 0}}), 6);
        assertEquals(solution.countIslandsNum(new int[][]{new int[]{1, 0, 0, 1}, new int[]{1, 0, 0, 1}, new int[]{1, 0, 0, 1}}), 2);
    }
}