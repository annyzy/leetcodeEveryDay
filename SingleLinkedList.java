import java.util.*;

public class SingleLinkedList {

	class ListNode {
		int val;
		ListNode next, random;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
			this.random = random;
		}
	}

	public ListNode head = null;
	public ListNode end = null;

	public void appendToTail(int val) {
		ListNode temp = new ListNode(val);

		if (head == null) {
			head = temp;
			end = temp;
		} else {
			end.next = temp;
			end = temp;
		}
	}

	public void display() {
		ListNode curr = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}

		System.out.println();
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val >= l2.val) {
			System.out.println("Now l1.val >= l2.val: ");
			System.out.println("l1's val is: " + l1.val);
			System.out.println("l2's val is: " + l2.val);
			l2.next = mergeTwoLists(l1, l2.next);

			return l2;
		} else {
			System.out.println("Now l1.val < l2.val: ");
			System.out.println("l1's val is: " + l1.val);
			System.out.println("l2's val is: " + l2.val);
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head;
		while (curr != null && curr.next != null) {
			if (curr.next.val == curr.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}

	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> seenNodes = new HashSet<>();

		if (head == null) {
			System.out.println("Invalid cycle linked list: no head provided.");
			return false;
		}

		while (head != null) {
			if (seenNodes.contains(head)) {
				System.out.println("There is a cycle traverse to node value " + head.val + ", cycle found.");
				return true;
			}
			seenNodes.add(head);
			head = head.next;
		}
		System.out.println("No cycle found.");
		return false;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> set = new HashSet<ListNode>();

		if (headA == null)
			return null;
		if (headB == null)
			return null;

		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (set.contains(headB)) {
				System.out.println("The intersection node is : " + headB.val);
				return headB;
			}
			headB = headB.next;
		}

		System.out.println("There is no intersction node");
		return null;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;

		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {

			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}

		return prev;
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			System.out.println("Invalid palindrome list: no head provided.");
			return false;
		}

		List<Integer> list = new ArrayList<Integer>();

		ListNode curr = head;
		while (curr != null) {
			list.add(curr.val);
			curr = curr.next;
		}

		int front = 0;
		int back = list.size() - 1;

		while (front < back) {
			if (list.get(front) == list.get(back)) {
				front++;
				back--;
			} else {
				System.out.println("Not a palindrome");
				return false;
			}
		}
		System.out.println("Is a palindrome.");
		return true;
	}

	public void deleteNodeVersion1(ListNode node) {
		// Can't find the previous node of the target, so we simply replace the next
		// node's val to taget's val, and connect the "target" to the next of the next
		// node
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public void deleteNodeVersion2(int pos) {
		if (head == null)
			return;

		ListNode prev = head;

		// if delete head
		if (pos == 0) {
			head = prev.next;
			System.out.println("Delete position " + pos + " in linked list.");
			return;
		}

		// find the previous position of the target
		for (int i = 0; prev != null && i < pos - 1; i++)
			prev = prev.next;

		if (prev == null || prev.next == null) {
			System.out.println("The position " + pos + " you want to delete exceeds the number of nodes.");
			return;
		}

		// relink the previous position and the next position
		System.out.println("Delete position " + pos + " in linked list.");
		ListNode next = prev.next.next;
		prev.next = next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			System.out.println("Invalid two lists provided.");
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode a = l1, b = l2, curr = dummy;
		int carry = 0;

		while (a != null || b != null) {
			int val1, val2;
			if (a != null) {
				val1 = a.val;
				a = a.next;
			} else {
				val1 = 0;
			}

			if (b != null) {
				val2 = b.val;
				b = b.next;
			} else {
				val2 = 0;
			}

			int sum = val1 + val2 + carry;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
		}

		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummy.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			System.out.println("The list is invalid.");
			return null;
		}

		ListNode dummy = new ListNode(0, head);
		Deque<ListNode> stack = new ArrayDeque<ListNode>();
		ListNode curr = dummy;

		while (curr != null) {
			stack.push(curr);
			curr = curr.next;
		}

		for (int i = 0; i < n; i++) {
			stack.pop();
		}

		ListNode pre = stack.peek();
		System.out.println("Remove " + n + "th node from the end of the list.");
		pre.next = pre.next.next;
		return dummy.next;
	}

	public ListNode sortList(ListNode head) {
		// edge case
		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = cutHalf(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);

		ListNode ans = merge(left, right);
		return ans;
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode dummy = new ListNode();
		ListNode end = dummy;
		while (l1 != null && l2 != null) {
			// put the node with the smaller value from left to right
			if (l1.val < l2.val) {
				end.next = l1;
				l1 = l1.next;
			} else {
				end.next = l2;
				l2 = l2.next;
			}
			end = end.next;
		}
		if (l1 != null) {
			end.next = l1;
		} else {
			end.next = l2;
		}
		return dummy.next;
	}

	public ListNode cutHalf(ListNode head) {
		// edge case
		if (head == null)
			return null;
		ListNode slow = head, fast = head, slowPrev = null;

		while (fast != null && fast.next != null) {
			// store the node before the slow node
			slowPrev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// the node that is store is the half cut point
		ListNode mid = slowPrev.next;
		// cut the lists into half
		slowPrev.next = null;
		return mid;
	}

	public ListNode copyRandomList(ListNode head) {
		if (head == null)
			return null;

		ListNode curr = head;
		Map<ListNode, ListNode> map = new HashMap<>();

		while (curr != null) {
			map.put(curr, new ListNode(curr.val));
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			map.get(curr).next = map.get(curr.next);
			map.get(curr).random = map.get(curr.random);
			curr = curr.next;
		}

		return map.get(head);
	}

	public static void main(String[] args) {
		SingleLinkedList l1 = new SingleLinkedList();
		l1.appendToTail(1);
		l1.appendToTail(2);
		System.out.print("The first list l1 : ");
		l1.display();
		l1.isPalindrome(l1.head);
		l1.deleteNodeVersion2(0);
		System.out.print("The result list l1 : ");
		l1.display();

		System.out.println();
		SingleLinkedList l2 = new SingleLinkedList();
		l2.appendToTail(1);
		l2.appendToTail(3);
		System.out.print("The second list l2 : ");
		l2.display();
		l2.head = l2.removeNthFromEnd(l2.head, 1);
		System.out.print("The result list l2 : ");
		l2.display();
		l2.head = l2.addTwoNumbers(l1.head, l2.head);
		System.out.print("The result list l2 after adding l1 and l2 : ");
		l2.display();

		System.out.println();
		System.out.println("Merge l1 and l2 to l3:");
		SingleLinkedList l3 = new SingleLinkedList();
		// return a node(ListNode), not MergeTwoLists
		l3.head = l3.mergeTwoLists(l1.head, l2.head);
		System.out.print("The result list l3 : ");
		l3.display();

		System.out.println();
		System.out.println("Remove duplicate nodes in l3 :");
		l3.head = l3.deleteDuplicates(l3.head);
		System.out.print("The new list l3 : ");
		l3.display();

		System.out.println();
		System.out.println("Test whether there is a cycle in l4 : ");
		SingleLinkedList l4 = new SingleLinkedList();
		l4.appendToTail(1);
		l4.appendToTail(2);
		l4.appendToTail(5);
		System.out.print("The fourth list l4 : ");
		l4.display();
		l4.head.next.next = l4.head.next;
		l4.hasCycle(l4.head);

		System.out.println();
		System.out.println("Test whether there is a intersection node between l5 and l6 : ");
		SingleLinkedList l5 = new SingleLinkedList();
		l5.appendToTail(4);
		l5.appendToTail(1);
		l5.appendToTail(9);
		l5.appendToTail(4);
		l5.appendToTail(5);
		System.out.print("The fifth list l5 : ");
		l5.display();
		SingleLinkedList l6 = new SingleLinkedList();
		l6.appendToTail(5);
		l6.appendToTail(6);
		l6.appendToTail(4);
		l6.appendToTail(5);
		System.out.print("The sixth list l6 : ");
		l6.display();
		l6.head.next.next = l5.head.next.next.next;
		l5.head = l5.getIntersectionNode(l5.head, l6.head);

		System.out.println();
		SingleLinkedList l7 = new SingleLinkedList();
		l7.head = l6.reverseList(l6.head);
		System.out.print("Reverse l6 to get l7 : ");
		l7.display();
		l7.head = l7.sortList(l7.head);
		System.out.print("The result list l7 after sorting: ");
		l7.display();
	}
}
