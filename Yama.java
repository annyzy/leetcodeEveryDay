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
        // System.out.println(count);
        return count;
    }

    public int[][] merge1(int[][] intervals) {

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

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        List<Interval> ans = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            int nstart = intervals.get(i).start;
            int nend = intervals.get(i).end;
            if (end >= nstart) {
                end = Math.max(end, nend);
            } else {
                ans.add(new Interval(start, end));
                start = nstart;
                end = nend;
            }
        }
        // add the last interval
        ans.add(new Interval(start, end));
        return ans;
    }

    public static int kOddElements(int[] numbers, int k) {
        // edge case
        if (k == 0)
            return 0;

        int len = numbers.length;
        boolean[] isOdd = new boolean[len];
        for (int i = 0; i < len; i++) {
            isOdd[i] = numbers[i] % 2 != 0;
        }

        HashSet<String> ans = new HashSet<String>();

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            int oddCount = 0;
            for (int j = i; j < len; j++) {
                if (isOdd[j]) {
                    oddCount++;
                    if (oddCount > k)
                        break;
                }
                sb.append(numbers[j]);
                ans.add(sb.toString());
            }
        }

        System.out.println("k odd elements: " + ans.size());
        return ans.size();
    }

    public static int maxSubjectsNumber(List<Integer> answered, List<Integer> needed, int q) {
        int ans = 0;

        // edge case
        if (answered.size() != needed.size()) {
            return ans;
        }

        int len = answered.size();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int a = needed.get(i) - answered.get(i);
            if (a <= 0) {
                temp.add(-1);
            } else {
                temp.add(a);
            }
        }

        // Arrays.sort(temp);
        int q1 = q;
        Collections.sort(temp);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) < 0)
                ++ans;
            else {
                q = q - temp.get(i);
                if (q >= 0) {
                    ++ans;
                } else {
                    q = q1;
                }

            }
        }

        return ans;
    }

    public static int[] commonPrefix1(String[] inputs) {
        // edge case
        if (inputs.length == 0)
            return null;
        int[] ans = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            ans[i] = sumSimilarities(inputs[i]);
        }

        return ans;
    }
    public static List<Integer> commonPrefix2(List<String> inputs) {
    //edge case
    if(inputs.size() == 0) return null;
    List<Integer> ans = new ArrayList<>();

    for(int i = 0; i < inputs.size(); i++){
    ans.add(sumSimilarities(inputs.get(i)));
    // System.out.println(ans.get(i));
    }

    return ans;
    }

    // Function to return the similarity sum
    static int sumSimilarities(String s) {
        int n = s.length();
        int[] Z = new int[n];

        int L, R, k;

        L = R = 0;
        for (int i = 1; i < n; ++i) {
            if (i > R) {
                L = R = i;
                while (R < n && s.charAt(R - L) == s.charAt(R))
                    R++;
                Z[i] = R - L;
                R--;
            } else {
                k = i - L;
                if (Z[k] < R - i + 1)
                    Z[i] = Z[k];
                else {
                    L = i;
                    while (R < n && s.charAt(R - L) == s.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }

        int total = 0;

        for (int i = 1; i < n; i++)
            total += Z[i];

        return total + n;
    }

    public static void main(String[] args) {
        String a = "ababa";
        String b = "aaabaab";
        String[] s = { "ababa", "aaabaab" };
        System.out.println(Arrays.toString(commonPrefix1(s)));

        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(commonPrefix2(list).toString());

        int[] lists = { 3, 2, 1, 4, 7 };
        int maxSpread = 2;
        groupDivision(lists, maxSpread);

        int[] lists1 = { 1, 2, 3, 4 };
        kOddElements(lists1, 1);

        List<Integer> ans = new ArrayList<>();
        ans.add(27);
        ans.add(0);
        ans.add(3);
        List<Integer> nee = new ArrayList<>();
        nee.add(51);
        nee.add(52);
        nee.add(100);
        System.out.println("max subjects: " + maxSubjectsNumber(ans, nee, 200));

        List<List<Integer>> intervals = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        ans.add(1);
        ans.add(3);
        ans.add(3);
        List<Integer> l2 = new ArrayList<>();
        nee.add(2);
        nee.add(5);
        intervals.add(l1);
        intervals.add(l2);

        Interval l3 = new Interval(1, 2);
        Interval l4 = new Interval(1, 3);
        List<Interval> l5 = new ArrayList<>();
        l5.add(l3);
        l5.add(l4);
        merge2(l5);
    }
}