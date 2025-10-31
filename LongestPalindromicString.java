import java.util.Arrays;

public class LongestPalindromicString {
    public static void main(String[] args) {

        var lognest = new LongestPalindromicString();
        String s = "babadmadam";
        System.out.println(lognest.longestPalindrome(s));
    }

    // in this solution we have two for loops . Outer one trvaels full string once
    // and inner one iterates from current outer loop position to the last index of
    // given string. Checks whether the substring formed by these two pointers (i
    // and j) is palindrome , if yes then adds it to ans array.

    public String longestPalindrome(String s) {
        var ans = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = "";
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                var sbs = s.substring(i, j);
                if (isPalindrome(sbs)) {
                    ans[i] = sbs;
                }
            }
        }

        System.out.println(Arrays.toString(ans));
        String longestSubstr = "";
        for (String ele : ans) {
            if (ele.length() > longestSubstr.length()) {
                longestSubstr = ele;
            }

        }
        return longestSubstr;
    }

    boolean isPalindrome(String str) {
        int end = str.length() - 1;
        int start = 0;
        while (end > start) {
            if (str.charAt(end) != str.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
