import java.util.Arrays;

class MedianTwoSortedArrays {
    public static void main(String[] args) {
        var medianTwo = new MedianTwoSortedArrays();
        int[] a7 = { 1, 3, 5, 7, 9 };
        int[] a8 = { 2, 8, 10, 12, 14, 18, 20 };
        System.out.println(medianTwo.findMedianSortedArrays(a7, a8));
    }

    // merging the two arrays and then sorting them and then finding the median
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var l1 = nums1.length;
        var l2 = nums2.length;
        var sumoflength = l1 + l2;
        var nums3 = new int[sumoflength];
        for (int i = 0; i < nums1.length; i++) {
            if (i < nums1.length) {
                nums3[i] = nums1[i];
            } else {
                break;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            nums3[i + nums1.length] = nums2[i];
        }
        Arrays.sort(nums3);
        if (nums3.length % 2 == 0) {
            int medianDigit1 = sumoflength / 2 - 1;
            int medianDigit2 = sumoflength / 2;
            double median = (nums3[medianDigit1] + nums3[medianDigit2]) / 2.0;
            return median;

        } else {
            return nums3[sumoflength / 2];
        }

    }
}