import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        char[] list = password.toCharArray();
        boolean isCapsLock = true;
        for (int i=1; i<list.length; i++) {
            char c = list[i];
            //A-Z 65-90, a-z 97-122
            if ((int)c > 96 && (int)c < 123) {
                isCapsLock = false;
            }
        }
        char[] passwordChanged = new char[list.length];
        if (isCapsLock) {
            for (int i=0; i<list.length; i++) {
                char p = list[i];
                if (i == 0) {
                    if ((int)p > 64 && (int)p<91 ) {
                        passwordChanged[i] = (char) ((int)p + 32);
                    } else if ((int)p > 96 && (int)p<123) {
                        passwordChanged[i] = (char) ((int)p - 32);
                    }
                } else {
                    if ((int)p > 64 && (int)p<91 ) {
                        passwordChanged[i] = (char) ((int)p + 32);
                    }
                }
            }
            System.out.println(passwordChanged);

        } else {
            System.out.println(password);
        }


    }
}
