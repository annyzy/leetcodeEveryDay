import java.util.*;

class SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        //edge case
        int n = s.length();
        if(n <= 0) return 0;
        
        //key is the character in the string, value is the +1 position of that key
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        
        /*
          example: abcabcbb
          map  key value
                a    1     start:0 end:0 ans:1 end:1
                b    2     start:0 end:1 ans:2 end:2
                c    3     start:0 end:2 ans:3 end:3
                a    4     start:1 end:3 ans:3 end:4
                b    5     start:2 end:4 ans:3 end:5
                c    6     start:3 end:5 ans:3 end:6
                b    7     start:5 end:6 ans:3 end:7
                b    8     start:7 end:7 ans:3 end:8
        */
        for(int start = 0, end = 0; end < n; end ++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                //set the start to the latest non-repeated string
                start = Math.max(map.get(c), start);    
            }
            //calculate the length of the longest non-repeated substring
            ans = Math.max(ans, end-start+1);
            map.put(c, end+1);
        }
        return ans;
    }
}