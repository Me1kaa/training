package home;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task03LengthOfLongestIncSubSequenceTest {

    private final Task03LengthOfLongestIncSubSequence solution = new Task03LengthOfLongestIncSubSequence();

    @Test
    public void lengthOfLongestIncreasingSubSequenceTest() {
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0, 5, 2, 3, 4, 7, 9, 10}), 7);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0, 5, 2, 7, 9}), 4);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{5, 2, 0, 1}), 2);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 5}), 5);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0}), 1);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{}), 0);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{3, 2, 1}), 1);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{1, 2}), 2);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{2, 1}), 1);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, 2, 3, 4, 7, 9, 10}), 9);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 7, 9, 10}), 9);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 0, 1, 0, 1}), 2);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 7, 8}), 9);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, -3, -2, -1, 2, 3, 4, 5, 6, 7, 8}), 10);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}), 1);
        assertEquals(solution.lengthOfLongestIncreasingSubSequence(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}), 2);


    }
}