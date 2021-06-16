public class M2L{
    
    class ListNode{
      int val;
      ListNode next;

      public ListNode(){}
      public ListNode(int val){
        this.val = val;
        this.next = null;
      }
      public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
      }
    }

    public ListNode head = null;
    public ListNode end = null;

    public void appendToTail(int val){
      //ListNode end = new ListNode(val);

      // ListNode n = this;

      // while(n.next != null){ 
      //   n = n.next;
      // }
      // n.next = end;  
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
      // ListNode end = new ListNode(val);

      // ListNode n = this;
      // while(n.next != null){
      //   System.out.print(n.val + " ");   
      //   n = n.next;
      // } 
      //Need a node point to head  
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

        ListNode current = head;
        if(l1.val >= l2.val){
           System.out.println(l1.val); 
           System.out.println(l2.val); 
           System.out.println("Now l1.val >= l2.val: ");    
           current = l2; 
           System.out.println(current.val);               
           current.next = mergeTwoLists(l1, l2.next);

           return current;

        } else{
            System.out.println("Now l1.val < l2.val: ");  
            current = l1;                 
            current.next= mergeTwoLists(l1.next, l2);
            return current;
        }
    }

    public static void main(String[] args){
      M2L l1 = new M2L();
      l1.appendToTail(1);
      l1.appendToTail(2);
      System.out.print("The first list l1 is: ");
      l1.display();


      M2L l2 = new M2L();
      l2.appendToTail(1);
      l2.appendToTail(3);
      System.out.print("The second list l2 is: ");
      l2.display();
      
      // ListNode l = new ListNode();
      M2L l = new M2L();
      l = mergeTwoLists(l1,l2);
      System.out.print("Merge l1 and l2 gets l3 is: ");
      l.display();
    }
}

