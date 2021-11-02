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

    // Time: O(n)
    public static int calLen(String s) {
        if (s.equals(""))
            return 0;
        return calLen(s.substring(1)) + 1;
    }

    // Time: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // edge case
        if (root == null)
            return null;

        // base case
        if (p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left == null)
            return right;
        if (right == null)
            return left;

        return null;
    }

    int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    // T:O(n)
    public String intToRoman(int num) {
        // edge case
        if (num < 1)
            return null;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < value.length; i++) {
            while (value[i] <= num) {
                num = num - value[i];
                ans.append(symbol[i]);
            }
        }
        return ans.toString();
    }

    // T:O(n)
    public int romanToInt(String s) {
        // edge case
        if (s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev = map.get(s.charAt(0)), ans = 0, len = s.length();
        for (int i = 1; i < len; i++) {
            int num = map.get(s.charAt(i));
            if (prev < num) {
                ans -= prev;
            } else {
                ans += prev;
            }
            prev = num;
        }
        return ans += prev;
    }

    //T: O(n)
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, res = 0, left = 0, right = 0, zeros = 0;

        // edge case
        if (nums.length < 1)
            return 0;

        while (right < n) {
            if (nums[right] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    public static void main(String args[]) {
        String s = "abc";
        System.out.println(calLen(s));
    }

}
