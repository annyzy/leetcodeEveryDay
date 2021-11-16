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

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };
        // edge case
        if (nums == null || nums.length == 0)
            return ans;

        ans[0] = searchLeftMost(nums, target);
        ans[1] = searchRightMost(nums, target);

        return ans;
    }

    // T: O(log n)
    public int searchLeftMost(int[] nums, int target) {
        int ans = -1;
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                ans = mid;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public int searchRightMost(int[] nums, int target) {
        int ans = -1;
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                ans = mid;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}