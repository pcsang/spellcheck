import static java.lang.System.out;

public class Fibonacci {
    public static int proccess(int n) {
        if (n < 1) {
            return 1;
        }
        if ( n == 1) {
            return 2;
        }
        return proccess(n-1) + proccess(n-2);
    }

    public static void main(String[] args) {
        int n = 19;
        for (int i = 1; i<=n; i++) {
            int result = proccess(i);
            out.println(i +" "+ result);
        }
    }
}
