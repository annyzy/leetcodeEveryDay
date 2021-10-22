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

    // Time: O(mn)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (m < 1 || n < 1)
            return 0;

        int[][] dp = new int[m][n];

        // initialize the first column
        for (int i = 0; i < m; i++) {
            // once meet the obstacle, not going to the rest of the grids
            if (obstacleGrid[i][0] == 1)
                break;
            // mark as 1 as there is one way to reach as the first step
            dp[i][0] = 1;
        }

        // same initalize the first row
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
