import java.util.*;

class Queue {
    public String decodeString(String s) {
        //edge case
        if(s.isEmpty()) return null;
        Deque<Integer> num = new ArrayDeque<>();
        Deque<String> str = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                // convert char to int
                int j = c - '0';
                // if the next char is also a digit, such as 23
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    j = j * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num.push(j);
            } else if (c == '[') {
                str.push(ans.toString());
                ans = new StringBuilder();
            } else if (c == ']') {
                //tmp: ab
                StringBuilder tmp = new StringBuilder(str.pop());

                int multi = num.pop();
                // 3[ab] -> ababab
                for (int j = 0; j < multi; j++) {
                    tmp.append(ans);
                }
                ans = tmp;
                // if character
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}