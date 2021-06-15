public class IsPalindrome {
    static boolean isPalindrome(String s) {
        //StringBuilder creates a resizable array
        StringBuilder y = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                y.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        System.out.println("A good input string is: "+y);

        StringBuilder rey = new StringBuilder(y).reverse();

        System.out.println("The reverse of input string is: "+rey);
        if(rey.toString().equals(y.toString())){
            System.out.println("So the input string is a palindrome");
            return true;
        }else{
            System.out.println("SO the input string is not a palindrome");
            return false;
        }
    }


    public static void main(String args[]){
      String arr= "A man, a plan, a canal: Panama";
      System.out.println("The input string is: " + arr);
      boolean ans = isPalindrome(arr);
    }
}
