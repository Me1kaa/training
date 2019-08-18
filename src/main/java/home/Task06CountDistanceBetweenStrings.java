package home;


/*

Given word1 and word2, find the mininum number of operations to go from word1 to word2

Allowed Operations:
- Replace a character with another character
- Insert a character
- Delete a character

Examples:
- horse -> ros => 3 operations
  1.) horse -> rorse (replace h with r)
  2.) rorse -> rose (remove r)
  3.) rose -> ros (remove e)

- intention -> execution => 5 operations
  1.) intention -> inention (remove t)
  2.) inention -> enention (replace i with e)
  3.) enention -> exention (replace n with x)
  4.) exention -> exection (replace n with c)
  5.) exection -> execution (insert u)

- plasma  -> altriusm => 6 operations
  plasm //1
  platriusm //4
  pltriusm //5
  altriusm

*/

public class Task06CountDistanceBetweenStrings {


    public int countDistance(String s1, String s2) {
        int[][] countMatrix = new int[s1.length() + 1][s2.length() + 1];
        for (int column = 1; column < s2.length() + 1; column++) {
            countMatrix[0][column] = column;
        }
        for (int row = 1; row < s1.length() + 1; row++) {
            countMatrix[row][0] = row;
        }
        for (int row = 1; row < s1.length() + 1; row++) {
            for (int column = 1; column < s2.length() + 1; column++) {
                countMatrix[row][column] = Math.min(
                        Math.min(
                                countMatrix[row - 1][column] + 1,
                                countMatrix[row][column - 1] + 1),
                        countMatrix[row - 1][column - 1] +
                                (s1.charAt(row - 1) == s2.charAt(column - 1) ? 0 : 1));
            }
        }
        return countMatrix[s1.length()][s2.length()];
    }

}
