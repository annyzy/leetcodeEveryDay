import java.util.*;

public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    
    public void push(int val) {
        stack.push(val);
        System.out.println("stack has: " + stack.peek()); 

        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
            System.out.println("minStack has: " + minStack.peek()); 
        } 
        System.out.println("");   
    }
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())){
            minStack.pop();
            System.out.println("After poping the minStack, now the top of the minStack is: " + minStack.peek()); 
        }
        System.out.println("After poping the stack, now the top of the stack is: " + stack.peek()); 
        stack.pop();

        System.out.println("");
    }
    
    public int top() {
        System.out.println("The top of the stack is: " + stack.peek()); 
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();  
    }

    public static void main(String args[]){
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        int param_1 = obj.getMin();
        System.out.println("The min is: " + param_1); 
        obj.pop();
        int param_2 = obj.getMin();
        System.out.println("The min is: " + param_2); 
        obj.pop();
        int param_3 = obj.getMin(); 
        System.out.println("The min is: " + param_3); 

        System.out.println("");  

        MinStack obj_1 = new MinStack();
        obj_1.push(-2);
        obj_1.push(0);
        obj_1.push(-3);
        int param_4 = obj_1.getMin();
        System.out.println("The min is: " + param_4); 
        obj_1.pop();
        obj_1.top();
        int param_5 = obj_1.getMin();
        System.out.println("The min is: " + param_5);  
    }
}
