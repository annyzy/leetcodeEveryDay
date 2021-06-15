import java.util.Arrays;
public class ReverseString {
    static String reverseString(char[] s) {
        for ( int l = 0 , r = s.length - 1; l < r; l++ , r--){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        } 
        return Arrays.toString(s); 
    }

    public static void main(String args[]){
      char arr[] = {'h','e','l'};
      System.out.println("The input array of string is: " + Arrays.toString(arr));
      String s = reverseString(arr);
      System.out.println("The reverse of input array of string is: " + s);
    }
}
