import java.util.Arrays;

public class MaxWaterContrainer {
    public static void main(String[] args) {
        var max = new MaxWaterContrainer();
        var height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // System.out.println(max.maxArea(height));
        System.out.println(max.solution1(height));
    }

    public int maxArea(int[] height) {

        int maxwater = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {
                int maxheight = Math.min(height[i], height[j]);
                int width = j - i;
                int water = maxheight * width;
                if (water > maxwater) {
                    maxwater = water;
                }
            }
        }
        return maxwater;
    }

    // in this approach we initially take 2 pointers 1 at left most part of array
    // and other at right most
    // we then compare assuiming that most water will be stored between left and
    // right most pointers ignoring the one in the middle.
    // calculation is done on basis (width* height = (p2-p1)*
    // Math.min(height[p2],height[p1])).
    // if left part is small (height[p2]<height[p1]) then we increase p1 and if
    // other wise we decrease p2.
    public int solution1(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int[] ans = new int[height.length];
        int res = 0;
        while (p1 < p2) {
            int water = (p2 - p1) * Math.min(height[p1], height[p2]);

            res = Math.max(water, res);
            if (height[p1] < height[p2]) {
                ans[p1] = water;
                p1++;
            } else {
                ans[p2] = water;
                p2--;
            }
        }
        System.out.println(Arrays.toString(ans));
        return res;

    }
}
