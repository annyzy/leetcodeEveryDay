import java.util.*;

class TwoPointer {
    // T: O(n)
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        // edge case
        if (n < 1)
            return 0;

        int left = 0, right = n - 1;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            // find the next possible larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}