import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution6 {
    private static List<Integer> convertArrToArrInt(String[] arr) {
        return Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int count(int n, String[] arr) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arrInt = convertArrToArrInt(arr);
        for (int i=0; i<n; i++) {
            int item = arrInt.get(i);
            if (i < n-1) {
                for (int j=i+1; j<n; j++) {
                    int itemIndex = arrInt.get(j);
                    if (item<itemIndex) {
                        if (!map.containsKey(j)) {
                            map.put(j, 1);
                            count++;
                            System.out.println(i + " -----> " + j);
                        } else {
                            int value = map.get(j);
                            map.put(j, value+1);
                            if (value < 2) {
                                count++;
                                System.out.println(i + " -----> " + j);
                            }
                        }

                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String inputFirst = scanner.nextLine();
        int n = Integer.parseInt(inputFirst);
        String inputSecond = scanner.nextLine();
        String[] arr = inputSecond.split(" ");
        int count = count(n, arr);
        System.out.println(count);
    }
}
