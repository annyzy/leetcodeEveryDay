import java.util.*;

class bitManipulation {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // if n&1 = 1, then the least sig fig is 1; else 0
            count += n & 1;
            // shit to right by 1
            n = n >> 1;
        }
        return count;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int n = nums.length;

        // edge case
        if (nums.length == 0)
            return list;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            // generate 0..00 to 1.111
            String bitmask = Integer.toBinaryString(i).substring(1);

            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // append subset corresponding to the bitmask
                if (bitmask.charAt(j) == '1')
                    temp.add(nums[j]);
            }
            list.add(temp);
        }
        return list;
    }
}