package home;

/*

length of longest increasing subsequence
[0, 5, 2, 7, 9] => 4 (0, 5, 7, 9)
[5, 2, 1, 0] => 1 (5 or 2 or 1 or 0)
[5, 2, 0, 1] => 2 (0, 1)
[1, 2 ,3, 4, 1, 2, 3, 4, 5] => 5
*/
public class Task03LengthOfLongestIncSubSequence {

    public int lengthOfLongestIncreasingSubSequence(int[] sequence) {
        if (sequence.length == 0) return 0;
        if (sequence.length == 1) return 1;
        return lengthOfLongestIncreasingSubSequence(1, sequence[0], sequence, 1);
    }

    //Complexity O(constant + 2^n) -> every iteration we make at least 2 recursive calls, which produce n times 2 recursive calls.
    //Space the same O(constant + 2^n) on the STACK because during recursive calls we remember new recursive call args
    //constant represent overhead for supply variables
    private int lengthOfLongestIncreasingSubSequence(int cur, int prev, int[] sequence, int count) {
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
