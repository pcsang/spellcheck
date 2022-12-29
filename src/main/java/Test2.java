import java.util.Scanner;

import static java.lang.System.out;

public class Test2 {
    private static final String test = "*#@";
    public static void main(String[] args)  {
        Scanner sc  = new Scanner(System.in);
        int input = 7;
        printOut(input);
    }

    public static void printOut(int input) {
        String result = "";
        for (int i = 1; i <= input+1; i++) {
            int index = i;
            String str = "";
            if (index > 3) {
                int number = i/3;
                index -= 3*number;
                if (index == 0) {
                    index = 1;
                }
                str = test.substring(index-1,index);
            } else {
                str = test.substring(index - 1, index);
            }
            result = result.concat(str);
            out.println(result);
        }
    }

}
