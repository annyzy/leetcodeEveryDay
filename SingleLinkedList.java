import java.util.*;

public class SingleLinkedList {

	class ListNode {
		int val;
		ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
			this.next = null;
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
		ListNode current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
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
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
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

	public static void main(String[] args) {
		SingleLinkedList l1 = new SingleLinkedList();
		l1.appendToTail(1);
		l1.appendToTail(2);
		System.out.print("The first list l1 : ");
		l1.display();
		l1.isPalindrome(l1.head);

		System.out.println();
		SingleLinkedList l2 = new SingleLinkedList();
		l2.appendToTail(1);
		l2.appendToTail(3);
		System.out.print("The second list l2 : ");
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
	}
}
