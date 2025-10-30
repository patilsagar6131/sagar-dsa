import java.util.Arrays;

class MedianTwoSortedArrays {
    public static void main(String[] args) {
        var medianTwo = new MedianTwoSortedArrays();
        int[] a7 = { 1, 2 };
        int[] a8 = { 3, 4 };
        System.out.println(medianTwo.findMedianSortedArrays(a7, a8));
    }

    // optimized solution without sorting
    // in this we inistialized two pointer at the beginning of each array and then
    // compared the element at both the pointers and added smallest element to a
    // third combined(of length of 1+2) array and then found the median so time
    // complexity is O(n+m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                mergedArray[count] = nums1[p1];
                count++;
                p1++;
            } else {
                mergedArray[count] = nums2[p2];
                count++;
                p2++;
            }
        }
        while (p1 < nums1.length) {
            mergedArray[count] = nums1[p1];
            count++;
            p1++;
        }
        while (p2 < nums2.length) {
            mergedArray[count] = nums2[p2];
            count++;
            p2++;
        }
        int z = nums1.length + nums2.length;
        System.out.println(Arrays.toString(mergedArray));
        if (z % 2 == 0) {
            return (mergedArray[(z / 2)] + mergedArray[(z / 2) - 1]) / 2.0;
        } else {
            return mergedArray[z / 2];
        }

    }

}

// // merging the two arrays and then sorting them and then finding the median
// public double findMedianSortedArrays(int[] nums1, int[] nums2) {
// var l1 = nums1.length;
// var l2 = nums2.length;
// var sumoflength = l1 + l2;
// var nums3 = new int[sumoflength];
// for (int i = 0; i < nums1.length; i++) {
// if (i < nums1.length) {
// nums3[i] = nums1[i];
// } else {
// break;
// }
// }

// for (int i = 0; i < nums2.length; i++) {
// nums3[i + nums1.length] = nums2[i];
// }
// Arrays.sort(nums3);
// if (nums3.length % 2 == 0) {
// int medianDigit1 = sumoflength / 2 - 1;
// int medianDigit2 = sumoflength / 2;
// double median = (nums3[medianDigit1] + nums3[medianDigit2]) / 2.0;
// return median;

// } else {
// return nums3[sumoflength / 2];
// }

// }
