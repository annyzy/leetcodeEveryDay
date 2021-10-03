import java.util.*;

class Search {
    // T: O(log n)
    public int SearchinRotatedSortedArray(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        return binarysearch(nums, 0, len - 1, target);
    }

    public int binarysearch(int[] nums, int l, int r, int target) {

        while (l <= r) {
            // get the middle position
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return m;

            // if [l,m] is ascending sorted order
            if (nums[l] <= nums[m]) {
                // search from [l,m-1]
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                    // search from [m+1,l]
                } else {
                    l = m + 1;
                }
                // if (m,r] is ascending sorted order
            } else {
                // search from [m+1,r]
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                    // search from [l,m-1]
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}