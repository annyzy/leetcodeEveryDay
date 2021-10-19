import java.util.*;

class Greedy {
    //Time: O(n)
    public int jump(int[] nums) {
        int len = nums.length;
        //edge case
        if(len==0) return 0;

        int ans = 0, r = 0, farthest = 0;
        for(int i = 0 ; i < len; i++){
            farthest = Math.max(farthest, i + nums[i]);
            //if reach the end of jump window but not the end of the array, make a jump
            if(i==r && i!= len-1){
                ans++;
                r=farthest;
            }
        }
        return ans;
    }
}
