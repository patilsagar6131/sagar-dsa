import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        var tsc = new ThreeSumClosest();
        int[] nums = { -10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int target = 1;
        System.out.println(tsc.threeSumClosest(nums, target));
    }

    // we first sort the array then we set start for loop
    // then we initialize res =0 and gap initially at integer max value
    // and two pointers at right most part of array and left at i+1 position
    // we then calculate the sum and check if it is greter than smaller than or
    // equal to target
    // if it is smaller we take left pointer towards right
    // if it is greater we take right pointer towards left
    // and if it is equal we return the sum

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int li = i + 1;
            int ri = nums.length - 1;

            while (li < ri) {
                int sum = nums[i] + nums[ri] + nums[li];
                if (sum < target) {
                    int ngap = target - sum;
                    if (gap > ngap) {
                        gap = ngap;
                        res = sum;
                    }
                    li++;
                } else if (sum > target) {
                    int ngap = sum - target;
                    if (gap > ngap) {
                        gap = ngap;
                        res = sum;
                    }
                    ri--;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }

}
