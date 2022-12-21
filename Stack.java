import java.util.*;

class Stack {
    // Easy: Valid Parentheses
    public boolean isValid(String s) {
        int len = s.length();

        //edge case
        if( len % 2 == 1) return false;

        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '['); 
                put('}', '{'); 
            }
        }; 
        Deque<Character> stack = new LinkedList<Character>();
      
        for ( int i = 0; i < len; ++i){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if ( stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }  
        return stack.isEmpty(); 
    }
}
