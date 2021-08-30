import java.util.*;

class dynamicProgramming {
    public int climbStairs(int n) {
        if (n < 1)
            return 0;
        // jump from 0th step
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // dp[i]: how many method to climb up to nth step
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}