import java.util.*;

class Array {
    public int maxSubArray(int[] nums) {
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
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        //special case:[9,9,9]
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}