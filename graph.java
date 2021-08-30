import java.util.*;

class graph {
    public boolean courseSchedule(int numCourses, int[][] prerequisites) {
        //edge case
        if(numCourses <= 0) 
            return false;

    /*  
        given:
            numCourses:5
            prerequisites: [[4,0], [4,1], [3,1], [3,2]]

            map
        key     value
        0       4->null
        1       4->3->null
        2       3->null
        
           take,prereq 
        [ [  4 ,  0],
          [  4 ,  1],
          [  3 ,  1],
          [  3 ,  2] ]

        degree[0,0,0,2,2]
             i 0 1 2 3 4
    */ 
        int[] degree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
    
        //queue: 0 1 2
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] ==0) queue.add(i);
        } 

        //BFS
        while( !queue.isEmpty()){
            int temp = queue.poll();
            List<Integer> take = map.get(temp);
            for(int i = 0; take!=null && i <take.size(); i++){
                degree[take.get(i)]--;
                if(degree[take.get(i)] == 0) queue.add(take.get(i));
            }
        }

        for(int i = 0; i <numCourses; i++){
            if(degree[i]!= 0) return false;
        }
        return true;
    }
}