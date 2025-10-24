// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Input: nums = [3,3], target = 6
// Output: [0,1]

import java.util.Arrays;
import java.util.HashMap;

class Solution2 {
    public static void main(String[] args) {
        var solution = new Solution2();
        int nums[] = { 3, 2, 4 };
        int target = 6;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        var hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        } //
        for (int j = 0; j < nums.length; j++) {
            int bal = target - nums[j];
            if (hm.containsKey(bal) & hm.get(bal) != j) {
                solution[0] = j;
                solution[1] = hm.get(bal);
                return solution;
            }
        }
        return solution;
    }

}