import java.util.*;

class Backtracking {
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
        
        StringBuilder str = new StringBuilder();
        letterCombinationsHelper(ans, str, map, digits, 0);
        return ans;
    }
    
    public void letterCombinationsHelper(List<String> ans, StringBuilder str, HashMap<Character, String> map, String digits, int i){
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
            //str: ad, ae....
            ans.add(str.toString());
        }else{
            char c = digits.charAt(i);
            String l = map.get(c);
            int count = l.length();
            for(int j = 0; j < count; j++ ){
                str.append(l.charAt(j));
                //i -> i+1: '2'->'3'
                // 2nd: letterCombinationsHelper({}, {a}, map, "23", 1)
                // 3rd: letterCombinationsHelper({ad}, {ad}, map, "23", 2) -> to base case: i==2, str={ad}
                letterCombinationsHelper(ans, str, map, digits, i + 1);
                //delete d -> a, e->a, f->a, a->b... to return to the previous state
                str.deleteCharAt(i);
            }
        }        
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int numsLen = nums.length;
        
        //edge case
        if(nums == null || numsLen == 0) return ans;
        
        LinkedList<Integer> path = new LinkedList<Integer>();
        
        permuteHelper(ans, nums, 0, path);
        return ans;
    }
    
    public void permuteHelper(List<List<Integer>> ans, int[] nums, int depth, LinkedList<Integer> path){
        /*
            example: [1,2,3]
                                        []
                       [1]               [2]              [3]
                   [1,2] [1, 3]     [2, 1] [2,3]      [3,1]  [3,2] 
                [1,2,3]   [1,3,2]  [2,1,3]  [2,3,1]  [3,1,2]  [3,2,1]
        */
        //base case
        if(depth == nums.length){
            //a new [] from state 1 tp state 2
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++ ){
            if(path.contains(nums[i])) continue;
            //add the number that has not been added
            path.add(nums[i]);
            //move down to the next state
            //[1]->[1,2]->[1,2,3]
            permuteHelper(ans, nums, depth + 1, path);
            //return up to the previos state
            //[1,2,3]->[1,2]->[1]
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Backtracking permuteAns = new Backtracking();
        List<List<Integer>> lists = permuteAns.permute(nums);
        System.out.println(lists);
    }
}