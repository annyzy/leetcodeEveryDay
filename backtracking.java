import java.util.*;

class backtracking {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();

        //edge case;
        if(n <=0) return ans;

        generateParenthesisHelper(ans, "", 0, 0, n);
        return ans;
    }

    public void generateParenthesisHelper(List<String> ans, String str, int l, int r, int num) {
        /*
            l=left parenthesis = 2
            r = right parenthesis = 2
                            l r
                            2 2

                            1 2
                            (
                        0 2      1 1
                        ( (      ( )
                        0 1      0 1
                        ( ()     ())
                        0 0      0 0
                        (())     ())
        */
        // base case
        if ((l == num) && (r == num)) {
            ans.add(str.toString());
            return;
        }
        if (l < num) {
            generateParenthesisHelper(ans, str + "(", l + 1, r, num);
        }
        if (l > r) {
            generateParenthesisHelper(ans, str + ")", l, r + 1, num);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        
        //edge case
        if(digits.length()==0) return ans;
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        letterCombinationsHelper(ans, new StringBuffer(), map, digits, 0);
        return ans;
    }
    
    public void letterCombinationsHelper(List<String> ans, StringBuffer str, HashMap<Character, String> map, String digits, int i){
        /*
                example: "23"
                           2
                  a        b        c
                  3        3        3
               d  e  f  d  e  f  d  e  f
               ad ae af bd be bf cd ce cf 
        */
        //base case
        if (i == digits.length()){
            ans.add(str.toString());
        }else{
            char c = digits.charAt(i);
            String l = map.get(c);
            int count = l.length();
            for(int j = 0; j < count; j++ ){
                str.append(letters.charAt(j));
                letterCombinationsHelper(ans, str, map, digits, i + 1);
                //delete d -> ae, e-> af, a-> bd.... to return to the previous state
                str.deleteCharAt(i);
            }
        }
    }
}