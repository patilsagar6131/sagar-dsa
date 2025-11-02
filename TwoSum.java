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
        int nums[] = { 2, 7, 5, 11 };
        int target = 12;
        // System.out.println(Arrays.toString(solution.twoSum(nums, target)));
        System.out.println(Arrays.toString(solution.twoSum2(nums, target)));

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

    // most optimized
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int i = 0;
        // put balance in hashmap with index as value
        // if bal is already present in hashmap break the loop
        while (i < nums.length && hm.get(nums[i]) == null) {
            hm.put(target - nums[i], i);
            i++;
        }
        // if loop ends prematurely return the indices of bal and current index(because
        // this index has the required balance)
        if (i < nums.length) {
            int[] ans = new int[2];
            ans[0] = hm.get(nums[i]);
            ans[1] = i;
            return ans;
        }
        return null;
    }

}