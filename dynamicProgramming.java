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

    public int coinChange(int[] coins, int amount){
        //edge case
        if(coins.length < 0 || amount < 0) return -1;

        //create an array to hold how many mins coins need to used in each iterations
        int[] dp = new int[amount + 1];
        //initialize the array to a value cannot be reach
        Arrays.fill(dp, amount +1);
        dp[0] = 0;

        /*
          example: coins = [1,2,5], amount = 4
                dp = [0,5,5,5,5]
            i=1  1=1(dp[1]=1) dp[1]=5 dp[0]+1= 1
                dp = [0,1,5,5,5]   
                 1<2(skip)     
                 1<5(skip)
            i=2  2>1(dp[2] =2) dp[2]=5 dp[1]+1=2
                dp = [0,1,2,5,5]   
                 2=2(dp[2] = 1)dp[2]=2 dp[0]+1=1
                dp = [0,1,1,5,5]
                 2<5(skip)
            i=3  3>1(dp[3] = 2)dp[3]=5 dp[2]+1=2
                dp = [0,1,1,2,5]
                 3>2(dp[3] = 2)dp[3]=2 dp[1]+1=2
                dp = [0,1,1,2,5]
                 3<5(skip)
            i=4  4>1(dp[4] = 3)dp[4]=5 dp[3]+1=3
                dp = [0,1,1,2,3]
                 4>2(dp[4] = 3)dp[4]=3 dp[2]+1=2
                dp = [0,1,1,2,2]
                 4<5(skip)
        */
        for(int i  = 1; i <= amount; i++){
            for(int coin : coins){
                //reduce redundant calculations
                if(i-coin < 0) continue;
                dp[i]= Math.min(dp[i], dp[i-coin]+1);
            }
        }

        //after all iterations, cannot find the change for that amount
        if(dp[amount] == amount +1){
            return -1;
        }else{
            return dp[amount];
        }
    }
}