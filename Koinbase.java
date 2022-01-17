import java.util.*;

class Koinbase{
    public static int segement(int[] space, int x ){
        int len = space.length;
        int[] min = new int[len-x+1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= len - x; i++){
            min[i] = Integer.MAX_VALUE;
            for(int j = i; j < i+x; j++){
                if(min[i] > space[j]){
                    min[i] = space[j];
                }
            }
            if(max < min[i]){
                max = min[i];
            }
        }

        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1_000_000;
        while( l < r){
            int mid = l + (r-l) /2;
            if(!possible(nums, mid, threshold)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    
    public boolean possible(int[] nums, int div, int thr){
        int count = 0;
        for(int n: nums){
            count += (n -1)/div + 1;
        }
        return count <= thr;
    }

    public static void main(String args[]){
        int[] space = {1,2,3,1,2};
        int x = 1;
        System.out.println(segement(space, x));
    }
}