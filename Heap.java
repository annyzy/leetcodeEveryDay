import java.util.*;
import java.util.Queue;

class Heap {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        //edge case
        if(len < 1 || k < 1) return null;
        
        if(k==len) return nums;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        
        Queue<Integer> heap = new PriorityQueue<>((x,y) -> map.get(x)-map.get(y));
        
        for ( int num: map.keySet()){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        
        int[] top = new int[k];
        for(int i  = k - 1; i >=0; i --){
            top[i] = heap.poll();
        }
        return top;
    }
}