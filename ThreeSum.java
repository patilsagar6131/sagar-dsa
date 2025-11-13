import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {

        int[] nums = { -1, 0, 1, 2, -1, -4 };
        var ts = new ThreeSum();
        System.out.println(ts.threeSum1(nums));

    }

    // optimized code
    // in this approach we first sort the array and then select 1 num from nums
    // array
    // then set the pointer at left most and right most part
    // calucate the new sum by substracting current outer loop num from target
    // then check the new sum of li and ri digits if it is more we bring ri closer
    // to li
    // if it is less we bring li close to ri
    // if sum is new sum then we add the 3 nums to list.
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> uniquetrLists = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int newTarget = 0 - nums[i];
            int li = i + 1;
            int ri = nums.length - 1;
            while (li < ri) {
                if (nums[li] + nums[ri] > newTarget) {
                    ri--;
                } else if (nums[li] + nums[ri] < newTarget) {
                    li++;
                } else {
                    uniquetrLists.add((List.of(nums[i], nums[li], nums[ri])));
                    li++;
                    ri--;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(uniquetrLists);

        System.out.println(list);
        return list;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        List<Integer> triplets = Arrays.asList(nums[i], nums[k], nums[j]);
                        Collections.sort(triplets);
                        uniqueTriplets.add(triplets);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(uniqueTriplets);
        return ans;
    }
}
