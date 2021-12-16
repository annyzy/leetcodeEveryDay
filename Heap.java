import java.util.*;
import java.util.Queue;

class Heap {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        // edge case
        if (len < 1 || k < 1)
            return null;

        if (k == len)
            return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        Queue<Integer> heap = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));

        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll();
        }
        return top;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        // a hold for the head;
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;

            // find the right position
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // reconnect the list in the right order
            ListNode next = curr.next;
            prev.next = curr;
            curr.next = prev.next;

            // sort the iteration of the next target
            curr = next;

        }

        // hold to the head position
        return dummy.next;

    }

}