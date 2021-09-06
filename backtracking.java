import java.util.*;

class backtracking {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
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
        // edge case
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
}