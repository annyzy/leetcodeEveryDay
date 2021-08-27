import java.util.*;

class Array{
    public int maxSubArray(int[] nums) {
        int prev = 0, ans = nums[0];
        
        for (int x : nums){
            //if the previous sum is smaller or equal x, trash the previous sum and restart again from x
            prev = Math.max(prev+x,x);
            //find max subarray
            ans = Math.max(ans, prev);
        }
        return ans;
    }
}