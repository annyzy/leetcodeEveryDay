import java.util.*;

class Array {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int prev = 0, ans = nums[0];

        for (int x : nums) {
            // if the previous sum is smaller or equal x, trash the previous sum and restart
            // again from x
            prev = Math.max(prev + x, x);
            // find max subarray
            ans = Math.max(ans, prev);
        }
        return ans;
    }

    public int[] plusOne(int[] digits) {
        if(nums==null || nums.length == 0) return null;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        // special case:[9,9,9]
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // create a 2D array to store the value of each row
        int[][] arr = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                // edge case: if there is only one row
                if (j == 0)
                    arr[i][j] = 1;

                // edge case: the start and the end of the row are all 1
                else if (j == i)
                    arr[i][j] = 1;

                // the current value equal the left plus right value of the previous row
                else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                row.add(arr[i][j]);
            }
            triangle.add(row);
        }
        return triangle;
    }

    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i ++){
            nums1[m+i] = nums2[i];
        }   
        Arrays.sort(nums1);
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if(prices == null || len == 0) return 0;
        int max = 0, profit = Integer.MAX_VALUE;
        for (int i  = 0; i < len; i ++){
            if(prices[i]< profit){
                profit = prices[i];
            }else if(prices[i] - profit > max){
                max = prices[i] - profit;
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if(prices == null || len == 0) return 0;   
        int max = 0;
        for (int i  = 1; i < len; i ++){
            //greedy method: finding the local maxprofit at each stage
            max = max + Math.max(0, prices[i] -prices[i-1] );
        }
        return max;
    }

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i ++){
            //return true is the element is not already present in the set, false if the set already contains ans remain unchange
            if (!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        
        //find the first element of the set, which is that single one
        int firstEle = 0; 
        for(int val : set){
            firstEle = val;
            break;
        }
        
        // return set.stream().findFirst().get();
        return firstEle;
    }
}