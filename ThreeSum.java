import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class ThreeSum {
    public static void main(String[] args) {
        var ts = new ThreeSum();
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(ts.threeSum1(arr));
    }

    public List<List<Integer>> threeSum1(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> uniquetriplets = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            for (int k = i + 2; k < arr.length; k++) {
                if (arr[i] + arr[j] + arr[k] == 0) {
                    var triplets = Arrays.asList(arr[i], arr[j], arr[k]);
                    Collections.sort(triplets);
                    uniquetriplets.add(triplets);
                }
            }

        }
        List<List<Integer>> ans = new ArrayList<>(uniquetriplets);
        return ans;

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
