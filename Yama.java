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
}