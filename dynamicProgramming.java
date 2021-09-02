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

    public String longestPalindrome(String s){
        //edge case
        if (s.length() <= 1) return s;
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String ans = "";

        /*    j 0 1 2 3
            i   a a b a
            0 a T T F F
            1 a F T F T
            2 b F F T F
            3 a F F F T
        */
        for(int  j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if(s.charAt(i) != s.charAt(j)) continue;
                if(i == j) {
                    dp[i][j] = true;
                } else if(j-i <=2){
                    //"aa". "aba"
                    dp[i][j] = true;
                }else{
                    //"axxxxxa", only need to check if xxxxx is palidrome of not
                    dp[i][j] = dp[i+1][j-1];
                }
                //get the largest palidrome if ans is palidrome
                if(dp[i][j] && j - i +1 > ans.length()){
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    } 
}