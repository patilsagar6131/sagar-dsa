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
        // System.out.println(longestsubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestsubstring.lengthOfLongestSubstring("abcabcbb"));
    }

    // Most optimized solution
    // sliding window approach. We initially point start and end at starting char of
    // string then slide end 1-1 char to right
    // and add end char to hashset. hence creating a window. And check if this set
    // has char currently end is pointing towards.
    // If set has the char end is pointing to then we increase the start and remove
    // 1-1 char from set upto the point that character
    // at the end is not in the set.

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int length = 0;
        int maxLength = 0;
        var hs = new HashSet<Character>();
        while (end < s.length()) {
            if (!hs.contains(s.charAt(end))) {
                hs.add(s.charAt(end));
                length = end - start + 1;
                end++;
                maxLength = Math.max(length, maxLength);
            } else {
                while (start < end && hs.contains(s.charAt(end))) {
                    hs.remove(s.charAt(start));
                    start++;
                }
            }
        }
        return maxLength;
    }
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

// public int lengthOfLongestSubstring(String s) {
// int[] ans = new int[s.length()];
// for (int i = 0; i < s.length(); i++) {
// var hs = new HashSet<Character>();

// for (int j = i; j < s.length(); j++) {
// if (!hs.contains(s.charAt(j))) {
// hs.add(s.charAt(j));
// ans[i] = ans[i] + 1;
// } else {
// break;
// }
// }

// }
// System.out.println(Arrays.toString(ans));
// int max = 0;
// for (int k : ans) {
// max = Math.max(k, max);
// }
// return max;
// }
