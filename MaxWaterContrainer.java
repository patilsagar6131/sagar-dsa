import java.util.Arrays;

public class MaxWaterContrainer {
    public static void main(String[] args) {
        var max = new MaxWaterContrainer();
        var height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(max.maxArea(height));
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
}
