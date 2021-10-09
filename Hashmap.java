import java.util.*;

class Hashmap {
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
}