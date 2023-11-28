package DynamicProgramming;

// Question; How many ways you can move in m*n matrix if you can only move down/ right

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    public static void execute() {
        logic(18, 18);
    }

    public static void logic(long m, long n) {
        Map<String, Long> memo = new HashMap();
        Long result = logic(m, n, memo);
        System.out.println(result);
    }

    public static long logic(long m, long n, Map<String, Long> memo) {
        String key = m + "," + n;
        // Get From Cache
        if (memo.containsKey(key)) return memo.get(key);

        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        // Memoisation
        memo.put(key, logic(m - 1, n, memo) + logic(m, n - 1, memo));
        return memo.get(key);

    }
}
