// An integer x is numerically balanced if for every digit d in the number x, 
// there are exactly d occurrences of that digit in x.

// Given an integer n, return the smallest numerically balanced number strictly greater than n.
// Input: n = 1
// Output: 22

// Input: n = 1000
// Output: 1333
class Solution1 {
    public static void main(String[] args) {
        var solution = new Solution1();
        System.out.println(solution.nextBeautifulNumber(1000));
    }

    // we travel from given number +1 to 1224444 as this is the biggest numerically
    // balanced number just out of given range
    // and check if that number is numerically balanced asd return that
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBalanced(i)) {
                return i;
            }
        }
        return -1;
    }

    // actual logic to find if the number is balanced
    // first create count array of length 10 to keep track of all the nums [1-9] so
    // that we can write how many times each number between 1-9 is repeated how many
    // times
    // then check the occurence of last digit of given x and count its repition and
    // keep it in count array
    // at last IF any number is not occuring its value time(ugly number) return
    // false
    boolean isBalanced(int x) {
        int[] count = new int[10];

        while (x > 0) {
            count[x % 10] = count[x % 10] + 1;
            x = x / 10;
        }
        for (int d = 0; d < 10; d++) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }
}