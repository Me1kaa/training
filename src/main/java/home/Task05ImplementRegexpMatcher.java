package home;


//Regular Expression Matching

//'.' -> matches any single character
//'*' -> matches zero or more of the preceding character

//Given a string and a pattern, return true if it can be matched
//input can be empty or a string of characters from lowercase a-z
//pattern: [a-z] .  *
//
/*

s = "aab"
p = "c*a*b" -> true

s = "aa"
p = "a" -> false

s = "aa"
p = "ab" -> false

s = "aa"
p = "aa" -> true


s = "aa"
p = "a*" -> true

s = "aa"
p = "a." -> true

s = "aabbb"
p = ".*" -> false

s = "aabbb"
p = ".*b*" -> true

s = "aabbb"
p = ".*.*" -> true

s = "cbc"
p = "cb.*" -> true

s = "cb"
p = "cb.*" -> true

s = "cbcd"
p = "cb.*" -> true


s = "abc"
p = "a.c"

s = "bbc"
p = "a.c"

s = "abc"
p = "a.c"

// a
// b

*/

//     i a b c
//   a
//   .
//   c


//   a b
// a 1 0
// b 0 1
// c 0 0


//   a . c
// a 1 0 0
// b 0 1 0
// c 0 0 1

// a
// b
//(a)(.*)()
/*            .*
        "" a  . . .
    ""  1  0  0
    a   0  1  0
    b   0  0  1
    c   0  0  0 1
    d   0  0  0   1

 */


//   ""  a . c d
//""  1  0 0 0 0
// a  0  1 0 0 0
// b  0  0 0 0 0
// c  0  0 0 0 0

// b (a . c d) -> 0 0 0 0
// b (a . c d) -> 0 0 0 0
// c (a . c d )-> 0 0 0 0


//input b
//pattern: a .


// aa (a)
// a a && (a, "")

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task05ImplementRegexpMatcher {

    public static final char DOT_PATTERN = '.';
    public static final char STAR_PATTERN = '*';

    public boolean isMatch(String s, String p) {
        List<Pattern> patterns = constructPattern(p);
        boolean[][] filterMatrix = new boolean[s.length() + 1][patterns.size() + 1];
        filterMatrix[0][0] = true;
        for (int i = 0; i < patterns.size(); i++) {
            filterMatrix[0][i + 1] = patterns.get(i).isZeroOrMore;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < patterns.size(); j++) {
                Pattern pattern = patterns.get(j);
                if (pattern.isZeroOrMore) {
                    if (filterMatrix[i + 1][j]) {
                        filterMatrix[i + 1][j + 1] = true;
                    } else {
                        if ((pattern.letter == DOT_PATTERN || c == pattern.letter)
                                && (filterMatrix[i][j] || filterMatrix[i][j + 1])) {
                            filterMatrix[i + 1][j + 1] = true;
                        }
                    }
                } else {
                    if ((pattern.letter == DOT_PATTERN || c == pattern.letter) && filterMatrix[i][j]) {
                        filterMatrix[i + 1][j + 1] = true;
                    }
                }
            }
        }

        return filterMatrix[s.length()][patterns.size()];
    }

    private List<Pattern> constructPattern(String regexp) {
        List<Pattern> result = new ArrayList<>();
        for (int i = 0; i < regexp.length(); i++) {
            char cur = regexp.charAt(i);
            if (i + 1 < regexp.length()) {
                char next = regexp.charAt(i + 1);
                if (cur == STAR_PATTERN) continue;
                if (next == STAR_PATTERN) {
                    result.add(new Pattern(cur, true));
                } else {
                    result.add(new Pattern(cur, false));
                }
            } else {
                if (cur == STAR_PATTERN) break;
                result.add(new Pattern(cur, false));
            }
        }
        return result;
    }

    private static class Pattern {
        char letter;
        boolean isZeroOrMore;

        public Pattern(char letter, boolean isZeroOrMore) {
            this.letter = letter;
            this.isZeroOrMore = isZeroOrMore;
        }

        @Override
        public String toString() {
            return "" + letter + (isZeroOrMore ? "*" : "");
        }
    }

}
