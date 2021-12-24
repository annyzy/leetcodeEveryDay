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

    public static void main(String[] args) {
        int[] lists = { 1, 4, 7, 3, 4 };
        int maxSpread = 2;
        groupDivision(lists, maxSpread);
    }
}