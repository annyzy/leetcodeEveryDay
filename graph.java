import java.util.*;

class graph {
    public boolean courseSchedule1(int numCourses, int[][] prerequisites) {
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
    
        //create a queue to store the node that has 0 degree, queue: 0 1 2
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] ==0) queue.add(i);
        } 

        //BFS
        while( !queue.isEmpty()){
            //start from the course that are the prereq to other courses
            int temp = queue.poll();
            //get a list of courses that can take after finishing the prereq
            List<Integer> take = map.get(temp);
            for(int i = 0; take!=null && i <take.size(); i++){
                //once reach a course from prereq, deduct the degree by 1(marked as visited)
                degree[take.get(i)]--;
                //once cannot reach any course from prereq, have done the breath first search of that prereq
                //put that course to the queue list,treat as 0 degree
                if(degree[take.get(i)] == 0) queue.add(take.get(i));
            }
        }

        for(int i = 0; i <numCourses; i++){
            //if a degree is not 0 for a node, means it cannot be reached
            if(degree[i]!= 0) return false;
        }
        return true;
    }

    public int[] courseSchedule2(int numCourses, int[][] prerequisites) {
        //edge case
        if(numCourses <= 0) 
            return null;

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
    
        int[] ans = new int[numCourses];
        int j = 0;
        //create a queue to store the node that has 0 degree, queue: 0 1 2
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] ==0) queue.add(i);
        } 

        //BFS
        while( !queue.isEmpty()){
            //start from the course that are the prereq to other courses
            int temp = queue.poll();
            //put the prereq to the ans array
            ans[j++] = temp;
            //get a list of courses that can take after finishing the prereq
            List<Integer> take = map.get(temp);
            for(int i = 0; take!=null && i <take.size(); i++){
                //once reach a course from prereq, deduct the degree by 1(marked as visited)
                degree[take.get(i)]--;
                //once cannot reach any course from prereq, have done the breath first search of that prereq
                //put that course to the queue list,treat as 0 degree
                if(degree[take.get(i)] == 0) queue.add(take.get(i));
            }
        }

        for(int i = 0; i <numCourses; i++){
            //if a degree is not 0 for a node, means it cannot be reached
            if(degree[i]!= 0) return new int[0];
        }
        return ans;
    }
}