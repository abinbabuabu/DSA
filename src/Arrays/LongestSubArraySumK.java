package Arrays;

import java.util.HashMap;

/**
 * find the longest SubArray with a Specified Sum
 * SubArray -> Continuous Array Values
 */

record Input() {
    static int sum;
    static int[] array;
}

public class LongestSubArraySumK {
    public static void execute() {
        Input input = LongestSubArraySumK.inputs();
//        LongestSubArraySumK.logicBruteForce(input.array, input.sum);
//        LongestSubArraySumK.logicBetterUsingHashMap(input.array, input.sum);
        LongestSubArraySumK.optimalSolution(input.array, input.sum);
    }

    private static Input inputs() {
        Input input = new Input();
//        input.sum = 4;
//        input.array = new int[]{1, 2, 3, 4, 5, 6, 1, 2, 1}; // Answer: 3

//        input.sum = 1;
//        input.array = new int[]{2, 0, 0, 1}; // Answer : 3

        input.sum = 1;
        input.array = new int[]{1, -2, 3, 0}; // Answer: 3

        return input;
    }

    /* Brute Force Approach
       Time Complexity: O(n^2)
     */
    private static void logicBruteForce(int[] a, int sum) {
        int maxLengthOfSubArray = 0;
        for (int i = 0; i < a.length; i++) {
            int s = 0; // sum for this sub array
            for (int j = i; j < a.length; j++) {
                s = s + a[j];
                if (s == sum) {
                    int lengthOfCurrentSubArray = j - i + 1;
                    if (lengthOfCurrentSubArray > maxLengthOfSubArray) {
                        maxLengthOfSubArray = lengthOfCurrentSubArray;
                    }
                }

                if (s > sum)
                    break;
            }
        }
        LongestSubArraySumK.outputResult(sum, maxLengthOfSubArray);
    }

    /*
      Better Approach than Brute Force
      Time Complexity : 0(N) -> Best Case if We are using ordered map and no collitions
                        0(n^2) -> Worst Case Lot of collitions
                        0(nlogn)
      Space Complexity: 0(n) Using Additional Space for HashMap
     */
    private static void logicBetterUsingHashMap(int a[], int sum) {
        int maxLengthOfSubArray = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int recentSum = 0;
        for (int i = 0; i < a.length; i++) {
            recentSum += a[i];

            if (hashMap.containsKey(recentSum - sum)) {
                int previousIndex = hashMap.get(recentSum - sum);
                maxLengthOfSubArray = i - previousIndex;
            }

            if (!hashMap.containsKey(recentSum)) {
                 /* If the Sum Does't exist in the hashMap will create issues for arrays with zero;
                 the value will be overwritten
                 */
                hashMap.put(recentSum, i);
            }
        }

        LongestSubArraySumK.outputResult(sum, maxLengthOfSubArray);
    }


    /*
      Using two pointer approach
      Time Complexity - 0(2N) - the inner while loop won't always run for Max N time;
                                since its always checks for the right pointer;
     */
    private static void optimalSolution(int a[], int sum) {
        int rightPointer = 0;
        int leftPointer = 0;
        int maxSubArrayLength = 0;
        int s = a[0];
        while (rightPointer < a.length) {
            while (s > sum && leftPointer <= rightPointer) {
                s -= a[leftPointer];
                leftPointer++;
            }

            if (s == sum) {
                int currentLengthOfSubArray = rightPointer - leftPointer + 1;
                if (currentLengthOfSubArray > maxSubArrayLength) {
                    maxSubArrayLength = currentLengthOfSubArray;
                }
            }

            rightPointer++;
            if (rightPointer < a.length) {
                s += a[rightPointer];
            }

        }

        outputResult(sum, maxSubArrayLength);

    }


    private static void outputResult(int sum, int maxLengthOfSubArray) {
        if (maxLengthOfSubArray > 0) {
            System.out.printf("Max Length of the SubArray With Sum %d is %d", sum, maxLengthOfSubArray);
            return;
        }
        System.out.println("No SubArrays Found For the Specified Sum");
    }


}
