//Given a string s, find the length of the longest substring without duplicate characters.
//Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class LongestSubstring {
    public static void main(String[] args) {
        var longestsubstring = new LongestSubstring();
        System.out.println(longestsubstring.lengthOfLongestSubstring("pwwkew"));
    }

    // unoptimized code - accepeted.
    // in this approach
    // first an ans array is created to track max length of substring that can be
    // achived from that position
    // without repeating any character
    // outer for loop travels 1 by 1 each characters of the string
    // inner for loop adds the char to hashset and increase the length in ans array
    // till it does not see a repeting char
    // character and also increases ans by 1
    // when inner loop sees that a character repeats it breaks
    // outer loop goes to next character

    public int lengthOfLongestSubstring(String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            var hs = new HashSet<Character>();

            for (int j = i; j < s.length(); j++) {
                if (!hs.contains(s.charAt(j))) {
                    hs.add(s.charAt(j));
                    ans[i] = ans[i] + 1;
                } else {
                    break;
                }
            }

        }
        System.out.println(Arrays.toString(ans));
        int max = 0;
        for (int k : ans) {
            max = Math.max(k, max);
        }
        return max;
    }

}
