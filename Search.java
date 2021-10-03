import java.util.*;

class Search {
    public int SearchinRotatedSortedArray(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // edge case:
        if (len < 1)
            return -1;

        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        if (!map.containsKey(target)) {
            return -1;
        } else {
            return map.get(target);
        }
    }
}