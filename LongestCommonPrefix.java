import java.util.Arrays;
public class LongestCommonPrefix{
    static String longestCommonPrefix(String[] strs) 
    {
        //edge case: array empty
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i ++)
        {
            System.out.println("String " + strs[i] + " with index of prefix "+ strs[i].indexOf(prefix));  
            while(strs[i].indexOf(prefix) != 0){            
              prefix = prefix.substring(0, prefix.length() - 1);
              System.out.print("Now the prefix is : ");System.out.println(prefix);
              if(prefix.isEmpty())
              {
                  System.out.println("Prefix is empty now");
                  return "";
              }
            }
        }
        return prefix;
    }

    public static void main(String args[]){
      String arr[] = {"flower", "flow", "flight"};
      System.out.println("The input array of string is: " + Arrays.toString(arr));
      String ans = longestCommonPrefix(arr);
      System.out.println("The longest common prefix is " + ans);
    }
}

