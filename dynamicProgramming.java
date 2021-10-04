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
            1 a   T F T
            2 b     T F
            3 a       T
        */
        for(int  j = 0; j < len; j++){
            for (int i = 0; i <= j; i++){
                //skip the value if the character at i and j position is not the same
                if(s.charAt(i) != s.charAt(j)) continue;
                if(i == j || j-i <= 1) {
                    dp[i][j] = true;
                } else{
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
    public int countPalindromicSubstrings(String s) {
        //edge case
        if (s.length() <= 0) return 0;
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;

        /*    j 0 1 2 3
            i   a a b a
            0 a T T F F
            1 a   T F T
            2 b     T F
            3 a       T
        */
        for(int  j = 0; j < len; j++){
            for (int i = 0; i <= j; i++){
                //skip the value if the character at i and j position is not the same
                if(s.charAt(i) != s.charAt(j)) continue;
                if( i == j ) {
                    dp[i][j] = true;
                    ans++;
                } else if( j-i <=2 ){
                    //"aa". "aba"
                    dp[i][j] = true;
                    ans++;
                }else if( dp[i+1][j-1] ){
                    //"axxxxxa", only need to check if xxxxx is palidrome of not
                    dp[i][j] = true;
                    ans++;
                }
                
            }
        }
        return ans;        
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //edge case
        if(s.length() <= 0 ) return false;
        
        int len = s.length();
        Set<String> set = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[len + 1];
        
        dp[0] = true;
        
        for(int i  = 1; i <= len; i ++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
}