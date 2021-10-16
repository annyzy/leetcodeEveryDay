import java.util.*;
import java.util.Set;

class Hashset{
    public int longestConsecutive(int[] nums) {
        //edge case
        if(nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int num: nums)
            set.add(num);
        
        int longest = 0;
        
        for(int num: set){
            if( !set.contains(num-1)){
                int curr = num;
                int currLen = 1;
                
                while(set.contains(curr + 1)){
                    currLen +=1;
                    curr+=1;
                }
                
                longest = Math.max(currLen,longest);
            }
        }
        
        return longest;
    }
}
