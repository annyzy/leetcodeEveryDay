import java.util.*;

class Zilou {
    // Time: O(n^2)
    public int fib(int n) {
        // edge case
        if (n < 0)
            return 0;

        // base cases
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }

    // Time: O(n)
    public int fib1(int n) {
        // edge case
        if (n < 0)
            return 0;

        int[] dp = new int[n + 1];

        // base cases
        dp[0] = 0;
        dp[1] = 1;
        // state transfer
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
