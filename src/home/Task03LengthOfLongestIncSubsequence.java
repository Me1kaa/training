package home;

/*

length of longest increasing subsequence
[0, 5, 2, 7, 9] => 4 (0, 5, 7, 9)
[5, 2, 1, 0] => 1 (5 or 2 or 1 or 0)
[5, 2, 0, 1] => 2 (0, 1)
[1, 2 ,3, 4, 1, 2, 3, 4, 5] => 5
*/
public class Task03LengthOfLongestIncSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0, 5, 2, 3, 4, 7, 9, 10}) == 7);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0, 5, 2, 7, 9}) == 4);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{5, 2, 0, 1}) == 2);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 5}) == 5);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0}) == 1);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{}) == 0);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{3, 2, 1}) == 1);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{1, 2}) == 2);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{2, 1}) == 1);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, 2, 3, 4, 7, 9, 10}) == 9);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 7, 9, 10}) == 9);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 0, 1, 0, 1}) == 2);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 7, 8}) == 9);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{0, 1, 2, 3, 4, 5, -3, -2, -1, 2, 3, 4, 5, 6, 7, 8}) == 10);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}) == 1);
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}) == 2);
    }


    public static int lengthOfLongestIncreasingSubSequence(int[] sequence) {
        if (sequence.length == 0) return 0;
        if (sequence.length == 1) return 1;
        return lengthOfLongestIncreasingSubSequence(1, sequence[0], sequence, 1);
    }

    private static int lengthOfLongestIncreasingSubSequence(int cur, int prev, int[] sequence, int count) {
        if (cur < sequence.length) {
            if (prev < sequence[cur]) {
                return Math.max(
                        lengthOfLongestIncreasingSubSequence(cur + 1, sequence[cur], sequence, count + 1),
                        lengthOfLongestIncreasingSubSequence(cur + 1, prev, sequence, count)
                );
            } else {
                return Math.max(
                        lengthOfLongestIncreasingSubSequence(cur + 1, prev, sequence, count),
                        lengthOfLongestIncreasingSubSequence(cur + 1, sequence[cur], sequence, 1)
                );
            }
        }
        return count;
    }


}
