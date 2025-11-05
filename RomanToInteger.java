public class RomanToInteger {
    public static void main(String[] args) {
        var romToInt = new RomanToInteger();
        System.out.println(romToInt.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'M') {
                ans = ans + 1000;
                i++;
            } else if (s.charAt(i) == 'D') {
                ans = ans + 500;
                i++;
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    ans = ans + 400;
                    i = i + 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    ans = ans + 900;
                    i = i + 2;
                } else {
                    ans = ans + 100;
                    i++;
                }

            } else if (s.charAt(i) == 'L') {
                ans = ans + 50;
                i++;
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    ans = ans + 40;
                    i = i + 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    ans = ans + 90;
                    i = i + 2;
                } else {
                    ans = ans + 10;
                    i++;
                }

            } else if (s.charAt(i) == 'V') {
                ans = ans + 5;
                i++;
            } else if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    ans = ans + 4;
                    i = i + 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    ans = ans + 9;
                    i = i + 2;
                } else {
                    ans = ans + 1;
                    i++;
                }
            }
        }
        return ans;
    }
}
