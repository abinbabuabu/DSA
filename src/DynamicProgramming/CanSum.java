package DynamicProgramming;


// Given an array and a sum; using any combination can we generate the sum

import java.util.HashMap;
import java.util.Map;

public class CanSum {


    public static void execute() {
        System.out.println(logic(2, new int[]{3, 7, 13}));
        System.out.println(logic(2001, new int[]{10, 4, 4}));
    }

    public static boolean logic(int n, int[] array) {
        return logic(n, array, new HashMap<>());
    }

    public static boolean logic(int n, int[] array, Map<Integer, Boolean> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n == 0) return true;
        if (n < 0) return false;

        for (int value : array) {
            int reminder = n - value;
            if (logic(reminder, array, cache)) {
                cache.put(n, true);
                return true;

            }
        }
        cache.put(n, false);
        return false;
    }


}
