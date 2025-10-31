import java.util.Arrays;

public class LongestPalindromicString {
    public static void main(String[] args) {

        var lognest = new LongestPalindromicString();
        String s = "abccbc";
        // System.out.println(lognest.longestPalindrome(s));
        System.out.println(lognest.longestPalindrome1(s));
    }

    public String longestPalindrome1(String s) {
        String res = "";
        // orbit and axis method
        // odd length palindromes
        for (int axis = 0; axis < s.length(); axis++) {
            // odd length palindromes - in odd cases starting orbit and length is always 1.
            int orbit = 1;
            int length = 1;
            while ((axis - orbit) >= 0 && (axis + orbit) < s.length()) {
                if (s.charAt(axis - orbit) == s.charAt(axis + orbit)) {
                    orbit++;
                    length = length + 2;

                } else {
                    break;
                }
            }

            if (length > res.length()) {
                int si = axis - length / 2;
                res = s.substring(si, si + length);
            }

        }
        // even number substring
        for (int ax = 0; ax < s.length() - 1; ax++) {
            int orbit = 1; // incase of even length length at starting is 0 and we compare with ax-orbit+1
                           // chracter with ax+orbit
            int length = 0;
            while ((ax - orbit + 1) >= 0 && (ax + orbit) < s.length()) {
                if (s.charAt(ax - orbit + 1) == s.charAt(ax + orbit)) {
                    orbit++;
                    length = length + 2;
                } else {
                    break;
                }
            }
            if (length > res.length()) {
                int si = ax - length / 2 + 1; // notice that length is also ax-length/2 +1 ;
                res = s.substring(si, si + length);
            }
        }
        return res;
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
