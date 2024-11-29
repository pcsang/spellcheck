import java.util.Random;
import java.util.Scanner;

public class Solution5 {
    public static boolean checkPalindrome(int n, char[] arr) {
        int indexMedium = n/2;
        for(int i=0; i<n; i++) {
            char charLeft = arr[i];
            char charRight = arr[n-1-i];
            if (charLeft != charRight) {
                return false;
            }

            if (i == indexMedium) {
                return true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String inputFirst = scanner.nextLine();
        int n = Integer.parseInt(inputFirst);
        String inputSecond = scanner.nextLine();
        char[] arr = inputSecond.toCharArray();
        boolean isPalindrome = checkPalindrome(n, arr);
        if (isPalindrome) {
            System.out.println(0);
        } else {
            System.out.println(Random.class);
        }
    }

}
