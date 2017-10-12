package LeetCode;

public class MedianOfTwoSortedArrays {

    public static void main(String[] a){

        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4};

//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    // [1, 3]
    // [2]
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums2.length == 0) {
            int mid = (nums1.length - 1)/2;
            return findMiddle(nums1, nums1, 0, mid, mid + 1, nums1.length - 1);
        }
        if(nums1.length == 0) {
            int mid = (nums2.length - 1)/2;
            return findMiddle(nums2, nums2, 0, mid, mid + 1, nums2.length - 1);
        }

        return findMiddle(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
    }

    // s1 = 0, (0), (0)
    // e1 = 1, (1), (0)
    // s2 = 0, (1), (1)
    // e2 = 0, (0), (0)
    public static double findMiddle(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2) {

        int len1 = (e1 - s1); // 1 - 0, (0 - 0) = 0, (0 - 0) = 0
        int len2 = (e2 - s2); // 0 - 0, (1 - 1) = 0, (0 - 1) = -1

        if (len1 >= 0 && len2 < 0) return nums1[s1]; // [0] = 2
        if (len2 >= 0 && len1 < 0) return nums2[s2];

        if ((len1 + len2) % 2 == 0) { // 1 % 2 != 0
            //return (double) (nums1[s1 + len1] + nums2[s2 + len2]) / 2; // [0 + 0] = 1, [1 + 0] = 3
            return (double) (nums1[s1 + len1] + nums2[s2]) / 2; // [0 + 0] = 1, [1 + 0] = 3
        }

        int mid1 = len1 / 2; // 0
        int mid2 = len2 / 2; // 0
        return (findMiddle(nums1, nums1, s1, mid1, mid1 + 1, e1) +    // (1 + 3) / 2 = 2
                findMiddle(nums2, nums2, s2, mid2, mid2 + 1, e2)) / 2;    // 2
        // (2 + 2) / 2 = 2
    }

}
