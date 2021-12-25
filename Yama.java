import java.util.*;

class Yama {
    public int kthFactor(int n, int k) {
        int count = 0, i;
        for (i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ++count;
                if (count == k)
                    return i;
            }
        }

        --i;
        if (i * i == n)
            --i;
        for (; i > 0; i--) {
            if (n % i == 0) {
                ++count;
                if (count == k)
                    return n / i;
            }
        }
        return -1;
    }

    public static int groupDivision(int[] levels, int maxSpread) {
        int count = 1;
        Arrays.sort(levels);

        int curr = levels[0];
        int i = 0;
        for (int level : levels) {
            if (level > curr + maxSpread) {
                ++count;
                ++i;
                curr = levels[i];
            }
        }
        System.out.println(count);
        return count;
    }

    public int[][] merge(int[][] intervals) {

        // edge case
        if (intervals.length == 0)
            return new int[0][2];

        // sort in ascending order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> ans = new LinkedList<>();

        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1] = Math.max(interval[1], ans.getLast()[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static int kOddElements(int[] numbers, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int[] lists = { 3, 2, 1, 4, 7 };
        int maxSpread = 2;
        groupDivision(lists, maxSpread);
    }
}