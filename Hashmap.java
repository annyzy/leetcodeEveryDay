import java.util.*;

class Hashmap {
    //Easy: Two Sum
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i){
            if ( map.containsKey(target - nums[i]) ){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        //edge case
        if(nums.length < 1 || k < 1) return null;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        
        int[][] n = new int[1][2];
        int row = 0;
        for(int key:map.keySet() ){
            n[row][0]=key;
            n[row][1]=map.get(key);
            row++;
        }
        
        Arrays.sort(n, (x,y)->y[1]-x[1]);
        return null;
    }

    public int romanToInt(String s) {
        // edge case
        if (s.isEmpty())
            return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int ans = 0;
        int prev = map.get(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int num = map.get(s.charAt(i));
            // such as: IV=5-1
            if (prev < num) {
                ans = ans - prev;
                // such as: VI = 5+1
            } else {
                ans = ans + prev;
            }
            prev = num;
        }
        ans = ans + prev;
        return ans;
    }
}
