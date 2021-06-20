import java.util.*;
public class SingleLinkedList{
    
    class ListNode{
      int val;
      ListNode next;

      public ListNode(){}
      public ListNode(int val){
		this.val = val;
        this.next = null;
      }
    }

    public ListNode head = null;
    public ListNode end = null;

    public void appendToTail(int val){ 
		ListNode temp = new ListNode(val);

		if(head == null){
			head = temp;
			end = temp;
		}
		else{
			end.next = temp;
			end = temp;
		}
	}

    public void display(){
		ListNode current = head;
		if(head == null){
		System.out.println("List is empty");
			return;
      }
      while(current != null){
		System.out.print(current.val + " ");
		current = current.next;
      }

      System.out.println();
    }
 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1; 

        if(l1.val >= l2.val){
			System.out.println("Now l1.val >= l2.val: ");
			System.out.println("l1's val is: " + l1.val);
			System.out.println("l2's val is: " +l2.val);
			l2.next = mergeTwoLists(l1, l2.next);

			return l2;
        } else{
			System.out.println("Now l1.val < l2.val: ");
			System.out.println("l1's val is: " +l1.val);
			System.out.println("l2's val is: " +l2.val);
			l1.next= mergeTwoLists(l1.next, l2);
			return l1;
        }
    }
    
	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
        while (current != null && current.next != null){
            if(current.next.val == current.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
    
	public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seenNodes = new HashSet<>();
        
        if( head == null ) return false;
        
        while(head != null ){
            if(seenNodes.contains(head)){
				System.out.println("There is a cycle traverse to node value " + head.val);
                return true;
            }
            seenNodes.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args){
		SingleLinkedList l1 = new SingleLinkedList();
		l1.appendToTail(1);
		l1.appendToTail(2);
		System.out.print("The first list l1 : ");
		l1.display();


		SingleLinkedList l2 = new SingleLinkedList();
		l2.appendToTail(1);
		l2.appendToTail(3);
		System.out.print("The second list l2 : ");
		l2.display();
     
      
		System.out.println();
		System.out.println("Merge l1 and l2 to l3:");
		SingleLinkedList l3 = new SingleLinkedList();
		//return a node(ListNode), not MergeTwoLists
		l3.head = l3.mergeTwoLists(l1.head,l2.head);
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
		if (l4.hasCycle(l4.head)){
			System.out.println("Cycle found in l4");
		} else{
			System.out.println("No cycle found in l4");
		}
		
		}
}
