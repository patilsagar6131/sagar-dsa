public class ReverseAInteger {
    public static void main(String[] args) {
        var reverseInt = new ReverseAInteger();
        int x = 1534236469;
        System.out.println(reverseInt.reverse(x));

    }

    public int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            if (reverse > Integer.MAX_VALUE / 10 || reverse == Integer.MAX_VALUE && (x % 10) > 7) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 || reverse == Integer.MIN_VALUE && (x % 10) < -8) {
                return 0;
            }
            reverse = (10 * reverse) + (x % 10);
            x = x / 10;
        }
        System.out.println("Hello");
        return reverse;
    }
}