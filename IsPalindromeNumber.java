class IsPalindromeNumber {
    public static void main(String[] args) {
        var isPalindromeNumber = new IsPalindromeNumber();
        System.out.println(isPalindromeNumber.isPalindrome(212));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        boolean reverse = isPalindromeNumber(x);
        if (reverse == true) {
            return true;
        }
        return false;

    }

    boolean isPalindromeNumber(int x) {
        int rev = 0;
        int given = x;
        while (x > 0) {
            rev = (10 * rev) + (x % 10);
            x = x / 10;
        }
        if (rev == given) {
            return true;
        }
        return false;
    }
}