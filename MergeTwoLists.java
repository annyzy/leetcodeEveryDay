public class MergeTwoLists{
    
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

    public static void main(String[] args){
      MergeTwoLists l1 = new MergeTwoLists();
      l1.appendToTail(1);
      l1.appendToTail(2);
      System.out.print("The first list l1 is: ");
      l1.display();


      MergeTwoLists l2 = new MergeTwoLists();
      l2.appendToTail(1);
      l2.appendToTail(3);
      System.out.print("The second list l2 is: ");
      l2.display();
     
      MergeTwoLists l3 = new MergeTwoLists();
      //return a node(ListNode), not MergeTwoLists
      l3.head = l3.mergeTwoLists(l1.head,l2.head);
      System.out.print("Merge l1 and l2 gets l3 is: ");
      l3.display();
    }
}
