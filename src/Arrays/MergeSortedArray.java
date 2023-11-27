package Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void execute() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;

        logic(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }

    public static void logic(int [] nums1, int m, int [] nums2, int n){
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0 ) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
