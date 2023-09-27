package Arrays;

import java.util.Arrays;

public class RotateArray {

    public static void execute() {
        logic(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//        System.out.println(findGCD(46, 11));
    }


    public static void logic(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle the case where k is larger than the array size
        int step = n-k;

        // Reverse the first part of the array (0 to n - k - 1)
        reverse(nums, 0, step - 1);

        // Reverse the second part of the array (n - k to n - 1)
        reverse(nums, step, n - 1);

        // Reverse the entire array to obtain the final result
        reverse(nums, 0, n - 1);

        System.out.println(Arrays.toString(nums));
    }


    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
