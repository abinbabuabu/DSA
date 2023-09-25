package Arrays;

import java.util.HashMap;

/*
  Hard : https://leetcode.com/problems/first-missing-positive/description/
*/

public class FindTheSmallestMissingPositive {

    public static void execute() {
        int[] input = inputs();
        logic(input);
    }

    public static int[] inputs() {
        int[] nums = new int[]{1,2,0};
//        int[] nums =  new int[]{3,4,-1,1};
//        int[] nums = new int[]{7, 8, 9, 11, 12};
        return nums;
    }

    public static int logic(int[] nums) {
        // Assume Smallest one is missing first
        int smallestMissing = 1;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap();
        while (i < nums.length) {
            if (nums[i] == smallestMissing) {
                do {
                    smallestMissing++;
                } while (map.containsKey(smallestMissing));
                // if we encounter any number equals to the smallest one we increment it
                // and also checks if its there already
            }
            map.put(nums[i], i);
            i++;
        }
        System.out.println(smallestMissing);
        return smallestMissing;
    }
}
