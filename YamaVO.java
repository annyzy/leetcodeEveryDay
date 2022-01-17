import java.util.*;

class YamaVO{
    public int minMeetingRooms(int[][] intervals) {
        //O(nlog(n))
        Arrays.sort( intervals, (a,b)-> a[0]-b[0] );
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1]-b[1]);
        for(int[] interval: intervals){
            pq.offer(interval);
            if(pq.peek()[1] <= interval[0]) pq.poll();    
        }
        return pq.size();
    }    
}