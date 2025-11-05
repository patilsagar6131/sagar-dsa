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
