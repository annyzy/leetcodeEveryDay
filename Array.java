import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Array {
    public int[] twoSum(int[] nums, int target) {
        // edge case
        if (nums == null || nums.length < 2)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain))
                return new int[] { i, map.get(remain) };
            map.put(nums[i], i);
        }

        return null;
    }

    // T: O(n^2), O(n) in the "for loop" and O(n) within the "for loop" for "while
    // loop"
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // edge cases
        if (nums == null || len < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // if the first element in the sorted array is greater than 0, then no answer
            if (nums[i] > 0)
                break;

            // skip the element if duplicate, ensure that the l points starts from index 1
            /*
             * example: [-2, -2, 2, 2] i = 0: nums[i]==nums[i+1]: nums[0] = -2, nums[1] = -2
             * -> continue i > 0 && nums[i-1] == nums[i]: go -> l = 1
             * 
             * i = 1: nums[i]==nums[i+1]: nums[1] = -2, nums[2] = 2 -> go -> l = 2 i > 0 &&
             * nums[i-1] == nums[i]: nums[0] = -2, nums[1] = -2 -> continue
             * 
             * i = 2: nums[i]==nums[i+1]: nums[2] = 2, nums[3] = 2 -> continue i > 0 &&
             * nums[i-1] == nums[i]: nums[1] = -2, nums[2] = 2 -> go
             * 
             * i = 3: nums[i]==nums[i+1]: nothing i > 0 && nums[i-1] == nums[i]: nums[2] =
             * 2, nums[3] = 2 -> continue
             */

            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            int l = i + 1, r = len - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0)
                    l++;
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // skip duplicate
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    l++;
                    // skip duplicate
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    r--;
                }
                if (sum > 0)
                    r--;
            }
        }

        return ans;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int prev = 0, ans = nums[0];

        for (int x : nums) {
            /*
             * if the previous sum is smaller or equal x, trash the previous sum and restart
             * again from x
             */
            prev = Math.max(prev + x, x);
            // find max subarray
            ans = Math.max(ans, prev);
        }
        return ans;
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return null;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        // special case:[9,9,9]
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // create a 2D array to store the value of each row
        int[][] arr = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                // edge case: if there is only one row
                if (j == 0)
                    arr[i][j] = 1;

                // edge case: the start and the end of the row are all 1
                else if (j == i)
                    arr[i][j] = 1;

                // the current value equal the left plus right value of the previous row
                else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                row.add(arr[i][j]);
            }
            triangle.add(row);
        }
        return triangle;
    }

    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (prices == null || len == 0)
            return 0;
        int max = 0, profit = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < profit) {
                profit = prices[i];
            } else if (prices[i] - profit > max) {
                max = prices[i] - profit;
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (prices == null || len == 0)
            return 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            // greedy method: finding the local maxprofit at each stage
            max = max + Math.max(0, prices[i] - prices[i - 1]);
        }
        return max;
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            /*
             * return true is the element is not already present in the set, false if the
             * set already contains ans remain unchange
             */
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }

        // find the first element of the set, which is that single one
        int firstEle = 0;
        for (int val : set) {
            firstEle = val;
            break;
        }

        // return set.stream().findFirst().get();
        return firstEle;
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        // the median number
        return nums[nums.length / 2];
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            /*
             * return true is the element is not already present in the set, false if the
             * set already contains ans remain unchange
             */
            if (!set.add(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // numbers smaller than i*i might be checked before
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }

        return count;
    }

    public int[] intersectOfTwoArrays(int[] nums1, int[] nums2) {
        // edge cases
        if (nums1 == null || nums1.length == 0)
            return null;
        if (nums2 == null || nums2.length == 0)
            return null;
        if (nums1.length == 0 && nums2.length == 0)
            return null;
        // iterate the shorter array first to reduce the space complexity
        if (nums1.length > nums2.length)
            return intersectOfTwoArrays(nums2, nums1);

        /*
         * Creat a map to store the elements in nums1 as key, and the numbers of each
         * elements appears as value
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int x : nums1) {
            /*
             * count the value if a key is mapped, start from 0 if map contains no mapping
             * key
             */
            int count = map.getOrDefault(x, 0) + 1;
            map.put(x, count);
        }

        int[] ans = new int[nums1.length];
        int i = 0;
        for (int x : nums2) {
            /*
             * count the value if nums2'x key is mapped in nums1's, start from 0 if map
             * contains no mapping key
             */
            int count = map.getOrDefault(x, 0);
            // there is an intersection between two arrays
            if (count > 0) {
                ans[i] = x;
                i++;
                // remove that intersection
                count--;
                /*
                 * if an intersected nums has more than one update it's count after removing
                 * once
                 */
                if (count > 0) {
                    map.put(x, count);
                } else {
                    // only intersection once, then remove from the map after updating
                    map.remove(x);
                }
            }
        }
        /*
         * only get the range we need, otherwise there is a 0 in the end copy the range
         * from 0 to i of ans to a new array
         */
        return Arrays.copyOfRange(ans, 0, i);
    }

    public int romanToInt(String s) {
        // edge case
        if (s.isEmpty())
            return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int ans = 0;
        int prev = map.get(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int num = map.get(s.charAt(i));
            // such as: IV=5-1
            if (prev < num) {
                ans = ans - prev;
                // such as: VI = 5+1
            } else {
                ans = ans + prev;
            }
            prev = num;
        }
        ans = ans + prev;
        return ans;
    }

    public int titleToNumber(String columnTitle) {
        // edge cases
        if (columnTitle.isEmpty())
            return 0;
        for (char c : columnTitle.toCharArray()) {
            if (!Character.isUpperCase(c))
                return 0;
        }

        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            // Base 26 calculation
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.isEmpty() && t.isEmpty())
            return false;
        if (s.length() != t.length())
            return false;
        char s1[] = s.toCharArray();
        char t1[] = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }

    public int firstUniqChar(String s) {
        // edge case
        if (s.isEmpty())
            return -1;

        // requir contain only lower cases
        for (char c : s.toCharArray()) {
            if (!Character.isLowerCase(c))
                return -1;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // counts up the number of occurrences of each letter in s
            // -'a': "shifts" the ascii/unicode value so that A - Z have values 0 - 25.
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    // T:O(NlogN)
    public int findKthLargest(int[] nums, int k) {
        // edge case
        if (k < 0 || nums.length < 0)
            return -1;

        Arrays.sort(nums);
        int len = nums.length;
        int count = 1;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            ans = nums[i];
            if (count == k)
                return nums[i];
            count++;
            ans = nums[i - 1];
        }
        return ans;
    }

    public int[][] mergeIntervals(int[][] intervals) {
        // sort the intervals in asecending order by comparing each first value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // creat a arraylist to store the final answer
        LinkedList<int[]> ans = new LinkedList<>();
        // put in the first interval(sorted)
        ans.add(intervals[0]);

        for (int[] interval : intervals) {
            // add the interval to the answer linkedlist if the current interval start point
            // is bigger than the last interval's end point in the list
            if (ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                // update the end point of the last interval in the list
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public int subarraySum(int[] nums, int k) {
        // edge case
        if (nums == null || nums.length < 1)
            return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k)
                    count++;
            }
        }

        return count;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // edge case
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // instead of raw type: Map<String, List> ans = new HashMap<String, List>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            // convert current string to a character array
            char[] c = str.toCharArray();
            Arrays.sort(c);
            // return the sorted character array to a new string
            String newStr = String.valueOf(c);

            // only put the current sorted string into the map if it is not presented in the
            // map
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }

            // add the current str to the list that maps the newStr
            map.get(newStr).add(str);
        }

        // get a collection view of the map values;
        return new ArrayList(map.values());
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // edge case
        if (nums == null || len < 1)
            return;

        // example: [1,2,3,4,6,5]
        for (int i = len - 1; i > 0; i--) {
            // find 6 > 4
            if (nums[i] > nums[i - 1]) {
                for (int j = len - 1; j >= i; j--) {
                    // find 5>4, then wap 4 and 5
                    if (nums[j] > nums[i - 1]) {
                        int k = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = k;
                        break;
                    }
                }
                // now the number becomes 123564, then sort the number after 5 to ascending
                // order
                Arrays.sort(nums, i, len);
                return;
            }
        }
        // special case if such arrangment is impossible
        Arrays.sort(nums);
    }
}